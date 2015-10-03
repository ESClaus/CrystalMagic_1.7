package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModItems
{
	// Declaration of Items
	public static final ItemCrystalMagic itemCrystalCodex = new ItemCrystalCodex();
	public static final ItemCrystalMagic itemRoughCrystal = new ItemRoughCrystal();
	public static final ItemCrystalMagic itemCrystalFragment = new ItemCrystalFragment();
	public static final ItemCrystalMagic itemNatureCrystal = new ItemNatureCrystal();

	public static final OreCrystalFragment goldCrystalFragment = new GoldCrystalFragment();

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemCrystalCodex, "itemCrystalCodex");
		GameRegistry.registerItem(itemRoughCrystal, "itemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "itemCrystalFragment");
		GameRegistry.registerItem(itemNatureCrystal, "itemNatureCrystal");

		GameRegistry.registerItem(goldCrystalFragment, "goldCrystalFragment");
	}
}
