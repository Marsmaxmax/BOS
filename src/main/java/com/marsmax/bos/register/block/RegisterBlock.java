package com.marsmax.bos.register.block;

import static com.marsmax.bos.register.block.custom.preset.CustomBlockPresets.*;

import java.util.function.Supplier;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.worldgen.tree.TestTreeGrower;
import com.marsmax.bos.register.item.RegisterItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class RegisterBlock {
    public static final DeferredRegister<Block> BLOCKS  = DeferredRegister.create(ForgeRegistries.BLOCKS, Bos.MODID);

    public static final RegistryObject<Block> LAUNCHPAD = registerBlock("launchpad", () -> MachineBlock());

    public static final RegistryObject<Block> ARC_FURNANCE = registerBlock("arc_furnance", () -> ArcFurnanceBlock());

    public static final RegistryObject<Block> LATHE = registerBlock("lathe", () -> LatheBlock());


    public static final RegistryObject<Block> IRIDIUM_ORE = registerBlock("iridium_ore", () -> OreBlock());

    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = registerBlock("deepslate_iridium_ore", () -> OreBlock());

    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block", () -> MetalBlock());

    public static final RegistryObject<Block> IRIDIUM_COIL = registerBlock("iridium_coil", () -> CoilBlock());


    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () -> OreBlock());

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> OreBlock());

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",  () -> MetalBlock());

    public static final RegistryObject<Block> TIN_COIL = registerBlock("tin_coil", () -> MetalBlock());


    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore", () -> OreBlock());
    
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore", () -> OreBlock());
    
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", () -> MetalBlock());

    public static final RegistryObject<Block> TITANIUM_COIL = registerBlock("titanium_coil", () -> MetalBlock());


    public static final RegistryObject<Block> DILITHIUM_ORE = registerBlock("dilithium_ore", () -> OreBlock());

    public static final RegistryObject<Block> DILITHIUM_BLOCK = registerBlock("dilithium_block", () -> MetalBlock());

                                                                
    public static final RegistryObject<Block> BAUXIT_ORE = registerBlock("bauxit_ore", () -> OreBlock());

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registerBlock("aluminium_block", () -> MetalBlock());

    public static final RegistryObject<Block> ALUMINIUM_COIL = registerBlock("aluminium_coil", () -> MetalBlock());


    public static final RegistryObject<Block> MOON_TURF = registerBlock("moon_turf", () -> SandBasedBlock());

    public static final RegistryObject<Block> DARK_MOON_TURF = registerBlock("dark_moon_turf", () -> SandBasedBlock());

    public static final RegistryObject<Block> MOON_ROCK = registerBlock("moon_rock", () -> RockBasedBlock());

    public static final RegistryObject<Block> CHISSLED_MOON_ROCK = registerBlock("chissled_moon_rock", () -> RockBasedBlock());

    public static final RegistryObject<Block> SMOOTH_MOON_ROCK = registerBlock("smooth_moon_rock", () -> RockBasedBlock());

    public static final RegistryObject<Block> MOON_BRICKS = registerBlock("moon_bricks", () -> RockBasedBlock());


    public static final RegistryObject<Block> STRIPPED_TEST_LOG = registerBlock("stripped_test_log", () -> StrippedLogBlock(true));

    public static final RegistryObject<Block> TEST_LOG = registerBlock("test_log", () -> LogBlock(true, STRIPPED_TEST_LOG));

    public static final RegistryObject<Block> STRIPPED_TEST_WOOD = registerBlock("stripped_test_wood", () -> StrippedWoodBlock(true));

    public static final RegistryObject<Block> TEST_WOOD = registerBlock("test_wood", () -> WoodBlock(true, STRIPPED_TEST_WOOD));

    public static final RegistryObject<Block> TEST_PLANKS = registerBlock("test_planks", () -> PlanksBlock(true));

    public static final RegistryObject<Block> TEST_LEAVES = registerBlock("test_leaves", () -> LeavesBlock(true));

    public static final RegistryObject<Block> TEST_SAPLING = registerBlock("test_sapling", () -> ModSaplingBlock(new TestTreeGrower()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegisterItem.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
