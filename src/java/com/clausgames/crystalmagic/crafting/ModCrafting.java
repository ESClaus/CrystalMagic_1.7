package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting
{
	public static final void init()
	{
		// Insert Crafting/Smelting Recipes Here

		// Crystal Block Recipe, C = Cobble, S = Sand, R = itemRoughCrystal
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCrystal), "CSC", "SRS", "CSC", 'C', Blocks.cobblestone, 'S', Blocks.sand, 'R', ModItems.itemRoughCrystal);

		// Crystal Edged Pickaxe Recipe, F = itemCrystalFragment, I = Iron, S = Stick
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCrystalEdgedPickaxe), "FIF", " S ", " S ", 'F', ModItems.itemCrystalFragment, 'I', Items.iron_ingot, 'S', Items.stick);

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
