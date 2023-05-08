package com.marsmax.bos.api.datagen;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.RegisterBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
        blockWithItem(RegisterBlock.ALUMINIUM_BLOCK);
        blockWithItem(RegisterBlock.ALUMINIUM_ORE);
        
        
        
        //TREE blocks
        // logBlock((RotatedPillarBlock) RegisterBlock.TEST_LOG); 
        //axisBlock((RotatedPillarBlock) RegisterBlock.TEST_WOOD.get(), blockTexture(RegisterBlock.TEST_LOG.get()), blockTexture(RegisterBlock.TEST_LOG.get()));
        //axisBlock((RotatedPillarBlock) RegisterBlock.STRIPPED_TEST_LOG.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
        //        new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log_top"));
        //axisBlock((RotatedPillarBlock) RegisterBlock.STRIPPED_TEST_WOOD.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
        //        new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"));

        //blockWithItem(RegisterBlock.TEST_PLANKS);
        //blockWithItem(RegisterBlock.TEST_LEAVES);
        //saplingBlock(RegisterBlock.TEST_SAPLING);

        //simpleBlockItem(RegisterBlock.TEST_LOG.get(), models().withExistingParent("tutorialmod:ebony_log", "minecraft:block/cube_column"));
        //simpleBlockItem(RegisterBlock.TEST_WOOD.get(), models().withExistingParent("tutorialmod:ebony_wood", "minecraft:block/cube_column"));
        //simpleBlockItem(RegisterBlock.STRIPPED_TEST_LOG.get(), models().withExistingParent("tutorialmod:stripped_ebony_log", "minecraft:block/cube_column"));
        //simpleBlockItem(RegisterBlock.STRIPPED_TEST_WOOD.get(), models().withExistingParent("tutorialmod:stripped_ebony_wood", "minecraft:block/cube_column"));



    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
