package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	//Declaration of Items
	public static Item itemRoughCrystal;
	public static Item itemCrystalFragment;
		
	//Declaration of Tools/Weapons
	public static Item itemFlintPickaxe;
	public static Item itemFlintAxe;
	public static Item itemFlintShovel;
	public static Item itemFlintHoe;
	public static Item itemFlintSword;
	
	//Declaration of Armor
	public static Item apprenticeHood;
	public static Item apprenticeRobe;
	public static Item apprenticeLeggings;
	public static Item apprenticeBoots;

	//Declaration of Materials
	//Example Tool Material: public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
	public static ToolMaterial flintToolMaterial = EnumHelper.addToolMaterial("flintToolMaterial", 1, 131, 4.0F, 1.0F, 5);
	//Example Armor Material: public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("NAME", durability, damageReduction[], enchantability);
	public static ArmorMaterial apprenticeArmorMaterial = EnumHelper.addArmorMaterial("apprenticeArmor", 5, new int[] {1, 3, 2, 1}, 15);	
	
	
	public static final void init() 
	{
		//Instance of Each Item
		itemRoughCrystal = new Item().setUnlocalizedName("ItemRoughCrystal").setTextureName(Main.MODID + ":itemRoughCrystal").setCreativeTab(CreativeTabs.tabMisc);
		itemCrystalFragment = new Item().setUnlocalizedName("ItemCrystalFragment").setTextureName(Main.MODID + ":itemCrystalFragment").setCreativeTab(CreativeTabs.tabMisc);

		//Register of Each Item
		GameRegistry.registerItem(itemRoughCrystal, "ItemRoughCrystal");
		GameRegistry.registerItem(itemCrystalFragment, "ItemCrystalFragment");	
		GameRegistry.registerItem(itemFlintPickaxe = new ItemFlintPickaxe("itemFlintPickaxe", flintToolMaterial), "itemFlintPickaxe");
		GameRegistry.registerItem(itemFlintAxe = new ItemFlintAxe("itemFlintAxe", flintToolMaterial), "itemFlintAxe");
		GameRegistry.registerItem(itemFlintShovel = new ItemFlintShovel("itemFlintShovel", flintToolMaterial), "itemFlintShovel");
		GameRegistry.registerItem(itemFlintHoe = new ItemFlintHoe("itemFlintHoe", flintToolMaterial), "itemFlintHoe");
		GameRegistry.registerItem(itemFlintSword = new ItemFlintSword("itemFlintSword", flintToolMaterial), "itemFlintSword");
	}
}
