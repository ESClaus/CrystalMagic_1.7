package com.clausgames.crystalmagic.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	//Declaration of Blocks
	public static Block blockCrystal;
	
	public static final void init() 
	{
		GameRegistry.registerBlock(blockCrystal = new CrystalBlock("BlockCrystal", Material.rock), "blockCrystal");
	}

}
