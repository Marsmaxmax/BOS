package com.marsmax.bos.register;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.RegisterItem;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegisterBlock {
    public static final DeferredRegister<Block> BLOCKS  = DeferredRegister.create(ForgeRegistries.BLOCKS, Bos.MODID);

    public static final RegistryObject<Block> LAUNCHPAD = registerBlock("launchpad", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(3f)));

    public static final RegistryObject<Block> IRIDIUM_ORE = registerBlock("iridium_ore", 
                                                                () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> IRIDIUM_COIL = registerBlock("iridium_coil", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", 
                                                                () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> TIN_COIL = registerBlock("tin_coil", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore", 
                                                                () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore", 
                                                                () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> TITANIUM_COIL = registerBlock("titanium_coil", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> DILITHIUM_ORE = registerBlock("dilithium_ore", 
                                                                () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    public static final RegistryObject<Block> DILITHIUM_BLOCK = registerBlock("dilithium_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> MOON_BLOCK = registerBlock("moon_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> DARK_MOON_BLOCK = registerBlock("dark_moon_block", 
                                                                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegisterItem.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
