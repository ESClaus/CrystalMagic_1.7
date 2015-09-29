package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModBlocks
{
	// Declaration of Blocks
	public static final BlockCrystalMagic blockCrystal = new BlockCrystal() ;

	public static void init()
	{
		GameRegistry.registerBlock(blockCrystal, "blockCrystal");
	}
}