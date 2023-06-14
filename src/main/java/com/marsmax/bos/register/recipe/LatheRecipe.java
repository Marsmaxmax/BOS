package com.marsmax.bos.register.recipe;

import static com.marsmax.bos.Bos.bosrl;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class LatheRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;
    private final Integer energy;
    private final ItemStack drill;

    public LatheRecipe(ResourceLocation id, ItemStack output, ItemStack drill, NonNullList<Ingredient> recipeItems, Integer energy) {
        this.id = id;
        this.result = output;
        this.ingredients = recipeItems;
        this.energy = energy;
        this.drill = drill;
    }


    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return result;
    }

    @Override
    public boolean matches(SimpleContainer pInv, Level pLevel) {
        if(pLevel.isClientSide) { return false; }
        final boolean match;
        if(ingredients.get(1).test(pInv.getItem(1))){
            match = true;
            // System.out.println("test1" + match);
        }else{
            match = false;
            // System.out.println("test2");
        }
        return match;
   }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public Integer getEnergy(){
        return this.energy;
    }

    public ItemStack getDrill(){
        return this.drill.copy();
    }

    public static class Type implements RecipeType<LatheRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "lathe";
    }


    public static class Serializer implements RecipeSerializer<LatheRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = bosrl("lathe");

        @Override
        public LatheRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(pJson, "ingredients"));
            ItemStack drill = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "drill"));
            Integer pEnergy = GsonHelper.getAsInt(pJson, "energy"); 
            if (nonnulllist.isEmpty()) {
               throw new JsonParseException("No ingredients for bos:lathe recipe");
            } else if (nonnulllist.size() > 1) {
               throw new JsonParseException("Too many ingredients for bos:lathe recipe. The maximum is 1");
            } else {
               ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
               return new LatheRecipe(pRecipeId, itemstack, drill, nonnulllist, pEnergy);
            }
        }


        private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();
   
            for(int i = 0; i < pIngredientArray.size(); ++i) {
               Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i));
               if (!ingredient.isEmpty()) { // FORGE: Skip checking if an ingredient is empty during shapeless recipe deserialization to prevent complex ingredients from caching tags too early. Can not be done using a config value due to sync issues.
                  nonnulllist.add(ingredient);
               }
            }
   
            return nonnulllist;
         }

        @Override
        public @Nullable LatheRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
   
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }
            Integer pEnergy = buf.readInt();
            ItemStack output = buf.readItem();
            ItemStack drill = buf.readItem();
            return new LatheRecipe(id, output, drill, inputs, pEnergy);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, LatheRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeInt(recipe.getEnergy());
            buf.writeItemStack(recipe.getDrill(), false);
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}