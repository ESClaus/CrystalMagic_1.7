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
	public static Block crystalPlant = new CrystalPlant();
	public static Block coalCrystalPlant = new CoalCrystalPlant();
	public static Block redstoneCrystalPlant = new RedstoneCrystalPlant();
	public static Block lapisCrystalPlant = new LapisCrystalPlant();
	public static Block quartzCrystalPlant = new QuartzCrystalPlant();
	public static Block ironCrystalPlant = new IronCrystalPlant();
	public static Block goldCrystalPlant = new GoldCrystalPlant();
	public static Block diamondCrystalPlant = new DiamondCrystalPlant();
	public static Block emeraldCrystalPlant = new EmeraldCrystalPlant();

	//OreInfused Stone
	public static OreInfusedStone crystalInfusedStone = new CrystalInfusedStone(Material.rock);
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
		GameRegistry.registerBlock(crystalPlant, "crystalPlant");
		GameRegistry.registerBlock(coalCrystalPlant, "coalCrystalPlant");
		GameRegistry.registerBlock(redstoneCrystalPlant, "redstoneCrystalPlant");
		GameRegistry.registerBlock(lapisCrystalPlant, "lapisCrystalPlant");
		GameRegistry.registerBlock(quartzCrystalPlant, "quartzCrystalPlant");
		GameRegistry.registerBlock(ironCrystalPlant, "ironCrystalPlant");
		GameRegistry.registerBlock(goldCrystalPlant, "goldCrystalPlant");
		GameRegistry.registerBlock(diamondCrystalPlant, "diamondCrystalPlant");
		GameRegistry.registerBlock(emeraldCrystalPlant, "emeraldCrystalPlant");

		//OreInfused Stone
		GameRegistry.registerBlock(crystalInfusedStone, "CrystalInfusedStone");
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