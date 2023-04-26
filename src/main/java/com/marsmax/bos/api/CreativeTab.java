package com.marsmax.bos.api;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.registerItem;

import net.minecraft.client.gui.screens.CreateBuffetWorldScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.item.ItemStack;

public class CreativeTab {
    public static CreativeModeTab BOS_TAB;
    
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BOS_TAB = event.registerCreativeModeTab(new ResourceLocation(Bos.MODID, "bostab"),
            builder -> builder.icon(() -> new ItemStack(registerItem.ASTEROID_CHIP.get()))
                                .title(Component.literal("Beyond our Stars"))
                                .build());
    }
}
