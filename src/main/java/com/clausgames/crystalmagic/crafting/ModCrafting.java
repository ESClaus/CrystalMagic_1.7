package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.item.armor.ModArmor;
import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.item.ModItems;

import com.clausgames.crystalmagic.item.tool.ModTools;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting
{
	public static void init()
	{
		// Insert Crafting/Smelting Recipes Here
		//Crystal Codex Recipe, Shapless, Crystal Fragment + Book
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCrystalCodex), ModItems.itemCrystalFragment, Items.book);

		//Golden Bars, G = Gold Ingot
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockGoldenBars, 16), "GGG", "GGG", 'G', Items.gold_ingot);

		//OreInfusedStones, O = OreType, S = Stone.
		GameRegistry.addRecipe(new ItemStack(ModBlocks.goldInfusedStone), "OSO", "SOS", "OSO", 'O', Items.gold_ingot, 'S', Blocks.stone);

		// Crystal Edged Pickaxe Recipe, F = itemCrystalFragment, I = Iron
		GameRegistry.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe), " F ", "FIF", 'F', ModItems.itemCrystalFragment, 'I', Items.iron_pickaxe);

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
