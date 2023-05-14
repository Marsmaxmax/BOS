package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.RegisterItem;

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

        simpleItem(RegisterItem.ASTEROID_CHIP);
        simpleItem(RegisterItem.ELEVATOR_CHIP);
        simpleItem(RegisterItem.PLANET_CHIP);
        simpleItem(RegisterItem.SATELLITE_CHIP);
        simpleItem(RegisterItem.STATION_CHIP);

        simpleItem(RegisterItem.SPACESUIT_HELMET);
        simpleItem(RegisterItem.SPACESUIT_CHESTPLATE);
        simpleItem(RegisterItem.SPACESUIT_LEGGINGS);
        simpleItem(RegisterItem.SPACESUIT_BOOTS);
        simpleItem(RegisterItem.NETHER_SPACESUIT_HELMET);
        simpleItem(RegisterItem.NETHER_SPACESUIT_CHESTPLATE);
        simpleItem(RegisterItem.NETHER_SPACESUIT_LEGGINGS);
        simpleItem(RegisterItem.NETHER_SPACESUIT_BOOTS);

        simpleItem(RegisterItem.ADV_CIRCUIT);
        simpleItem(RegisterItem.BASIC_CIRCUIT);
        simpleItem(RegisterItem.CONTR_CIRCUIT);
        simpleItem(RegisterItem.TRACK_CIRCUIT);
        simpleItem(RegisterItem.ITEM_CIRCUIT);
        simpleItem(RegisterItem.LIQUID_CIRCUIT);

        simpleItem(RegisterItem.DILITHIUM_CRYSTAL);
        simpleItem(RegisterItem.DILITIUM_DUST);

        simpleItem(RegisterItem.IRIDIUM_INGOT);
        simpleItem(RegisterItem.IRIDIUM_RAW);
        simpleItem(RegisterItem.IRIDIUM_SHEET);

        simpleItem(RegisterItem.TIN_INGOT);
        simpleItem(RegisterItem.TIN_RAW);
        simpleItem(RegisterItem.TIN_SHEET);

        simpleItem(RegisterItem.TITANIUM_INGOT);
        simpleItem(RegisterItem.TITANIUM_RAW);
        simpleItem(RegisterItem.TITANIUM_SHEET);
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
