package com.marsmax.bos.register.block.entity;

import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.marsmax.bos.register.block.custom.LatheBlock;
import com.marsmax.bos.register.item.RegisterItem;
import com.marsmax.bos.register.recipe.LatheRecipe;
import com.marsmax.bos.util.energy.CustomEnergyStorage;
import com.marsmax.bos.util.networking.CustomMessages;
import com.marsmax.bos.util.networking.packet.EnergySyncS2CPacket;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class LatheBlockEntity extends BlockEntity implements MenuProvider{

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> true;
                case 1 -> true;
                case 2 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };


    private final CustomEnergyStorage ENERGY_STORAGE = new CustomEnergyStorage(60000, 256) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            CustomMessages.sendToClients(new EnergySyncS2CPacket(this.energy, getBlockPos()));
        }
    };

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    public IEnergyStorage getEnergyStorage() {
        return ENERGY_STORAGE;
    }
    public void setEnergyLevel(int energy) {
        this.ENERGY_STORAGE.setEnergy(energy);
    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
    Map.of( Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
            Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 0, (i, s) -> false)),
            Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                    (index, stack) -> itemHandler.isItemValid(1, stack))),
            Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 2,
                    (index, stack) -> itemHandler.isItemValid(2, stack))),
            Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 0,
                    (index, stack) -> itemHandler.isItemValid(0, stack))),
            Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0 || index == 1,
                    (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public LatheBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlockEntities.LATHE.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> LatheBlockEntity.this.progress;
                    case 1 -> LatheBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> LatheBlockEntity.this.progress = value;
                    case 1 -> LatheBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }
    //MENU
    @Override
    public Component getDisplayName() {
        return Component.literal("Lathe");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        // return new LatheMenu(id, inventory, this, this.data);
        return null;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }
            if(directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(LatheBlock.FACING);
                if(side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }
                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("lathe.progress", this.progress);
        nbt.putInt("lathe.energy", ENERGY_STORAGE.getEnergyStored());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("lathe.progress");
        ENERGY_STORAGE.setEnergy(nbt.getInt("lathe.energy"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    //Crafting
    public static void tick(Level level, BlockPos pos, BlockState state, LatheBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasGemInFirstSlot(pEntity)) {
            pEntity.ENERGY_STORAGE.receiveEnergy(100, false);
        }

        if(hasRecipe(pEntity) && hasEnoughEnergy(pEntity)) {
            pEntity.progress++;
            extractEnergy(pEntity);
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }

    }

    private static void craftItem(LatheBlockEntity pEntity) {

        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }
        Optional<LatheRecipe> recipe = level.getRecipeManager().getRecipeFor(LatheRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
             pEntity.itemHandler.extractItem(0, 1, false);
             pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(null).getItem(),
                pEntity.itemHandler.getStackInSlot(2).getCount() + 1));
            pEntity.resetProgress();
        }
    }
    private static boolean hasRecipe(LatheBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<LatheRecipe> recipe = level.getRecipeManager().getRecipeFor(LatheRecipe.Type.INSTANCE, inventory, level);


        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem(null)) && hasDrillInSlot(entity,0);
    

    }

    private static void extractEnergy(LatheBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<LatheRecipe> recipe = level.getRecipeManager().getRecipeFor(LatheRecipe.Type.INSTANCE, inventory, level);
        pEntity.ENERGY_STORAGE.extractEnergy(recipe.get().getEnergy(), false);
    }

    private static boolean hasGemInFirstSlot(LatheBlockEntity pEntity) {
        return pEntity.itemHandler.getStackInSlot(0).getItem() == RegisterItem.ALUMINIUM_INGOT.get();
    }

    private static boolean hasEnoughEnergy(LatheBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<LatheRecipe> recipe = level.getRecipeManager().getRecipeFor(LatheRecipe.Type.INSTANCE, inventory, level);
        return pEntity.ENERGY_STORAGE.getEnergyStored() >= recipe.get().getEnergy() * pEntity.maxProgress;
    }
    private static boolean hasDrillInSlot(LatheBlockEntity pEntity,int slot){
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<LatheRecipe> recipe = level.getRecipeManager().getRecipeFor(LatheRecipe.Type.INSTANCE, inventory, level);
        if(pEntity.itemHandler.getStackInSlot(0).getItem() == recipe.get().getDrill().getItem()){
            return true;
        } else {
            return false;
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
