package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.registerBlock;

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
        blockWithItem(registerBlock.DILITHIUM_BLOCK);
        blockWithItem(registerBlock.DILITHIUM_ORE);
        blockWithItem(registerBlock.IRIDIUM_BLOCK);
        blockWithItem(registerBlock.IRIDIUM_COIL);
        blockWithItem(registerBlock.IRIDIUM_ORE);
        blockWithItem(registerBlock.TIN_BLOCK);
        blockWithItem(registerBlock.TIN_COIL);
        blockWithItem(registerBlock.TIN_ORE);
        blockWithItem(registerBlock.TITANIUM_BLOCK);
        blockWithItem(registerBlock.TITANIUM_COIL);
        blockWithItem(registerBlock.TITANIUM_ORE);
        blockWithItem(registerBlock.DEEPSLATE_TITANIUM_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
