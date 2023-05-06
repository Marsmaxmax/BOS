package com.marsmax.bos;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.marsmax.bos.api.CreativeTab;
import com.marsmax.bos.register.RegisterBlock;
import com.marsmax.bos.register.RegisterItem;
import com.marsmax.bos.register.RegisterCreativeTab;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bos.MODID)
public class Bos {

    public static final String MODID = "bos";

    public Bos() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegisterItem.register(modEventBus);
        RegisterBlock.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreativeTab);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MODID, path);
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }



    public void addCreativeTab(CreativeModeTabEvent.BuildContents event) {
       // Gets extended in RegisterCreativeTab
    }
}
