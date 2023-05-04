package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.RegisterBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Bos.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(RegisterBlock.DILITHIUM_BLOCK);
        blockWithItem(RegisterBlock.DILITHIUM_ORE);
        blockWithItem(RegisterBlock.IRIDIUM_BLOCK);
        blockWithItem(RegisterBlock.IRIDIUM_COIL);
        blockWithItem(RegisterBlock.IRIDIUM_ORE);
        blockWithItem(RegisterBlock.TIN_BLOCK);
        blockWithItem(RegisterBlock.TIN_COIL);
        blockWithItem(RegisterBlock.TIN_ORE);
        blockWithItem(RegisterBlock.TITANIUM_BLOCK);
        blockWithItem(RegisterBlock.TITANIUM_COIL);
        blockWithItem(RegisterBlock.TITANIUM_ORE);
        blockWithItem(RegisterBlock.DEEPSLATE_TITANIUM_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
