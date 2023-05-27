package com.marsmax.bos.register.recipe;

import com.marsmax.bos.Bos;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterModRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Bos.MODID);

    public static final RegistryObject<RecipeSerializer<ArcFurnanceRecipe>> ARC_BLASTING =
        SERIALIZERS.register("arc_blasting", () -> ArcFurnanceRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
