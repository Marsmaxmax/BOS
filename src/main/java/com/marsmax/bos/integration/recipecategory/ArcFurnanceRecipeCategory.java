package com.marsmax.bos.integration.recipecategory;

import com.marsmax.bos.integration.JEI;
import static com.marsmax.bos.Bos.bosrl;

import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.recipe.ArcFurnanceRecipe;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;

public class ArcFurnanceRecipeCategory implements IRecipeCategory<ArcFurnanceRecipe> {
    public final static ResourceLocation UID = bosrl("arc_blasting");
    public final static ResourceLocation TEXTURE =bosrl("textures/gui/arc_furnance.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ArcFurnanceRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(RegisterBlock.ARC_FURNANCE.get()));
    }

    @Override
    public RecipeType<ArcFurnanceRecipe> getRecipeType() {
        return JEI.ARC_BLASTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Arc Furnance");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ArcFurnanceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 13).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 134, 13).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem(null));
    }
}
