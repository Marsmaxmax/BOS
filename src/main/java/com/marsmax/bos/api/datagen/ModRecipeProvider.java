package com.marsmax.bos.api.datagen;

import com.marsmax.bos.api.register.registerItem;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;

import java.util.function.Consumer;
import java.util.List;


public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipies(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(registerItem.TITANIUM_RAW.get()), RecipeCategory.MISC, registerItem.TITANIUM_INGOT, 0.7f, 400, "titanium_ingot");

    }
}
