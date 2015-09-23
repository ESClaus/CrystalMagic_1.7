package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModCrafting
{
	public static final void init()
	{
		// Insert Crafting/Smelting Recipes Here

		// Rough Crystal Recipe, C = itemCrystalFragement
		GameRegistry.addRecipe(new ItemStack(ModItems.itemRoughCrystal), "CC", "CC", 'C', ModItems.itemCrystalFragment);

		// Crystal Block Recipe, C = Cobble, S = Sand, R = itemRoughCrystal
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCrystal), "CSC", "SRS", "CSC", 'C', Blocks.cobblestone, 'S', Blocks.sand, 'R', ModItems.itemRoughCrystal);

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
