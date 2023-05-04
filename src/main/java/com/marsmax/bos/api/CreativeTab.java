package com.marsmax.bos.api;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.RegisterItem;
import com.marsmax.bos.api.register.RegisterBlock;

import net.minecraft.client.gui.screens.CreateBuffetWorldScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.item.ItemStack;
@Mod.EventBusSubscriber(modid = Bos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTab {
    public static CreativeModeTab BOS_TAB;

    public static CreativeModeTab BOS_RES_TAB;
    
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BOS_TAB = event.registerCreativeModeTab(new ResourceLocation(Bos.MODID, "bostab"),
            builder -> builder  .icon(() -> new ItemStack(RegisterItem.ASTEROID_CHIP.get()))
                                .title(Component.literal("Beyond our Stars"))
                                .build());
                                
        BOS_RES_TAB = event.registerCreativeModeTab(new ResourceLocation(Bos.MODID, "bostab_res"),
            builder -> builder  .icon(() -> new ItemStack(RegisterItem.DILITIUM_DUST.get()))
                                .title(Component.literal("BOS Ores and Ingots"))
                                .build());
    }
}
