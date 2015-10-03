package com.clausgames.crystalmagic.achievement;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.item.tool.ModTools;
import com.clausgames.crystalmagic.lib.LibAchievementNames;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class ModAchievements
{
	public static AchievementPage crystalmagicPage;
	public static int pageIndex;

	public static Achievement crystalFragmentPickup;
	public static Achievement roughCrystalPickUp;
	public static Achievement crystalEdgedPickaxeCraft;
	public static Achievement goldenBarsCraft;
	
	public static void init()
	{
		crystalFragmentPickup = new AchievementMod(LibAchievementNames.CRYSTALFRAGMENT_PICKUP, 0, 0, new ItemStack(ModItems.itemCrystalFragment), null);
		crystalEdgedPickaxeCraft = new AchievementMod(LibAchievementNames.CRYSTALEDGEDPICKAXE_CRAFT, 2, 0, ModTools.itemCrystalEdgedPickaxe, crystalFragmentPickup);
		roughCrystalPickUp = new AchievementMod(LibAchievementNames.ROUGHCRYSTAL_PICKUP, 4, 1, new ItemStack(ModItems.itemRoughCrystal), crystalEdgedPickaxeCraft);
		goldenBarsCraft = new AchievementMod(LibAchievementNames.GOLDENBARS_CRAFT, 4, 3, ModBlocks.blockGoldenBars, null);

		
		pageIndex = AchievementPage.getAchievementPages().size();
		crystalmagicPage = new AchievementPage(LibMisc.MODNAME, AchievementMod.achievements.toArray(new Achievement[AchievementMod.achievements.size()]));
		AchievementPage.registerAchievementPage(crystalmagicPage);
		
		FMLCommonHandler.instance().bus().register(new AchievementTriggerer());
	}
}
