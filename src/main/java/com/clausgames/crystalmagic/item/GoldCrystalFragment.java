package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.plants.ModPlants;

public class GoldCrystalFragment extends OreCrystalFragment
{

    public GoldCrystalFragment()
    {
        super(ModPlants.goldCrystalPlant, ModBlocks.goldInfusedStone);
        setUnlocalizedName("GoldCrystalFragment");
    }
}