package com.clausgames.crystalmagic.achievement;

import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.lib.LibAchievementNames;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class ModAchievements
{
	public static AchievementPage crystalmagicPage;
	public static int pageIndex;
	
	public static Achievement achievementCrystalFragment;
	public static Achievement achievementRoughCrystal;
	
	public static final void init()
	{
		achievementCrystalFragment = new AchievementMod(LibAchievementNames.CRYSTALFRAGMENT, 0, 4, ModItems.itemCrystalFragment, null);
		achievementRoughCrystal = new AchievementMod(LibAchievementNames.ROUGHCRYSTAL, 1, 5, ModItems.itemRoughCrystal, null);
		
		pageIndex = AchievementPage.getAchievementPages().size();
		crystalmagicPage = new AchievementPage("Crystal Magic",new Achievement[] {ModAchievements.achievementCrystalFragment, ModAchievements.achievementRoughCrystal}); 
		AchievementPage.registerAchievementPage(crystalmagicPage);
		achievementCrystalFragment.registerStat();
		achievementRoughCrystal.registerStat();
		
		FMLCommonHandler.instance().bus().register(new AchievementTriggerer());
	}
}
