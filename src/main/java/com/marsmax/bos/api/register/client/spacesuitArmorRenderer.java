package com.marsmax.bos.api.register.client;

import com.marsmax.bos.api.register.custom.spacesuitArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class spacesuitArmorRenderer extends GeoArmorRenderer<spacesuitArmorItem> {
    public spacesuitArmorRenderer() {
        super(new spacesuitArmorModel());
    }
}