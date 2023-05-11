package com.marsmax.bos.atmosphere;

import com.marsmax.bos.api.atmosphere.IAtmosphereHandler;
import net.minecraft.world.level.Level;

public class AtmosphereManager implements IAtmosphereHandler {
        //TODO: Atmosphere
    @Override
    public boolean canBreathe(Level level) {

        return true;
    }

    @Override
    public float getOxygenLevel(Level level) {

        return 0.21f; //Example: 21% Oxygen
    }

    @Override
    public float getCO2Level(Level level) {

        return 0.01f;
    }

    @Override
    public float getNLevel(Level level) {

        return 0.71f;
    }

    @Override
    public float getOtherGasesLevel(Level level){
        return 0.001f;
    }

    @Override
    public void onTick(Level level) {

    }
}