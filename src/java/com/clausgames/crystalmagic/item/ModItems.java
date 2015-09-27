package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.lib.LibMaterial;
import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModItems
{
	// Declaration of Items
	public static final ItemCrystalMagic itemRoughCrystal = new ItemRoughCrystal();
	public static final ItemCrystalMagic itemCrystalFragment = new ItemCrystalFragment();
	public static final ItemCrystalMagic itemNatureCrystal = new ItemNatureCrystal();

	// Declaration of Tools/Weapons
	// Example: public static Item itemFlintPickaxe;
	public static Item itemCrystalEdgedPickaxe;

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemRoughCrystal, "ItemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "ItemCrystalFragment");
		GameRegistry.registerItem(itemNatureCrystal, "ItemNatureCrystal");

		//Register of Tools
		GameRegistry.registerItem(itemCrystalEdgedPickaxe = new ItemCrystalEdgedPickaxe("ItemCrystalEdgedPickaxe", LibMaterial.Tools.crystalEdgedToolMaterial), "ItemCrystalEdgedPickaxe");
	}
}
