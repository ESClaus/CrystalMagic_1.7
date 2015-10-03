package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModItems
{
	// Declaration of Items
	public static ItemCrystalMagic itemCrystalCodex = new ItemCrystalCodex("ItemCrystalCodex", LibMisc.MODID + ":ItemCrystalCodex");
	public static ItemCrystalMagic itemRoughCrystal = new ItemRoughCrystal("ItemRoughCrystal", LibMisc.MODID + ":ItemRoughCrystal");
	public static ItemCrystalMagic itemCrystalFragment = new ItemCrystalFragment("ItemCrystalFragment", LibMisc.MODID + ":ItemCrystalFragment");
	public static ItemCrystalMagic itemNatureCrystal = new ItemNatureCrystal("ItemNatureCrystal", LibMisc.MODID + ":ItemNatureCrystal");
	public static OreCrystalFragment itemGoldCrystalFragment = new GoldCrystalFragment("ItemGoldCrystalFragment", LibMisc.MODID + ":ItemGoldCrystalFragment");

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemCrystalCodex, "itemCrystalCodex");
		GameRegistry.registerItem(itemRoughCrystal, "itemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "itemCrystalFragment");
		GameRegistry.registerItem(itemNatureCrystal, "itemNatureCrystal");
		GameRegistry.registerItem(itemGoldCrystalFragment, "itemGoldCrystalFragment");
	}
}
