package com.marsmax.bos.register;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.RegisterModArmorMaterials;
import com.marsmax.bos.register.custom.NetherSpacesuitArmorItem;
import com.marsmax.bos.register.custom.SpacesuitArmorItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.common.ForgeSpawnEggItem;

public class RegisterItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bos.MODID);

    public static final RegistryObject<Item> ELEVATOR_CHIP = ITEMS.register("elevator_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STATION_CHIP = ITEMS.register("station_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ASTEROID_CHIP = ITEMS.register("asteroid_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLANET_CHIP = ITEMS.register("planet_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SATELLITE_CHIP = ITEMS.register("satellite_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ADV_CIRCUIT = ITEMS.register("adv_circuit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRACK_CIRCUIT = ITEMS.register("track_circuit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CONTR_CIRCUIT = ITEMS.register("contr_circuit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ITEM_CIRCUIT = ITEMS.register("item_circuit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_CIRCUIT = ITEMS.register("liquid_circuit", () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> SPACESUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> SPACESUIT_BOOTS = ITEMS.register("space_suit_boots", () -> new SpacesuitArmorItem(RegisterModArmorMaterials.SPACESUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_HELMET = ITEMS.register("nether_space_suit_helmet", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_CHESTPLATE = ITEMS.register("nether_space_suit_chestplate", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_LEGGINGS = ITEMS.register("nether_space_suit_leggings", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SPACESUIT_BOOTS = ITEMS.register("nether_space_suit_boots", () -> new NetherSpacesuitArmorItem(RegisterModArmorMaterials.NETHERSPACESUIT, ArmorItem.Type.BOOTS, new Item.Properties()));



    public static final RegistryObject<Item> DILITIUM_DUST = ITEMS.register("dilithium_dust", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DILITHIUM_CRYSTAL = ITEMS.register("dilithium_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register("iridium_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIN_RAW = ITEMS.register("tin_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_RAW = ITEMS.register("titanium_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
