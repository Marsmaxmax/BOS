package com.marsmax.bos.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class Launchpad extends Block {
    public Launchpad(){
        super(BlockBehaviour.Properties.of(Material.STONE).strength(4f));
    }
}
