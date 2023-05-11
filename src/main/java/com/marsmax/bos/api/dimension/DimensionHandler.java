package com.marsmax.bos.api.dimension;

import static com.marsmax.bos.Bos.id;

import java.util.function.BiFunction;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;



public class DimensionHandler {
    
    public static final ResourceKey<Level> DIMENSION_ID_PLANET_A = registerDimKey("planet_a");
    public static final ResourceKey<Level> DIMENSION_ID_PLANET_B = registerDimKey("planet_b");

    public static void bootstrap(BootstapContext<Level> context) {
        // Register custom dimensions
        register(DIMENSION_ID_PLANET_A, BuiltinDimensionTypes.OVERWORLD);
        register(DIMENSION_ID_PLANET_B, BuiltinDimensionTypes.OVERWORLD);
    }

    private static ResourceKey<Level> registerDimKey(String dimid) {
        return ResourceKey.create(Registries.DIMENSION, id(dimid));
    }

    private static void register(BootstapContext<Level> context, ResourceKey<Level> key, Level level, DimensionType dimensionType) {
        context.register(key, new Level(level, dimensionType));
    }

}