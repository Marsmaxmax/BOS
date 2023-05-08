package com.marsmax.bos.api.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import com.marsmax.bos.register.RegisterBlock;
import com.marsmax.bos.register.RegisterItem;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(RegisterBlock.LAUNCHPAD.get());

        dropSelf(RegisterBlock.IRIDIUM_COIL.get());
        dropSelf(RegisterBlock.TIN_COIL.get());
        dropSelf(RegisterBlock.TITANIUM_COIL.get());
        dropSelf(RegisterBlock.IRIDIUM_BLOCK.get());
        dropSelf(RegisterBlock.TIN_BLOCK.get());
        dropSelf(RegisterBlock.TITANIUM_BLOCK.get());
        dropSelf(RegisterBlock.DILITHIUM_BLOCK.get());
        dropSelf(RegisterBlock.ALUMINIUM_BLOCK.get());
        dropSelf(RegisterBlock.MOON_BLOCK.get());
        dropSelf(RegisterBlock.DARK_MOON_BLOCK.get());


        add(RegisterBlock.IRIDIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.IRIDIUM_ORE.get(), RegisterItem.IRIDIUM_RAW.get()));

        add(RegisterBlock.DILITHIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DILITHIUM_ORE.get(), RegisterItem.DILITIUM_DUST.get()));

        add(RegisterBlock.TIN_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.TIN_ORE.get(), RegisterItem.TIN_RAW.get()));

        add(RegisterBlock.TITANIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.TITANIUM_ORE.get(), RegisterItem.TITANIUM_RAW.get()));
        add(RegisterBlock.DEEPSLATE_TITANIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DEEPSLATE_TITANIUM_ORE.get(), RegisterItem.TITANIUM_RAW.get()));

        add(RegisterBlock.ALUMINIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.ALUMINIUM_ORE.get(), RegisterItem.ALUMINIUM_DUST.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegisterBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
