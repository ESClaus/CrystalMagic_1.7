package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems
{
	// Declaration of Items
	public static Item itemRoughCrystal;
	public static Item itemCrystalFragment;

	// Declaration of Tools/Weapons
	// Example: public static Item itemFlintPickaxe;

	// Declaration of Armor
	public static Item apprenticeHood;
	public static Item apprenticeRobe;
	public static Item apprenticeLeggings;
	public static Item apprenticeBoots;

	// Declaration of Materials
	// Example Tool Material: public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
	// Example: public static ToolMaterial flintToolMaterial = EnumHelper.addToolMaterial("flintToolMaterial", 1, 131, 4.0F, 1.0F, 5);

	// Example Armor Material: public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("NAME", durability, damageReduction[], enchantability);
	public static ArmorMaterial apprenticeArmorMaterial = EnumHelper.addArmorMaterial("apprenticeArmor", 5, new int[] { 1, 3, 2, 1 }, 15);

	public static final void init()
	{
		// Instance of Each Item
		itemRoughCrystal = new Item().setUnlocalizedName("ItemRoughCrystal").setTextureName(CrystalMagic.MODID + ":itemRoughCrystal").setCreativeTab(CreativeTabs.tabMisc);
		itemCrystalFragment = new Item().setUnlocalizedName("ItemCrystalFragment").setTextureName(CrystalMagic.MODID + ":itemCrystalFragment").setCreativeTab(CreativeTabs.tabMisc);

		// Register of Each Item
		GameRegistry.registerItem(itemRoughCrystal, "ItemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "ItemCrystalFragment");
		// ExampleTool: GameRegistry.registerItem(itemFlintPickaxe = new ItemFlintPickaxe("itemFlintPickaxe", flintToolMaterial), "itemFlintPickaxe");

		// Register of Each Piece of Armor
		// Apprentice Armor
		GameRegistry.registerItem(apprenticeHood = new ItemApprenticeArmor("ItemApprenticeHood", apprenticeArmorMaterial, "apprenticeArmor", 0), "ItemApprenticeHood"); // 0 for Helm
		GameRegistry.registerItem(apprenticeRobe = new ItemApprenticeArmor("ItemApprenticeRobe", apprenticeArmorMaterial, "apprenticeArmor", 1), "ItemApprenticeRobe"); // 1 for Chestplate
		GameRegistry.registerItem(apprenticeLeggings = new ItemApprenticeArmor("ItemApprenticeLeggings", apprenticeArmorMaterial, "apprenticeArmor", 2), "ItemApprenticeLeggings"); // 2 for Leggings
		GameRegistry.registerItem(apprenticeBoots = new ItemApprenticeArmor("ItemApprenticeBoots", apprenticeArmorMaterial, "apprenticeArmor", 3), "ItemApprenticeBoots"); // 3 for Boots

	}
}
