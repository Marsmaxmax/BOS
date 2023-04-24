package com.marsmax.bos.api.register;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;

import org.antlr.v4.parse.ANTLRParser.finallyClause_return;

import com.marsmax.bos.Bos;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class registerBlock {
    public static final DeferredRegister<Block> BLOCKS  = DeferredRegister.create(ForgeRegistries.BLOCKS, Bos.MODID);

    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("testblock", null)
}
