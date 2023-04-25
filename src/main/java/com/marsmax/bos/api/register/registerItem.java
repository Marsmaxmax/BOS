package com.marsmax.bos.api.register;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.CreativeTab;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class registerItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bos.MODID);

    public static final RegistryObject<Item> ELEVATOR_CHIP = ITEMS.register("elevator_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STATION_CHIP = ITEMS.register("station_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ASTEROID_CHIP = ITEMS.register("asteroid_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLANET_CHIP = ITEMS.register("planet_chip", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SATELLITE_CHIP = ITEMS.register("satellite_chip", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
