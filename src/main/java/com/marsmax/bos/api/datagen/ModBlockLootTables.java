package com.marsmax.bos.api.datagen;

import com.marsmax.bos.api.register.registerBlock;
import com.marsmax.bos.api.register.registerItem;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(registerBlock.LAUNCHPAD.get());

        dropSelf(registerBlock.IRIDIUM_COIL.get());
        dropSelf(registerBlock.TIN_COIL.get());
        dropSelf(registerBlock.TITANIUM_COIL.get());
        dropSelf(registerBlock.IRIDIUM_BLOCK.get());
        dropSelf(registerBlock.TIN_BLOCK.get());
        dropSelf(registerBlock.TITANIUM_BLOCK.get());
        dropSelf(registerBlock.DILITHIUM_BLOCK.get());

        add(registerBlock.IRIDIUM_ORE.get(),
            (block) -> createOreDrop(registerBlock.IRIDIUM_ORE.get(), registerItem.IRIDIUM_RAW.get()));
        add(registerBlock.DILITHIUM_ORE.get(),
            (block) -> createOreDrop(registerBlock.DILITHIUM_ORE.get(), registerItem.DILITIUM_DUST.get()));
        add(registerBlock.TIN_ORE.get(),
            (block) -> createOreDrop(registerBlock.TIN_ORE.get(), registerItem.TIN_RAW.get()));
        add(registerBlock.TITANIUM_ORE.get(),
            (block) -> createOreDrop(registerBlock.TITANIUM_ORE.get(), registerItem.TITANIUM_RAW.get()));
        add(registerBlock.DEEPSLATE_TITANIUM_ORE.get(),
            (block) -> createOreDrop(registerBlock.TITANIUM_ORE.get(), registerItem.TITANIUM_RAW.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return registerBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
