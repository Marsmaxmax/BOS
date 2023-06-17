package com.marsmax.bos.atmosphere;

import com.marsmax.bos.api.atmosphere.IAtmosphereHandler;

import net.minecraft.world.level.Level;

public class AtmosphereManager implements IAtmosphereHandler {
        //TODO: Atmosphere
    @Override
    public boolean canBreathe(Level level) {
        if(getOxygenLevel(level) <= 0.35f && getOxygenLevel(level) > 0.15f && 
           getCO2Level(level) <= 0.1f && getNLevel(level) <= 80 && getOtherGasesLevel(level) <= 0.05) {
                return true;
        } else {
            return false;
        }
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
    public float getAtmospherePressure(Level level){
        return 1;
    }

    @Override
    public void onTick(Level level) {
        
    }
}