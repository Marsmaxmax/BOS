package com.marsmax.bos.api.datagen;

import java.util.function.Consumer;

import com.marsmax.bos.Bos;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.util.datafix.fixes.ItemLoreFix;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomRecipeProvider {
    /**
     * @param pFinishedRecipeConsumer
     * @param pCategory
     * @param pOutput
     * @param pInput
     * @param pInput2
     * @param pGroup
     * @param reqEnergy
     * @param time
     * 
     * Creates a new bos:arc_blasting recipe
     */
    public static void arcBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pOutput, ItemLike pInput, ItemLike pInput2, String pGroup, int reqEnergy, int time) {
        ArcFurnanceRecipeBuilder.arcBlaster(pCategory, (pOutput), reqEnergy, time).requires(pInput).requires(pInput2).group(pGroup).save(pFinishedRecipeConsumer, Bos.bosrl(getSimpleRecipeName(pOutput)+ "_from_arc_blasting"));
    }

    /**
     * @param pFinishedRecipeConsumer
     * @param pCategory
     * @param pOutput
     * @param pInput
     * @param pGroup
     * @param reqEnergy
     * @param time
     * 
     * Creates a new bos:lathe recipe
     */
    public static void lathe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pOutput, ItemLike pInput,  ItemLike pTool, String pGroup, int reqEnergy, int time) {
        LatheRecipeBuilder.lathe(pCategory, (pOutput), reqEnergy, time).requires(pInput).requires(pTool).group(pGroup).save(pFinishedRecipeConsumer, Bos.bosrl(getSimpleRecipeName(pOutput) + "_from_lathe"));
    }


    
    protected static String getHasName(ItemLike pItemLike) {
        return "has_" + getItemName(pItemLike);
    }

    protected static String getItemName(ItemLike pItemLike) {
        return ForgeRegistries.ITEMS.getKey(pItemLike.asItem()).getPath();
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... pPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, pPredicates);
    }

    protected static String getSimpleRecipeName(ItemLike pItemLike) {
        return getItemName(pItemLike);
    }
}