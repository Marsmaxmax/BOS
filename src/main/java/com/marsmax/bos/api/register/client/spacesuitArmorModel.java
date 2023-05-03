package com.marsmax.bos.api.register.client;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.custom.spacesuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class spacesuitArmorModel extends GeoModel<spacesuitArmorItem>{
    @Override
    public ResourceLocation getModelResource(spacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(spacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "textures/armor/spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(spacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "animations/spacesuit.animation.json");
    }
}
