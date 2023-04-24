package com.marsmax.bos.api.register;

import com.marsmax.bos.Bos;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class registerItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bos.MODID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("testitem", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
