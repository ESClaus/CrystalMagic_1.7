package com.clausgames.crystalmagic.achievement;

import com.clausgames.crystalmagic.item.ModItems;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ModAchievements
{
	public static Achievement achievementCrystalFragment = new Achievement("achievement.crystalfragment", "crystalfragment", 0, 0, ModItems.itemCrystalFragment, (Achievement)null);
	public static Achievement achievementRoughCrystal = new Achievement("achievement.roughcrystal", "roughcrystal", 2, 1, ModItems.itemRoughCrystal, (Achievement)null);
	
	public static final void init()
	{
		achievementCrystalFragment.registerStat();
		achievementRoughCrystal.registerStat();
		AchievementPage.registerAchievementPage(
				new AchievementPage("Crystal Magic",
						new Achievement[] {ModAchievements.achievementCrystalFragment, ModAchievements.achievementRoughCrystal}));
		
	}
}
