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
    * Gibt den aktuellen Sauerstoffgehalt in der Atmosphäre zurück.
    * 
    * @param level Die Welt, in der sich der Spieler befindet.
    * @return Der Sauerstoffgehalt als Dezimalzahl zwischen 0 und 1.
    */
    float getOxygenLevel(Level level);

    /**
    * Gibt den aktuellen CO2 Wert in der Atmosphäre zurück.
    * 
    * @param level Die Welt, in der sich der Spieler befindet.
    * @return Der Co2 Wert als Dezimalzahl zwischen 0 und 1.
    */
    float getCO2Level(Level level);

    /**
    * Wird aufgerufen, um die Atmosphärenbedingungen im Spiel im Laufe der Zeit zu aktualisieren.
    * 
    * @param level Die Welt, in der sich der Spieler befindet.
    */
    void onTick(Level level);
    
}
