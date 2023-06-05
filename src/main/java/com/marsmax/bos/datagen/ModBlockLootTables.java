package com.marsmax.bos.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.item.RegisterItem;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(RegisterBlock.LAUNCHPAD.get());
        dropSelf(RegisterBlock.ARC_FURNANCE.get());

        dropSelf(RegisterBlock.IRIDIUM_COIL.get());
        dropSelf(RegisterBlock.TIN_COIL.get());
        dropSelf(RegisterBlock.TITANIUM_COIL.get());
        dropSelf(RegisterBlock.ALUMINIUM_COIL.get());
        dropSelf(RegisterBlock.IRIDIUM_BLOCK.get());
        dropSelf(RegisterBlock.TIN_BLOCK.get());
        dropSelf(RegisterBlock.TITANIUM_BLOCK.get());
        dropSelf(RegisterBlock.DILITHIUM_BLOCK.get());
        dropSelf(RegisterBlock.ALUMINIUM_BLOCK.get());


        dropSelf(RegisterBlock.TEST_LEAVES.get());
        dropSelf(RegisterBlock.TEST_LOG.get());
        dropSelf(RegisterBlock.TEST_PLANKS.get());
        dropSelf(RegisterBlock.TEST_SAPLING.get());
        dropSelf(RegisterBlock.TEST_WOOD.get());
        dropSelf(RegisterBlock.STRIPPED_TEST_LOG.get());
        dropSelf(RegisterBlock.STRIPPED_TEST_WOOD.get());

        dropSelf(RegisterBlock.MOON_TURF.get());
        dropSelf(RegisterBlock.DARK_MOON_TURF.get());
        dropSelf(RegisterBlock.MOON_ROCK.get());
        dropSelf(RegisterBlock.CHISSLED_MOON_ROCK.get());
        dropSelf(RegisterBlock.SMOOTH_MOON_ROCK.get());
        dropSelf(RegisterBlock.MOON_BRICKS.get());


        add(RegisterBlock.DEEPSLATE_IRIDIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DEEPSLATE_IRIDIUM_ORE.get(), RegisterItem.IRIDIUM_RAW.get()));
            add(RegisterBlock.IRIDIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.IRIDIUM_ORE.get(), RegisterItem.IRIDIUM_RAW.get()));

        add(RegisterBlock.DILITHIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DILITHIUM_ORE.get(), RegisterItem.DILITIUM_DUST.get()));

        add(RegisterBlock.TIN_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.TIN_ORE.get(), RegisterItem.TIN_RAW.get()));
            add(RegisterBlock.DEEPSLATE_TIN_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DEEPSLATE_TIN_ORE.get(), RegisterItem.TIN_RAW.get()));

        add(RegisterBlock.TITANIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.TITANIUM_ORE.get(), RegisterItem.TITANIUM_RAW.get()));
        add(RegisterBlock.DEEPSLATE_TITANIUM_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.DEEPSLATE_TITANIUM_ORE.get(), RegisterItem.TITANIUM_RAW.get()));

        add(RegisterBlock.BAUXIT_ORE.get(),
            (block) -> createOreDrop(RegisterBlock.BAUXIT_ORE.get(), RegisterItem.ALUMINIUM_DUST.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegisterBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
