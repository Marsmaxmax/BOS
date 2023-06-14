package com.marsmax.bos.api.worldgen;

import java.util.List;

import com.marsmax.bos.Bos;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacedFeatures {
    //public static final ResourceKey<PlacedFeature> TEST_PLACED_KEY = createKey("TEST_placed");
    public static final ResourceKey<PlacedFeature> TITANIUM_PLACED_KEY = createKey("titanium_placed");
    public static final ResourceKey<PlacedFeature> TIN_PLACED_KEY = createKey("tin_placed");
    public static final ResourceKey<PlacedFeature> IRIDIUM_PLACED_KEY = createKey("iridium_placed");
    public static final ResourceKey<PlacedFeature> DILITHIUM_PLACED_KEY = createKey("dilithium_placed");
    public static final ResourceKey<PlacedFeature> BAUXITE_PLACED_KEY = createKey("bauxite_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //register(context, TEST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TEST_KEY),
        //        VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), RegisterBlock.TEST_SAPLING.get()));

        register(context, TITANIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TITANIUM_ORE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, IRIDIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IRIDIUM_ORE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, DILITHIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DILITHIUM_ORE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, BAUXITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BAUXITE_ORE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(60), VerticalAnchor.absolute(64))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Bos.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context,
                                ResourceKey<PlacedFeature> key, 
                                Holder<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}