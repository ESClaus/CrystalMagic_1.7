package com.clausgames.crystalmagic.achievement;

import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.lib.LibAchievementNames;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class ModAchievements
{
	public static AchievementPage crystalmagicPage;
	public static int pageIndex;

	public static Achievement crystalFragment;
	public static Achievement roughCrystal;
	
	public static final void init()
	{
		crystalFragment = new AchievementMod(LibAchievementNames.CRYSTALFRAGMENT, 0, 4, new ItemStack(ModItems.itemCrystalFragment), null);
		roughCrystal = new AchievementMod(LibAchievementNames.ROUGHCRYSTAL, 1, 5, new ItemStack(ModItems.itemRoughCrystal), crystalFragment);
		
		pageIndex = AchievementPage.getAchievementPages().size();
		crystalmagicPage = new AchievementPage("Crystal Magic", AchievementMod.achievements.toArray(new Achievement[AchievementMod.achievements.size()])); 
		AchievementPage.registerAchievementPage(crystalmagicPage);
		
		FMLCommonHandler.instance().bus().register(new AchievementTriggerer());
	}
}
