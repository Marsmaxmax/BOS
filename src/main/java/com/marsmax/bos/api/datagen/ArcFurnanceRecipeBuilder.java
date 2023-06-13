package com.marsmax.bos.api.datagen;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.marsmax.bos.register.recipe.RegisterModRecipies;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.CraftingRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcFurnanceRecipeBuilder extends CraftingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;

    public ArcFurnanceRecipeBuilder(RecipeCategory pCategory, ItemLike pResult, int pCount){
        this.category = pCategory;
        this.result = pResult.asItem();
        this.count = pCount;
    }

    /**
     * @param pCategory
     * @param pInput
     * @return new Arc Blasting recipe
     */
    public static ArcFurnanceRecipeBuilder arcBlaster(RecipeCategory pCategory, ItemLike pInput) {
        return new ArcFurnanceRecipeBuilder(pCategory, pInput, 1);
    };



    /**
     * Adds an ingredient of the given item.
     */
    public ArcFurnanceRecipeBuilder requires(ItemLike pItem) {
       return this.requires(pItem, 1);
    }

    /**
     * Adds the given ingredient multiple times.
     */
    public ArcFurnanceRecipeBuilder requires(ItemLike pItem, int pQuantity) {
       for(int i = 0; i < pQuantity; ++i) {
          this.requires(Ingredient.of(pItem));
       }    
       return this;
    }  

    /**
     * Adds an ingredient.
     */
    public ArcFurnanceRecipeBuilder requires(Ingredient pIngredient) {
       return this.requires(pIngredient, 1);
    } 

    /**
     * Adds an ingredient multiple times.
     */
    public ArcFurnanceRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
       for(int i = 0; i < pQuantity; ++i) {
          this.ingredients.add(pIngredient);
       }    
       return this;
    }

    @Override
    public ArcFurnanceRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public ArcFurnanceRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }
    @Override
    public Item getResult() {
        return this.result;
    }

    
   /**
    * Makes sure that this recipe is valid and obtainable.
    */
    private void ensureValid(ResourceLocation pId) {
        //if (this.advancement.getCriteria().isEmpty()) {
        //    throw new IllegalStateException("No way of obtaining recipe " + pId);
        //}
    }
 @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new ArcFurnanceRecipeBuilder.Result(pRecipeId, this.result, this.count, this.group == null ? "" : this.group, determineBookCategory(this.category), this.ingredients, this.advancement, pRecipeId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }
    

    public static class Result extends CraftingRecipeBuilder.CraftingResult{
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
  
        public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, CraftingBookCategory pCategory, List<Ingredient> pIngredients, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
           super(pCategory);
           this.id = pId;
           this.result = pResult;
           this.count = pCount;
           this.group = pGroup;
           this.ingredients = pIngredients;
           this.advancement = pAdvancement;
           this.advancementId = pAdvancementId;
        }

        public void serializeRecipeData(JsonObject pJson) {
            super.serializeRecipeData(pJson);
            if (!this.group.isEmpty()) {
               pJson.addProperty("group", this.group);
            }
   
            JsonArray jsonarray = new JsonArray();
   
            for(Ingredient ingredient : this.ingredients) {
               jsonarray.add(ingredient.toJson());
            }
   
            pJson.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            //if (this.count > 1) { //there is never a count for bos:arc_blasting
            //   jsonobject.addProperty("count", this.count);
            //}
   
            pJson.add("result", jsonobject);
         }

        @Override
        public ResourceLocation getId() {
         return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RegisterModRecipies.ARC_BLASTING.get();
        }

        @Override
        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Override
        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }

    }
}
