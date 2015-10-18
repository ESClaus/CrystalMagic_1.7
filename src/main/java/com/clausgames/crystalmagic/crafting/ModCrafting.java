package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.blocks.plants.ModPlants;
import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.armor.ModArmor;
import com.clausgames.crystalmagic.items.fragments.ModFragments;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting
{
	public static void init()
	{
		// Insert Crafting/Smelting Recipes Here
		//Crystal Codex Recipe, Shapeless, Crystal Fragment + Book
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCrystalCodex), ModItems.itemRoughCrystalFragment, Items.book);

		//Golden Bars, G = Gold Ingot
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockGoldenBars, 16), "GGG", "GGG", 'G', Items.gold_ingot);

		//OreInfusedStones, O = OreType, S = Stone, C = CrystalFragment.
		GameRegistry.addRecipe(new ItemStack(ModPlants.crystalInfusedStone), "OSO", "SCS", "OSO", 'O', ModItems.itemCrystal, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.coalInfusedStone), "OSO", "SCS", "OSO", 'O', Items.coal, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.redstoneInfusedStone), "OSO", "SCS", "OSO", 'O', Items.redstone, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.lapisInfusedStone), "OSO", "SCS", "OSO", 'O', new ItemStack(Items.dye, 1, 4), 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.quartzInfusedStone), "OSO", "SCS", "OSO", 'O', Items.quartz, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.ironInfusedStone), "OSO", "SCS", "OSO", 'O', Items.iron_ingot, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.goldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.gold_ingot, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.diamondInfusedStone), "OSO", "SCS", "OSO", 'O', Items.diamond, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.emeraldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.emerald, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);

		//Machines
		//Socket Station, F = itemCrystal, C = CraftTable, A = Anvil
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSocketStation), "FFF", "FCF", "FAF", 'F', ModItems.itemCrystal, 'C', Blocks.crafting_table, 'A', Blocks.anvil);

		// Crystal Edged Pickaxe Recipe, F = itemCrystalFragment, I = Iron
		//GameRegistry.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe), " F ", "FIF", 'F', ModItems.itemCrystalFragment, 'I', new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE)); //TODO Remove

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
