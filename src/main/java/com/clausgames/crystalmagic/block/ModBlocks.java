package com.clausgames.crystalmagic.block;

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

	//Plants
	public static Block goldCrystalPlant = new GoldCrystalPlant();

	//OreInfused Stone
	public static OreInfusedStone coalInfusedStone = new CoalInfusedStone(Material.rock);
	public static OreInfusedStone redstoneInfusedStone = new RedstoneInfusedStone(Material.rock);
	public static OreInfusedStone lapisInfusedStone = new LapisInfusedStone(Material.rock);
	public static OreInfusedStone quartzInfusedStone = new QuartzInfusedStone(Material.rock);
	public static OreInfusedStone ironInfusedStone = new IronInfusedStone(Material.rock);
	public static OreInfusedStone goldInfusedStone = new GoldInfusedStone(Material.rock);
	public static OreInfusedStone diamondInfusedStone = new DiamondInfusedStone(Material.rock);
	public static OreInfusedStone emeraldInfusedStone = new EmeraldInfusedStone(Material.rock);

	public static void init()
	{
		GameRegistry.registerBlock(blockCrystalOre, "blockCrystalOre");
		GameRegistry.registerBlock(blockGoldenBars, "blockGoldenBars");

		//Plants
		GameRegistry.registerBlock(goldCrystalPlant, "goldCrystalPlant");

		//OreInfused Stone
		GameRegistry.registerBlock(coalInfusedStone, "CoalInfusedStone");
		GameRegistry.registerBlock(redstoneInfusedStone, "RedstoneInfusedStone");
		GameRegistry.registerBlock(lapisInfusedStone, "LapisInfusedStone");
		GameRegistry.registerBlock(quartzInfusedStone, "QuartzInfusedStone");
		GameRegistry.registerBlock(ironInfusedStone, "IronInfusedStone");
		GameRegistry.registerBlock(goldInfusedStone, "GoldInfusedStone");
		GameRegistry.registerBlock(diamondInfusedStone, "DiamondInfusedStone");
		GameRegistry.registerBlock(emeraldInfusedStone, "EmeraldInfusedStone");
	}
}