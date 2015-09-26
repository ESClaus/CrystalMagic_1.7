package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModItems
{
	// Declaration of Items
	public static final ItemCrystalMagic itemRoughCrystal = new ItemRoughCrystal();
	public static final ItemCrystalMagic itemCrystalFragment = new ItemCrystalFragment();

	// Declaration of Tools/Weapons
	// Example: public static Item itemFlintPickaxe;
	public static Item itemCrystalEdgedPickaxe;

	// Declaration of Armor
	public static Item apprenticeHood;
	public static Item apprenticeRobe;
	public static Item apprenticeLeggings;
	public static Item apprenticeBoots;

	// Declaration of Materials
	// Example Tool Material: public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
	public static ToolMaterial crystalEdgedToolMaterial = EnumHelper.addToolMaterial("crystalEdgedToolMaterial", 2, 131, 4.0f, 1.0f, 5); // Placeholder crystalEdgedToolMaterial

	// Example Armor Material: public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("NAME", durability, damageReduction[], enchantability);
	public static ArmorMaterial apprenticeArmorMaterial = EnumHelper.addArmorMaterial("apprenticeArmor", 5, new int[]{1, 3, 2, 1}, 15);

	public static void init()
	{
		// Register of Each Item
		GameRegistry.registerItem(itemRoughCrystal, "ItemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "ItemCrystalFragment");
		GameRegistry.registerItem(itemCrystalEdgedPickaxe = new ItemCrystalEdgedPickaxe("ItemCrystalEdgedPickaxe", crystalEdgedToolMaterial), "ItemCrystalEdgedPickaxe");

		// Register of Each Piece of Armor
		// Apprentice Armor
		GameRegistry.registerItem(apprenticeHood = new ItemApprenticeArmor("ItemApprenticeHood", apprenticeArmorMaterial, "apprenticeArmor", 0), "ItemApprenticeHood"); // 0 for Helm
		GameRegistry.registerItem(apprenticeRobe = new ItemApprenticeArmor("ItemApprenticeRobe", apprenticeArmorMaterial, "apprenticeArmor", 1), "ItemApprenticeRobe"); // 1 for Chestplate
		GameRegistry.registerItem(apprenticeLeggings = new ItemApprenticeArmor("ItemApprenticeLeggings", apprenticeArmorMaterial, "apprenticeArmor", 2), "ItemApprenticeLeggings"); // 2 for Leggings
		GameRegistry.registerItem(apprenticeBoots = new ItemApprenticeArmor("ItemApprenticeBoots", apprenticeArmorMaterial, "apprenticeArmor", 3), "ItemApprenticeBoots"); // 3 for Boots
	}
}
