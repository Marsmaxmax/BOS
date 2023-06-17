package com.marsmax.bos.register.item.custom.preset;

import net.minecraft.world.item.Item.Properties;

import net.minecraft.world.item.Item;

public class CustomItemPresets {
    public static Item item(Properties pProperties){
        return new Item(pProperties);
    }
    public static Item item(){
        return item(new Item.Properties());
    }
}
