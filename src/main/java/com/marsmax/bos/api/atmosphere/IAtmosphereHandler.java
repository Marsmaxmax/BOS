package com.marsmax.bos.api.atmosphere;

import net.minecraft.world.level.Level;

public interface IAtmosphereHandler {    
    /**
    * Checks if the player can breathe in this atmosphere
    * 
    * @param level level the player is currently on
    * @return True, if player can breathe, else false 
    */
    boolean canBreathe(Level level);

    /**
    * gets Oxygen level 
    * 
    * @param level level the player is currently on
    * @return Oxygen level as a number between 0 and 1
    */
    float getOxygenLevel(Level level);

    /**
    * gets Co2 level
    * 
    * @param level level the player is currently on
    * @return Co2  level as a number between 0 and 1
    */
    float getCO2Level(Level level);

    /**
    * Gets Nitrogen level
    * 
    * @param level level the player is currently on
    * @return nitrogen  level as a number between 0 and 1
    */
    float getNLevel(Level level);

    /**
    * Gets the level of other gases in the atmosphere
    * 
    * @param level level the player is currently on
    * @return level of other gases as a number between 0 and 1
    */
    float getOtherGasesLevel(Level level);

    /**
     * Gets the atmospher pressure
     * @param level the player is currently on
     * @return the atmospheric pressure
     */
    float getAtmospherePressure(Level level);

    /**
    *gets called to trigger the atmosphere
    * 
    * @param level level the player is currently on
    */
    void onTick(Level level);
}
