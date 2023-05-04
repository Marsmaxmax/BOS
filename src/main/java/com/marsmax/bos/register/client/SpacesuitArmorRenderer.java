package com.marsmax.bos.register.client;

import com.marsmax.bos.register.custom.spacesuitArmorItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpacesuitArmorRenderer extends GeoArmorRenderer<spacesuitArmorItem> {
    public SpacesuitArmorRenderer() {
        super(new SpacesuitArmorModel());
    }
}