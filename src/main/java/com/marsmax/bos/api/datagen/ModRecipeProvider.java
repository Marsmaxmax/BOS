package com.marsmax.bos.api.datagen;
import java.util.List;
import java.util.function.Consumer;

import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.item.RegisterItem;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;


public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, List.of(RegisterItem.TITANIUM_RAW.get()), RecipeCategory.MISC,
                RegisterItem.TITANIUM_INGOT.get(), 0.7f, 200, "titanium");
        oreSmelting(consumer, List.of(RegisterItem.TIN_RAW.get()), RecipeCategory.MISC,
                RegisterItem.TIN_INGOT.get(), 0.7f, 200, "tin");
        oreBlasting(consumer, List.of(RegisterItem.TIN_RAW.get()), RecipeCategory.MISC,
                RegisterItem.TIN_INGOT.get(), 0.7f, 200, "tin");
        oreSmelting(consumer, List.of(RegisterItem.IRIDIUM_RAW.get()), RecipeCategory.MISC,
                RegisterItem.IRIDIUM_INGOT.get(), 0.7f, 200, "iridium");
        oreBlasting(consumer, List.of(RegisterItem.IRIDIUM_RAW.get()), RecipeCategory.MISC,
                RegisterItem.IRIDIUM_INGOT.get(), 0.7f, 200, "iridium");
        oreSmelting(consumer, List.of(RegisterItem.BAUXITE_RAW.get()), RecipeCategory.MISC,
                RegisterItem.ALUMINIUM_INGOT.get(), 0.7f, 200, "aluminium");
        oreBlasting(consumer, List.of(RegisterItem.BAUXITE_RAW.get()), RecipeCategory.MISC,
                RegisterItem.ALUMINIUM_INGOT.get(), 0.7f, 200, "aluminium");

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, RegisterItem.TITANIUM_INGOT.get(),
                RecipeCategory.MISC, RegisterBlock.TITANIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, RegisterItem.TIN_INGOT.get(),
                RecipeCategory.MISC, RegisterBlock.TIN_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, RegisterItem.IRIDIUM_INGOT.get(),
                RecipeCategory.MISC, RegisterBlock.IRIDIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, RegisterItem.ALUMINIUM_INGOT.get(),
                RecipeCategory.MISC, RegisterBlock.ALUMINIUM_BLOCK.get());
    }

}

