package com.marsmax.bos.register.custom;

import net.minecraft.world.level.material.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.DropExperienceBlock;

public class CustomBlockPresets {
    /**
     * Used for Metal Blocks like Steel Block
     */
    public static Block MetalBlock() {
        return new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f));
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
}
