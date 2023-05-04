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
import com.marsmax.bos.api.register.RegisterBlock;
import com.marsmax.bos.api.register.RegisterItem;

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

    private void addCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeTab.BOS_TAB) {
            //Chips
            event.accept(RegisterItem.ASTEROID_CHIP);
            event.accept(RegisterItem.SATELLITE_CHIP);
            event.accept(RegisterItem.STATION_CHIP);
            event.accept(RegisterItem.PLANET_CHIP);
            event.accept(RegisterItem.ELEVATOR_CHIP);
            event.accept(RegisterItem.BASIC_CIRCUIT);
            event.accept(RegisterItem.ADV_CIRCUIT);
            event.accept(RegisterItem.TRACK_CIRCUIT);
            event.accept(RegisterItem.ITEM_CIRCUIT);
            event.accept(RegisterItem.LIQUID_CIRCUIT);
            event.accept(RegisterItem.CONTR_CIRCUIT);

            //Rocket Blocks
            event.accept(RegisterBlock.LAUNCHPAD);

            //Armor
            event.accept(RegisterItem.SPACESUIT_HELMET);
            event.accept(RegisterItem.SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.SPACESUIT_BOOTS);
            event.accept(RegisterItem.NETHER_SPACESUIT_HELMET);
            event.accept(RegisterItem.NETHER_SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.NETHER_SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.NETHER_SPACESUIT_BOOTS);
        }

        if (event.getTab() == CreativeTab.BOS_RES_TAB) {

            //Dilithium
            event.accept(RegisterItem.DILITHIUM_CRYSTAL);
            event.accept(RegisterItem.DILITIUM_DUST);
            event.accept(RegisterBlock.DILITHIUM_ORE);
            event.accept(RegisterBlock.DILITHIUM_BLOCK);

            //Iridium
            event.accept(RegisterItem.IRIDIUM_RAW);
            event.accept(RegisterItem.IRIDIUM_INGOT);
            event.accept(RegisterBlock.IRIDIUM_ORE);
            event.accept(RegisterBlock.IRIDIUM_BLOCK);
            event.accept(RegisterBlock.IRIDIUM_COIL);

            //Tin
            event.accept(RegisterItem.TIN_RAW);
            event.accept(RegisterItem.TIN_INGOT);
            event.accept(RegisterBlock.TIN_ORE);
            event.accept(RegisterBlock.TIN_BLOCK);
            event.accept(RegisterBlock.TIN_COIL);

            //Titanium
            event.accept(RegisterItem.TITANIUM_RAW);
            event.accept(RegisterItem.TITANIUM_INGOT);
            event.accept(RegisterBlock.TITANIUM_ORE);
            event.accept(RegisterBlock.TITANIUM_BLOCK);
            event.accept(RegisterBlock.TITANIUM_COIL);

        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
