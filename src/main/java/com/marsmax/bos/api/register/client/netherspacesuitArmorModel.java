package com.marsmax.bos.api.register.client;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.register.custom.netherspacesuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class netherspacesuitArmorModel extends GeoModel<netherspacesuitArmorItem>{
    @Override
    public ResourceLocation getModelResource(netherspacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(netherspacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "textures/armor/spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(netherspacesuitArmorItem animatable) {
        return new ResourceLocation(Bos.MODID, "animations/spacesuit.animation.json");
    }
}
