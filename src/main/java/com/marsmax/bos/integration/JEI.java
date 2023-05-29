package com.marsmax.bos.integration;

import com.marsmax.bos.register.recipe.*;
import com.marsmax.bos.integration.recipecategory.*;
import static com.marsmax.bos.Bos.bosrl;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEI implements IModPlugin {
    public static RecipeType<ArcFurnanceRecipe> ARC_BLASTING_TYPE = new RecipeType<>(ArcFurnanceRecipeCategory.UID, ArcFurnanceRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return bosrl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ArcFurnanceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<ArcFurnanceRecipe> recipesInfusing = rm.getAllRecipesFor(ArcFurnanceRecipe.Type.INSTANCE);
        registration.addRecipes(ARC_BLASTING_TYPE, recipesInfusing);
    }
}
