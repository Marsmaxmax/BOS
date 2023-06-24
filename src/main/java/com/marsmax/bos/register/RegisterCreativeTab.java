package com.marsmax.bos.register;

import com.marsmax.bos.api.CreativeTab;
import com.marsmax.bos.register.block.RegisterBlock;
import com.marsmax.bos.register.item.RegisterItem;

import net.minecraftforge.event.CreativeModeTabEvent.BuildContents;


public class RegisterCreativeTab {

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

            event.accept(RegisterBlock.LAUNCHPAD);

            event.accept(RegisterItem.SPACESUIT_HELMET);
            event.accept(RegisterItem.SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.SPACESUIT_BOOTS);
            event.accept(RegisterItem.NETHER_SPACESUIT_HELMET);
            event.accept(RegisterItem.NETHER_SPACESUIT_CHESTPLATE);
            event.accept(RegisterItem.NETHER_SPACESUIT_LEGGINGS);
            event.accept(RegisterItem.NETHER_SPACESUIT_BOOTS);

            event.accept(RegisterItem.ALUMINIUM_DUST);
            event.accept(RegisterItem.TIN_DUST);
            event.accept(RegisterItem.TITANIUM_DUST);
            event.accept(RegisterItem.IRIDIUM_DUST);
            event.accept(RegisterItem.DILITIUM_DUST);

            event.accept(RegisterItem.ALUMINIUM_SHEET);
            event.accept(RegisterItem.TIN_SHEET);
            event.accept(RegisterItem.TITANIUM_SHEET);
            event.accept(RegisterItem.IRIDIUM_SHEET);

            event.accept(RegisterBlock.ALUMINIUM_COIL);
            event.accept(RegisterBlock.TIN_COIL);
            event.accept(RegisterBlock.TITANIUM_COIL);
            event.accept(RegisterBlock.IRIDIUM_COIL);
        }

        if (event.getTab() == CreativeTab.BOS_RES_TAB) {

            event.accept(RegisterBlock.BAUXIT_ORE);
            event.accept(RegisterBlock.TIN_ORE);
            event.accept(RegisterBlock.IRIDIUM_ORE);
            event.accept(RegisterBlock.DILITHIUM_ORE);
            event.accept(RegisterBlock.TITANIUM_ORE);

            event.accept(RegisterBlock.TIN_ORE_DEEPSLATE);
            event.accept(RegisterBlock.IRIDIUM_ORE_DEEPSLATE);
            event.accept(RegisterBlock.TITANIUM_ORE_DEEPSLATE);

            event.accept(RegisterItem.BAUXITE_RAW);
            event.accept(RegisterItem.TIN_RAW);
            event.accept(RegisterItem.TITANIUM_RAW);
            event.accept(RegisterItem.IRIDIUM_RAW);
            event.accept(RegisterItem.DILITHIUM_CRYSTAL);

            event.accept(RegisterItem.ALUMINIUM_INGOT);
            event.accept(RegisterItem.ALUMINUM_TITANIUM_ALLOY_INGOT);
            event.accept(RegisterItem.TIN_INGOT);
            event.accept(RegisterItem.TITANIUM_INGOT);
            event.accept(RegisterItem.IRIDIUM_INGOT);
            event.accept(RegisterItem.SILICON_INGOT);

            event.accept(RegisterBlock.ALUMINIUM_BLOCK);
            event.accept(RegisterBlock.TIN_BLOCK);
            event.accept(RegisterBlock.TITANIUM_BLOCK);
            event.accept(RegisterBlock.IRIDIUM_BLOCK);
        }
    } 
    
}
