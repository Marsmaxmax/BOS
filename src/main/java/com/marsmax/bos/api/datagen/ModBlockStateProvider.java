package com.marsmax.bos.api.datagen;

import java.util.function.Supplier;

import com.marsmax.bos.Bos;
import static com.marsmax.bos.Bos.id;
import com.marsmax.bos.register.RegisterBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
        coilBlock((RotatedPillarBlock)RegisterBlock.IRIDIUM_COIL.get());
        blockWithItem(RegisterBlock.IRIDIUM_ORE);
        //blockWithItem(RegisterBlock.TIN_BLOCK);
        //coilBlock(RegisterBlock.TIN_COIL);
        //blockWithItem(RegisterBlock.TIN_ORE);
        //blockWithItem(RegisterBlock.TITANIUM_BLOCK);
        //coilBlock(RegisterBlock.TITANIUM_COIL);
        //blockWithItem(RegisterBlock.TITANIUM_ORE);
        //blockWithItem(RegisterBlock.DEEPSLATE_TITANIUM_ORE);
        //blockWithItem(RegisterBlock.ALUMINIUM_BLOCK);
        //coilBlock(RegisterBlock.ALUMINIUM_COIL);
        //blockWithItem(RegisterBlock.BAUXIT_ORE);
        
        
        
        //TREE blocks 
        modLogBlock((RotatedPillarBlock) RegisterBlock.TEST_LOG.get());
        modWoodBlock((RotatedPillarBlock) RegisterBlock.TEST_WOOD.get());
        modLogBlock((RotatedPillarBlock) RegisterBlock.STRIPPED_TEST_LOG.get());
        modWoodBlock((RotatedPillarBlock) RegisterBlock.STRIPPED_TEST_WOOD.get());

        blockWithItem(RegisterBlock.TEST_PLANKS);
        blockWithItem(RegisterBlock.TEST_LEAVES);
        saplingBlock(RegisterBlock.TEST_SAPLING);

    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    public String modelLocation(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        return new String(name.getNamespace() +":"+ name.getPath());
    }

    public String parentLocation(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        return new String(name.getNamespace() +":block/"+ name.getPath());
    }


    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
        models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), 
        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void modLogBlock(RotatedPillarBlock block) {
        axisBlock(block, blockTexture(block), extend(blockTexture(block), "_top"));
        modBlockItem(block);
    }

    public void coilBlock(RotatedPillarBlock block){
        axisBlock(block, blockTexture(block),id("block/coil_top"));
        modBlockItem(block);
    }

    public void modWoodBlock(RotatedPillarBlock block) {
        axisBlock(block, blockTexture(block), blockTexture(block));
        modBlockItem(block);
    }

    private void modBlockItem(Block block) {
        simpleBlockItem((block), models().withExistingParent(modelLocation(block),"minecraft:block/cube_column"));
    }
}
