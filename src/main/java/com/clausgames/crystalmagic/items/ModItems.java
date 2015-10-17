package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.items.fragments.*;
import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModItems
{
	// Declaration of Items
	public static ItemCrystalMagic itemDebugOrePlants = new itemDebugOrePlants("ItemDebugOrePlants", LibMisc.MODID + ":ItemDebugOrePlants");
	public static ItemCrystalMagic itemCrystalCodex = new ItemCrystalCodex("ItemCrystalCodex", LibMisc.MODID + ":ItemCrystalCodex");
	public static ItemCrystalMagic itemRoughCrystal = new ItemRoughCrystal("ItemRoughCrystal", LibMisc.MODID + ":ItemRoughCrystal");
	public static ItemCrystalMagic itemCrystal = new ItemCrystal("ItemCrystal", LibMisc.MODID + ":ItemCrystal");
	public static ItemCrystalMagic itemRoughCrystalFragment = new ItemRoughCrystalFragment("ItemRoughCrystalFragment", LibMisc.MODID + ":ItemRoughCrystalFragment");
	public static ItemCrystalMagic itemNatureCrystal = new ItemNatureCrystal("ItemNatureCrystal", LibMisc.MODID + ":ItemNatureCrystal");

	//Sockets
	public static ItemSocket itemEmptySocket = new ItemEmptySocket("ItemEmptySocket", LibMisc.MODID + ":ItemEmptySocket");

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemDebugOrePlants, "itemDebugOrePlants");
		GameRegistry.registerItem(itemCrystalCodex, "itemCrystalCodex");
		GameRegistry.registerItem(itemRoughCrystal, "itemRoughCrystal");
		GameRegistry.registerItem(itemCrystal, "itemCrystal");
		GameRegistry.registerItem(itemRoughCrystalFragment, "itemRoughCrystalFragment");
		GameRegistry.registerItem(itemNatureCrystal, "itemNatureCrystal");

		//Sockets
		GameRegistry.registerItem(itemEmptySocket, "itemEmptySocket");
	}
}
