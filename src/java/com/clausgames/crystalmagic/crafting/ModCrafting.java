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
		//Insert Crafting/Smelting Recipes here
		//Crystal Block Recipe, C = Cobble, S = Sand, R = Rough Crystal
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCrystal), "CSC","SRS","CSC", 'C', Blocks.cobblestone, 'S', Blocks.sand, 'R', ModItems.itemRoughCrystal);
	}
}
