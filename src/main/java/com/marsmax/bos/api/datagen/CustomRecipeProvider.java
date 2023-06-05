package com.marsmax.bos.api.datagen;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.marsmax.bos.Bos;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomRecipeProvider {
    public static void arcBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pOutput, ItemLike pInput, ItemLike pInput2, String pGroup) {
        ArcFurnanceRecipeBuilder.arcBlaster(pCategory, (pInput)).requires(pInput).requires(pInput2).group(pGroup).save(pFinishedRecipeConsumer, Bos.bosrl(getSimpleRecipeName(pOutput)));
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
