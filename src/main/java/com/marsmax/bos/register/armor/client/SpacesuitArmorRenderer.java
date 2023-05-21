package com.marsmax.bos.register.armor.client;

import com.marsmax.bos.register.armor.custom.SpacesuitArmorItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpacesuitArmorRenderer extends GeoArmorRenderer<SpacesuitArmorItem> {
    public SpacesuitArmorRenderer() {
        super(new SpacesuitArmorModel());
    }
}