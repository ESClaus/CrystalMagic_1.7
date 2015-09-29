package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModBlocks
{
	// Declaration of Blocks
	public static final BlockCrystalMagic blockCrystal = new BlockCrystal() ;
	public static Block blockCrystalOre = new BlockCrystalOre(Material.rock);

	public static void init()
	{
		GameRegistry.registerBlock(blockCrystal, "blockCrystal");
		GameRegistry.registerBlock(blockCrystalOre, "BlockCrystalOre");
	}
}