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

    private void addCreativeTab(CreativeModeTab.buildContents event) {
        if(event.getTab() == CreativeTab.BOS_TAB) {
            event.accept(registerItem.ASTEROID_CHIP);
            
        }
    }
}
