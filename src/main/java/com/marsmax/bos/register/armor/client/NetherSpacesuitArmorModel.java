package com.marsmax.bos.register.armor.client;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.armor.custom.NetherSpacesuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NetherSpacesuitArmorModel extends GeoModel<NetherSpacesuitArmorItem>{
    @Override
    public ResourceLocation getModelResource(NetherSpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetherSpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "textures/armor/spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetherSpacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "animations/spacesuit.animation.json");
    }
}
