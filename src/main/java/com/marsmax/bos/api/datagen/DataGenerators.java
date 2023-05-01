package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= Bos.MODID, bus = Mod.EventBusSubscriber.bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExisitingFileHelper();

        generator.addProvider(true, ModRecipeProvider(packOutput));
        generator.addProvider(true, ModLootTableProvider.create(packOutput));
        generator.addProvider(true, ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, ModItemModelProvider(packOutput, existingFileHelper));
    }
}
