package com.marsmax.bos.register.item;


import static com.marsmax.bos.register.item.custom.preset.CustomItemPresets.*;
import com.marsmax.bos.Bos;
import com.marsmax.bos.register.armor.RegisterModArmorMaterials;
import com.marsmax.bos.register.armor.custom.NetherSpacesuitArmorItem;
import com.marsmax.bos.register.armor.custom.SpacesuitArmorItem;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bos.MODID);

    public static final RegistryObject<Item> ELEVATOR_CHIP = ITEMS.register("elevator_chip", () -> item());

    public static final RegistryObject<Item> STATION_CHIP = ITEMS.register("station_chip", () -> item());

    public static final RegistryObject<Item> ASTEROID_CHIP = ITEMS.register("asteroid_chip", () -> item());

    public static final RegistryObject<Item> PLANET_CHIP = ITEMS.register("planet_chip", () -> item());

    public static final RegistryObject<Item> SATELLITE_CHIP = ITEMS.register("satellite_chip", () -> item());

    public static final RegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit", () -> item());

    public static final RegistryObject<Item> ADV_CIRCUIT = ITEMS.register("adv_circuit", () -> item());

    public static final RegistryObject<Item> TRACK_CIRCUIT = ITEMS.register("track_circuit", () -> item());

    public static final RegistryObject<Item> CONTR_CIRCUIT = ITEMS.register("contr_circuit", () -> item());

    public static final RegistryObject<Item> ITEM_CIRCUIT = ITEMS.register("item_circuit", () -> item());

    public static final RegistryObject<Item> LIQUID_CIRCUIT = ITEMS.register("liquid_circuit", () -> item());


    public static final RegistryObject<Item> SPACESUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_BOOTS = ITEMS.register("space_suit_boots", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_HELMET = ITEMS.register("nether_space_suit_helmet", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_CHESTPLATE = ITEMS.register("nether_space_suit_chestplate", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_LEGGINGS = ITEMS.register("nether_space_suit_leggings", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_BOOTS = ITEMS.register("nether_space_suit_boots", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.BOOTS, new Item.Properties()));



    public static final RegistryObject<Item> DILITIUM_DUST = ITEMS.register("dilithium_dust", () -> item());

    public static final RegistryObject<Item> DILITHIUM_CRYSTAL = ITEMS.register("dilithium_crystal", () -> item());
    


    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register("iridium_raw", () -> item());

    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> item());

    public static final RegistryObject<Item> IRIDIUM_SHEET = ITEMS.register("iridium_sheet", () -> item());

    public static final RegistryObject<Item> IRIDIUM_DUST = ITEMS.register("iridium_dust", () -> item());

    public static final RegistryObject<Item> IRIDIUM_ROD = ITEMS.register("iridium_rod", () -> item());

    public static final RegistryObject<Item> IRIDIUM_ROD_DRILLED = ITEMS.register("iridium_rod_drilled", () -> item());



    public static final RegistryObject<Item> TIN_RAW = ITEMS.register("tin_raw", () -> item());

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> item());

    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", () -> item());

    public static final RegistryObject<Item> TIN_SHEET = ITEMS.register("tin_sheet", () -> item());

    public static final RegistryObject<Item> TIN_ROD = ITEMS.register("tin_rod", () -> item());

    public static final RegistryObject<Item> TIN_ROD_DRILLED = ITEMS.register("tin_rod_drilled", () -> item());



    public static final RegistryObject<Item> TITANIUM_RAW = ITEMS.register("titanium_raw", () -> item());

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> item());

    public static final RegistryObject<Item> TITANIUM_SHEET = ITEMS.register("titanium_sheet", () -> item());

    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", () -> item());

    public static final RegistryObject<Item> TITANIUM_ROD = ITEMS.register("titanium_rod", () -> item());

    public static final RegistryObject<Item> TITANIUM_ROD_DRILLED = ITEMS.register("titanium_rod_drilled", () -> item());



    public static final RegistryObject<Item> SILICON_INGOT = ITEMS.register("silicon_ingot", () -> item());



    public static final RegistryObject<Item> BAUXITE_RAW = ITEMS.register("bauxite_raw", () -> item());

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> item());
    
    public static final RegistryObject<Item> ALUMINIUM_SHEET = ITEMS.register("aluminium_sheet", () -> item());

    public static final RegistryObject<Item> ALUMINIUM_DUST = ITEMS.register("aluminium_dust", () -> item());

    public static final RegistryObject<Item> ALUMINIUM_ROD = ITEMS.register("aluminium_rod", () -> item());

    public static final RegistryObject<Item> ALUMINIUM_ROD_DRILLED = ITEMS.register("aluminium_rod_drilled", () -> item());



    public static final RegistryObject<Item> ALUMINUM_TITANIUM_ALLOY_INGOT = ITEMS.register("aluminum_titanium_alloy_ingot", () -> item());

    public static final RegistryObject<Item> ALUMINUM_TITANIUM_ALLOY_ROD = ITEMS.register("aluminum_titanium_alloy_rod", () -> item());

    public static final RegistryObject<Item> ALUMINUM_TITANIUM_ALLOY_ROD_DRILLED = ITEMS.register("aluminum_titanium_alloy_rod_drilled", () -> item());



    public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", () ->item());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
