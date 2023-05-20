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
        coilBlock(RegisterBlock.IRIDIUM_COIL);
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
        modLogBlock( RegisterBlock.TEST_LOG);
        modWoodBlock(RegisterBlock.TEST_WOOD);
        modLogBlock(RegisterBlock.STRIPPED_TEST_LOG);
        modWoodBlock(RegisterBlock.STRIPPED_TEST_WOOD);

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


    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void saplingBlock(RegistryObject<Block> block) {
        simpleBlock(
            block.get(),
            models().cross(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), 
            blockTexture(block.get())).renderType("cutout"));
            
        simpleBlockItem((block.get()), models().withExistingParent(modelLocation(block.get()),"minecraft:item/generated"));
    }

    public void modLogBlock(RegistryObject<Block> block) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture((RotatedPillarBlock) block.get()), extend(blockTexture((RotatedPillarBlock) block.get()), "_top"));
        modBlockItem((RotatedPillarBlock) block.get());
    }

    public void coilBlock(RegistryObject<Block> block){
        axisBlock((RotatedPillarBlock) block.get(), blockTexture((RotatedPillarBlock) block.get()),id("block/coil_top"));
        modBlockItem((RotatedPillarBlock) block.get());
    }

    public void modWoodBlock(RegistryObject<Block> block) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture((RotatedPillarBlock) block.get()), blockTexture((RotatedPillarBlock) block.get()));
        modBlockItem((RotatedPillarBlock) block.get());
    }

    private void modBlockItem(Block block) {
        simpleBlockItem((block), models().withExistingParent(modelLocation(block),"minecraft:block/cube_column"));
    }
}
