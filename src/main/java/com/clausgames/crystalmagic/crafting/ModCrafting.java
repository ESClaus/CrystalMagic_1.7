package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.item.armor.ModArmor;
import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.item.ModItems;

import com.clausgames.crystalmagic.item.tool.ModTools;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.coalInfusedStone), "OSO", "SCS", "OSO", 'O', Items.coal, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.redstoneInfusedStone), "OSO", "SCS", "OSO", 'O', Items.redstone, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.lapisInfusedStone), "OSO", "SCS", "OSO", 'O', new ItemStack(Items.dye, 1, 4), 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.quartzInfusedStone), "OSO", "SCS", "OSO", 'O', Items.quartz, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ironInfusedStone), "OSO", "SCS", "OSO", 'O', Items.iron_ingot, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.goldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.gold_ingot, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.diamondInfusedStone), "OSO", "SCS", "OSO", 'O', Items.diamond, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.emeraldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.emerald, 'S', Blocks.stone, 'C', ModItems.itemCrystalFragment);

		// Crystal Edged Pickaxe Recipe, F = itemCrystalFragment, I = Iron
		GameRegistry.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe), " F ", "FIF", 'F', ModItems.itemCrystalFragment, 'I', new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE));

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
