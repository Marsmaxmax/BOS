package com.marsmax.bos.register;

import com.marsmax.bos.Bos;
import com.marsmax.bos.api.CreativeTab;
import net.minecraftforge.event.CreativeModeTabEvent.BuildContents;

public class RegisterCreativeTab extends Bos{

    @Override
    public void addCreativeTab(BuildContents event) {
        if (event.getTab() == CreativeTab.BOS_TAB) {
            //Chips
            event.accept(RegisterItem.ASTEROID_CHIP);
            event.accept(RegisterItem.SATELLITE_CHIP);
            event.accept(RegisterItem.STATION_CHIP);
            event.accept(RegisterItem.PLANET_CHIP);
            event.accept(RegisterItem.ELEVATOR_CHIP);
            event.accept(RegisterItem.BASIC_CIRCUIT);
            event.accept(RegisterItem.ADV_CIRCUIT);
            event.accept(RegisterItem.TRACK_CIRCUIT);
            event.accept(RegisterItem.ITEM_CIRCUIT);
            event.accept(RegisterItem.LIQUID_CIRCUIT);
            event.accept(RegisterItem.CONTR_CIRCUIT);

            //Rocket Blocks
            event.accept(RegisterBlock.LAUNCHPAD);

            //Armor
            event.accept(RegisterItem.SPACESUIT_HELMET);
            event.accept(RegisterItem.SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.SPACESUIT_BOOTS);
            event.accept(RegisterItem.NETHER_SPACESUIT_HELMET);
            event.accept(RegisterItem.NETHER_SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.NETHER_SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.NETHER_SPACESUIT_BOOTS);
        }

        if (event.getTab() == CreativeTab.BOS_RES_TAB) {

            //Dilithium
            event.accept(RegisterItem.DILITHIUM_CRYSTAL);
            event.accept(RegisterItem.DILITIUM_DUST);
            event.accept(RegisterBlock.DILITHIUM_ORE);
            event.accept(RegisterBlock.DILITHIUM_BLOCK);

            //Iridium
            event.accept(RegisterItem.IRIDIUM_RAW);
            event.accept(RegisterItem.IRIDIUM_INGOT);
            event.accept(RegisterBlock.IRIDIUM_ORE);
            event.accept(RegisterBlock.IRIDIUM_BLOCK);
            event.accept(RegisterBlock.IRIDIUM_COIL);

            //Tin
            event.accept(RegisterItem.TIN_RAW);
            event.accept(RegisterItem.TIN_INGOT);
            event.accept(RegisterBlock.TIN_ORE);
            event.accept(RegisterBlock.TIN_BLOCK);
            event.accept(RegisterBlock.TIN_COIL);

            //Titanium
            event.accept(RegisterItem.TITANIUM_RAW);
            event.accept(RegisterItem.TITANIUM_INGOT);
            event.accept(RegisterBlock.TITANIUM_ORE);
            event.accept(RegisterBlock.TITANIUM_BLOCK);
            event.accept(RegisterBlock.TITANIUM_COIL);

        }
        super.addCreativeTab(event);
    }
    
}
