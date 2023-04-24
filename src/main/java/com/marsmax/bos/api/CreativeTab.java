package com.marsmax.bos.api;

import com.marsmax.bos.api.register.registerItem;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab {
    public static final CreativeModeTab BOS = new CreativeModeTab("Beyond Our Stars") {
        @Override
        
        public ItemStack makeIcon() {
            return new ItemStack(registerItem.ASTEROID_CHIP.get());
        }
    };
}
