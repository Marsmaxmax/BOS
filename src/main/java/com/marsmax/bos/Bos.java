package com.marsmax.bos;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.CreativeModeTab;    
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import com.marsmax.bos.api.CreativeTab;
import com.marsmax.bos.api.register.registerBlock;
import  com.marsmax.bos.api.register.registerItem;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bos.MODID)
public class Bos
{

    public static final String MODID = "bos";

    public Bos()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerItem.register(modEventBus);
        registerBlock.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreativeTab);
    }

    private void addCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeTab.BOS_TAB) {
            //Chips
            event.accept(registerItem.ASTEROID_CHIP);
            event.accept(registerItem.SATELLITE_CHIP);
            event.accept(registerItem.STATION_CHIP);
            event.accept(registerItem.PLANET_CHIP);
            event.accept(registerItem.ELEVATOR_CHIP);
            event.accept(registerItem.BASIC_CIRCUIT);
            event.accept(registerItem.ADV_CIRCUIT);
            event.accept(registerItem.TRACK_CIRCUIT);
            event.accept(registerItem.ITEM_CIRCUIT);
            event.accept(registerItem.LIQUID_CIRCUIT);
            event.accept(registerItem.CONTR_CIRCUIT);
            //Rocket Blocks
            event.accept(registerBlock.LAUNCHPAD);
        }
    
        if(event.getTab() == CreativeTab.BOS_RES_TAB) {
            //Dilithium
            event.accept(registerItem.DILITHIUM_CRYSTAL);
            event.accept(registerItem.DILITIUM_DUST);
            event.accept(registerBlock.DILITHIUM_ORE);
            event.accept(registerBlock.DILITHIUM_BLOCK);
            //Iridium
            event.accept(registerItem.IRIDIUM_RAW);
            event.accept(registerItem.IRIDIUM_INGOT);
            event.accept(registerBlock.IRIDIUM_ORE);
            event.accept(registerBlock.IRIDIUM_BLOCK);
            event.accept(registerBlock.IRIDIUM_COIL);
            //Tin
            event.accept(registerItem.TIN_RAW);
            event.accept(registerItem.TIN_INGOT);
            event.accept(registerBlock.TIN_ORE);
            event.accept(registerBlock.TIN_BLOCK);
            event.accept(registerBlock.TIN_COIL);
            //Titanium
            event.accept(registerItem.TITANIUM_RAW);
            event.accept(registerItem.TITANIUM_INGOT);
            event.accept(registerBlock.TITANIUM_ORE);
            event.accept(registerBlock.TITANIUM_BLOCK);
            event.accept(registerBlock.TITANIUM_COIL);

        }
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
