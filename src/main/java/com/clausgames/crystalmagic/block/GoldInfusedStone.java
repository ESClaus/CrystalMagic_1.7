package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.lib.LibMisc;

public class GoldInfusedStone extends OreInfusedStone
{
    protected GoldInfusedStone()
    {
        this.setBlockName("GoldInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName());
    }
}