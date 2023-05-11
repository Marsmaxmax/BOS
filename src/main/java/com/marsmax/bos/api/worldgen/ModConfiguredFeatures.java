package com.marsmax.bos.api.worldgen;


import com.marsmax.bos.register.RegisterBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.marsmax.bos.Bos.id;

public class ModConfiguredFeatures {
    //public static final ResourceKey<ConfiguredFeature<?, ?>> TESTTREE_KEY = registerKey("test");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_OVERWORLD_KEY = registerKey("titanium_ore_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_OVERWORLD_KEY = registerKey("tin_ore_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRIDIUM_ORE_OVERWORLD_KEY = registerKey("iridium_ore_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DILITHIUM_ORE_OVERWORLD_KEY = registerKey("dilithium_ore_overworld");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldTitaniumOres = List.of(OreConfiguration.target(stoneReplaceables,
                RegisterBlock.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, RegisterBlock.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

        register(context, TITANIUM_ORE_OVERWORLD_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));
        register(context, TIN_ORE_OVERWORLD_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                RegisterBlock.TIN_ORE.get().defaultBlockState(), 9));
        register(context, IRIDIUM_ORE_OVERWORLD_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                RegisterBlock.IRIDIUM_ORE.get().defaultBlockState(), 9));
        register(context, DILITHIUM_ORE_OVERWORLD_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                RegisterBlock.DILITHIUM_ORE.get().defaultBlockState(), 9));

        //register(context, TESTTREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        //        BlockStateProvider.simple(RegisterBlock.TEST_LOG.get()),
        //        new StraightTrunkPlacer(5, 6, 3),
        //        BlockStateProvider.simple(RegisterBlock.TEST_LEAVES.get()),
        //        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
        //        new TwoLayersFeatureSize(1, 0, 2)).build());
        //tree builder
    }


    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
