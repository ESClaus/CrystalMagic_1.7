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
		//Insert Crafting/Smelting Recipes Here
		
		//Crystal Block Recipe, C = Cobble, S = Sand, R = Rough Crystal
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCrystal), "CSC","SRS","CSC", 'C', Blocks.cobblestone, 'S', Blocks.sand, 'R', ModItems.itemRoughCrystal);
				
		//Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeHood), new Object[]{"WWW","W W", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeRobe), new Object[]{"W W","WWW","WWW", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeLeggings), new Object[]{"WWW","W W","W W", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModItems.apprenticeBoots), new Object[]{"W W","W W", 'W', Blocks.wool});
	}
}
