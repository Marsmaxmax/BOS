package com.marsmax.bos.api;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.item.RegisterItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.item.ItemStack;

import static com.marsmax.bos.Bos.bosrl;

@Mod.EventBusSubscriber(modid = Bos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTab {
    public static CreativeModeTab BOS_TAB;

    public static CreativeModeTab BOS_RES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BOS_TAB = event.registerCreativeModeTab(bosrl("bostab"),
                builder -> builder.icon(() -> new ItemStack(RegisterItem.ASTEROID_CHIP.get()))
                        .title(Component.literal("Beyond our Stars"))
                        .build());

        BOS_RES_TAB = event.registerCreativeModeTab(bosrl("bostab_res"),
                builder -> builder.icon(() -> new ItemStack(RegisterBlock.DILITHIUM_BLOCK.get()))
                        .title(Component.literal("BOS Ores and Ingots"))
                        .build());
    }
}
