package com.marsmax.bos;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import com.marsmax.bos.register.RegisterCreativeTab;
import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.block.entity.RegisterBlockEntities;
import com.marsmax.bos.register.item.RegisterItem;
import com.marsmax.bos.register.modmenu.RegisterMenuTypes;
import com.marsmax.bos.register.modmenu.arcfurnance.ArcFurnanceScreen;
import com.marsmax.bos.register.recipe.RegisterModRecipies;
import com.marsmax.bos.util.networking.CustomMessages;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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

        //Registering BlockEntities and MenuTypes
        RegisterBlockEntities.register(modEventBus);
        RegisterMenuTypes.register(modEventBus);

        //Registering Custom Recipies
        RegisterModRecipies.register(modEventBus);



        //And Of course the Creative tab
        RegisterCreativeTab newCreativeTabRegister = new RegisterCreativeTab();
        modEventBus.addListener(newCreativeTabRegister::addCreativeTab);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CustomMessages.register();
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(RegisterMenuTypes.ARC_FURNANCE_MENU.get(), ArcFurnanceScreen::new);
        }
    }


    //Queue Systemy
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

    public static ResourceLocation bosrl(String path) {
        return new ResourceLocation(MODID, path);
    }
}
