package com.clausgames.crystalmagic.blocks;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModBlocks
{
	// Declaration of Blocks
	public static Block blockCrystalOre = new BlockCrystalOre(Material.rock);
	public static BlockGoldenBars blockGoldenBars = new BlockGoldenBars();
	public static BlockCrystalMagic blockSocketStation = new BlockSocketStation(Material.wood);

	public static void init()
	{
		//Blocks
		GameRegistry.registerBlock(blockCrystalOre, "blockCrystalOre");
		GameRegistry.registerBlock(blockGoldenBars, "blockGoldenBars");
		GameRegistry.registerBlock(blockSocketStation, "blockSocketStation");
	}
}