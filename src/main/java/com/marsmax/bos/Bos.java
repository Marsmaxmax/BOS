package com.marsmax.bos;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import com.marsmax.bos.register.RegisterBlock;
import com.marsmax.bos.register.RegisterCreativeTab;
import com.marsmax.bos.register.RegisterItem;


import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bos.MODID)
public class Bos {

    public static final String MODID = "bos";

    public Bos() {

        //IEventBus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Registering Itmes and Blocks
        RegisterItem.register(modEventBus);
        RegisterBlock.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);


        RegisterCreativeTab newCreativeTabRegister = new RegisterCreativeTab();
        modEventBus.addListener(newCreativeTabRegister::addCreativeTab);

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

    private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

    @SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
