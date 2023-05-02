package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.registerItem;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Bos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(registerItem.ASTEROID_CHIP);
        simpleItem(registerItem.ELEVATOR_CHIP);
        simpleItem(registerItem.PLANET_CHIP);
        simpleItem(registerItem.SATELLITE_CHIP);
        simpleItem(registerItem.STATION_CHIP);

        simpleItem(registerItem.ADV_CIRCUIT);
        simpleItem(registerItem.BASIC_CIRCUIT);
        simpleItem(registerItem.CONTR_CIRCUIT);
        simpleItem(registerItem.TRACK_CIRCUIT);
        simpleItem(registerItem.ITEM_CIRCUIT);
        simpleItem(registerItem.LIQUID_CIRCUIT);

        simpleItem(registerItem.DILITHIUM_CRYSTAL);
        simpleItem(registerItem.DILITIUM_DUST);

        simpleItem(registerItem.IRIDIUM_INGOT);
        simpleItem(registerItem.IRIDIUM_RAW);

        simpleItem(registerItem.TIN_INGOT);
        simpleItem(registerItem.TIN_RAW);
        simpleItem(registerItem.TITANIUM_INGOT);
        simpleItem(registerItem.TITANIUM_RAW);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Bos.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Bos.MODID,"item/" + item.getId().getPath()));
    }
}
