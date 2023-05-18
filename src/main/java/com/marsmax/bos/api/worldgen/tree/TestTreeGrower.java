package com.marsmax.bos.api.worldgen.tree;

import javax.annotation.Nullable;

import com.marsmax.bos.api.worldgen.ModConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TestTreeGrower extends AbstractTreeGrower{
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.TESTTREE_KEY;
    }
}
//TREE grower