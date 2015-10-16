package com.clausgames.crystalmagic.item;

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

	//OreCrystalFragments
	public static OreCrystalFragment itemCrystalFragment = new ItemCrystalFragment("ItemCrystalFragment", LibMisc.MODID + ":ItemCrystalFragment");
	public static OreCrystalFragment itemCoalCrystalFragment = new CoalCrystalFragment("ItemCoalCrystalFragment", LibMisc.MODID + ":ItemCoalCrystalFragment");
	public static OreCrystalFragment itemRedstoneCrystalFragment = new RedstoneCrystalFragment("ItemRedstoneCrystalFragment", LibMisc.MODID + ":ItemRedstoneCrystalFragment");
	public static OreCrystalFragment itemLapisCrystalFragment = new LapisCrystalFragment("ItemLapisCrystalFragment", LibMisc.MODID + ":ItemLapisCrystalFragment");
	public static OreCrystalFragment itemQuartzCrystalFragment = new QuartzCrystalFragment("ItemQuartzCrystalFragment", LibMisc.MODID + ":ItemQuartzCrystalFragment");
	public static OreCrystalFragment itemIronCrystalFragment = new IronCrystalFragment("ItemIronCrystalFragment", LibMisc.MODID + ":ItemIronCrystalFragment");
	public static OreCrystalFragment itemGoldCrystalFragment = new GoldCrystalFragment("ItemGoldCrystalFragment", LibMisc.MODID + ":ItemGoldCrystalFragment");
	public static OreCrystalFragment itemDiamondCrystalFragment = new DiamondCrystalFragment("ItemDiamondCrystalFragment", LibMisc.MODID + ":ItemDiamondCrystalFragment");
	public static OreCrystalFragment itemEmeraldCrystalFragment = new EmeraldCrystalFragment("ItemEmeraldCrystalFragment", LibMisc.MODID + ":ItemEmeraldCrystalFragment");

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemDebugOrePlants, "itemDebugOrePlants");
		GameRegistry.registerItem(itemCrystalCodex, "itemCrystalCodex");
		GameRegistry.registerItem(itemRoughCrystal, "itemRoughCrystal");
		GameRegistry.registerItem(itemCrystal, "itemCrystal");
		GameRegistry.registerItem(itemRoughCrystalFragment, "itemRoughCrystalFragment");
		GameRegistry.registerItem(itemCrystalFragment, "itemCrystalFragment");
		GameRegistry.registerItem(itemNatureCrystal, "itemNatureCrystal");

		//OreCrystalFragments
		GameRegistry.registerItem(itemCoalCrystalFragment, "itemCoalCrystalFragment");
		GameRegistry.registerItem(itemRedstoneCrystalFragment, "itemRedstoneCrystalFragment");
		GameRegistry.registerItem(itemLapisCrystalFragment, "itemLapisCrystalFragment");
		GameRegistry.registerItem(itemQuartzCrystalFragment, "itemQuartzCrystalFragment");
		GameRegistry.registerItem(itemIronCrystalFragment, "itemIronCrystalFragment");
		GameRegistry.registerItem(itemGoldCrystalFragment, "itemGoldCrystalFragment");
		GameRegistry.registerItem(itemDiamondCrystalFragment, "itemDiamondCrystalFragment");
		GameRegistry.registerItem(itemEmeraldCrystalFragment, "itemEmeraldCrystalFragment");
	}
}
