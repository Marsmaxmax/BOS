package com.marsmax.bos.register.block.custom.preset;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.registries.RegistryObject;

public class CustomBlockPresets {
    /**
     * Used for Metal Blocks like Steel Block
     */
    public static Block MetalBlock() {
        return new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f));
    }

    /**
     * Used for Metal Coils
     */
    public static Block CoilBlock() {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f));
    }

    /**
     * Used for Ore Blocks like Dilithium Ore
     */
    public static Block OreBlock() {
        return new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,6));
    }

    /**
     * Used for Machine Blocks like Launchpad
     */
    public static Block MachineBlock() {
        return new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f));
    }

    /**
     * Used for Sand Based Blocks like Moon Turf
     */
    public static Block SandBasedBlock() {
        return new Block(BlockBehaviour.Properties.of(Material.SAND).strength(3f));
    }

    /**
     * Used for Rock Based Blocks like Moon Stone
     */
    public static Block RockBasedBlock() {
        return new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f));
    }

    /**
     * Used for Logs
     */
    public static ModFlammableRotatedPillarBlock LogBlock(Boolean flamable, RegistryObject<Block> stripped_var) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f)){

            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }

            @Override
            public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
                if(context.getItemInHand().getItem() instanceof AxeItem) {

                    return stripped_var.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
        
                return super.getToolModifiedState(state, context, toolAction, simulate);
            }

        };
    }

    /**
     * Used for Stripped Logs
     */
    public static Block StrippedLogBlock(Boolean flamable) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }

            
        };
    }

    /**
     * Used for Wood
     */
    public static Block WoodBlock(Boolean flamable, RegistryObject<Block> stripped_var) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5f)){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }

            @Override
            public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
                if(context.getItemInHand().getItem() instanceof AxeItem) {

                    return stripped_var.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
        
                return super.getToolModifiedState(state, context, toolAction, simulate);
            }
        };
    }

    /**
     * Used for Stripped Wood
     */
    public static Block StrippedWoodBlock(Boolean flamable) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f)){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }
        };
    }

    /**
     * Used for Planks
     */
    public static Block PlanksBlock(Boolean flamable) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return 5;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return 20;
            }
        };
    }

    /**
     * Used for Leaves
     */
    public static Block LeavesBlock(Boolean flamable) {
        return new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return flamable;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return 30;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                return 60;
            }
        };
    }

    /**
     * Used for Saplings
     */
    public static Block ModSaplingBlock(AbstractTreeGrower treeGrower) {
        return new SaplingBlock(treeGrower, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING));
    }
}
