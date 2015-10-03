package com.clausgames.crystalmagic.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModPlants
{
    // Declaration of Plants
    public static ModCrystalPlant goldCrystalPlant = new GoldCrystalPlant();

    public static void init()
    {
        //Registration of Plants
        GameRegistry.registerBlock(goldCrystalPlant, "goldCrystalPlant");
    }
}