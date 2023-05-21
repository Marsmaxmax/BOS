package com.marsmax.bos.register.armor.client;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.armor.custom.SpacesuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpacesuitArmorModel extends GeoModel<SpacesuitArmorItem>{
    @Override
    public ResourceLocation getModelResource(SpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "textures/armor/spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "animations/spacesuit.animation.json");
    }
}
