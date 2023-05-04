package com.marsmax.bos.api.datagen;
import com.marsmax.bos.Bos;
import com.marsmax.bos.register.RegisterItem;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;


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

        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
        //         .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
        //         .save(consumer);

        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .define('B', ModItems.BLACK_OPAL.get())
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModItems.BLACK_OPAL.get()).build()))
        //         .save(consumer);
    }

}

