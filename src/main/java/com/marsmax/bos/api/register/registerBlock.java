package com.marsmax.bos.api.register;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.client.gui.screens.CreateBuffetWorldScreen;
import net.minecraft.world.item.BlockItem;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.CreativeTab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class registerBlock {
    public static final DeferredRegister<Block> BLOCKS  = DeferredRegister.create(ForgeRegistries.BLOCKS, Bos.MODID);

    public static final RegistryObject LAUNCHPAD = registerBlock("launchpad", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject IRIDIUM_BLOCK = registerBlock("iridium_block", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);

    public static final RegistryObject TIN_BLOCK = registerBlock("tin_block", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);


    public static final RegistryObject TITANIUM_BLOCK = registerBlock("titanium_block", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);


    public static final RegistryObject IRIDIUM_COIL = registerBlock("iridium_coil", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);

    public static final RegistryObject TIN_COIL = registerBlock("tin_coil", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);


    public static final RegistryObject TITANIUM_COIL = registerBlock("titanium_coil", 
                                                                () -> new Block(BlockBehaviour.Properties
                                                                                .of(Material.STONE)
                                                                                .strength(1F, 3F)
                                                                                .sound(SoundType.SAND))
                                                                , CreativeTab.BOS);




    //Registers Blocks as a Block
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;

    }
    //Registers Blocks as an ItemBlock
    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        registerItem.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
