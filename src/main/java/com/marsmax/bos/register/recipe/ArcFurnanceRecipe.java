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

public class ArcFurnanceRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;
    private final Integer energy;
    private final Integer time;

    public ArcFurnanceRecipe(ResourceLocation id, ItemStack output,NonNullList<Ingredient> recipeItems, Integer energy, Integer time) {
        this.id = id;
        this.result = output;
        this.ingredients = recipeItems;
        this.energy = energy;
        this.time = time;
    }


    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return result;
    }

    @Override
    public boolean matches(SimpleContainer pInv, Level pLevel) {
        if(pLevel.isClientSide) { return false; }
        final boolean match;

        if(ingredients.get(0).test(pInv.getItem(0))) {
            if(ingredients.get(1).test(pInv.getItem(1))){
                match = true;
                // System.out.println("test1" + match);
            }else{
                match = false;
                // System.out.println("test2");
            }
        } else {
            match = false;
            // System.out.println("test3");
        }
        // System.out.println("test4" + match);
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

    public Integer getTime(){
        return this.time;
    }

    public static class Type implements RecipeType<ArcFurnanceRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "arc_blasting";
    }


    public static class Serializer implements RecipeSerializer<ArcFurnanceRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = bosrl("arc_blasting");

        @Override
        public ArcFurnanceRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(pJson, "ingredients"));
            Integer pEnergy = GsonHelper.getAsInt(pJson, "energy"); 
            Integer time = GsonHelper.getAsInt(pJson, "time"); 
            if (nonnulllist.isEmpty()) {
               throw new JsonParseException("No ingredients for bos:arc_blasting recipe");
            } else if (nonnulllist.size() > 2) {
               throw new JsonParseException("Too many ingredients for bos:arc_blasting recipe. The maximum is 2");
            } else {
               ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));

               return new ArcFurnanceRecipe(pRecipeId, itemstack, nonnulllist, pEnergy, time);

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
        public @Nullable ArcFurnanceRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
   
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            Integer pEnergy = buf.readInt();
            Integer time = buf.readInt();
            ItemStack output = buf.readItem();
            return new ArcFurnanceRecipe(id, output, inputs, pEnergy, time);
        }


        @Override
        public void toNetwork(FriendlyByteBuf buf, ArcFurnanceRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }


            buf.writeInt(recipe.getEnergy());
            buf.writeInt(recipe.getTime());
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}