package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.achievement.IPickupAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.lib.LibMisc;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemCrystalEdgedPickaxe extends ItemPickaxe
{

	public ItemCrystalEdgedPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(LibMisc.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CrystalMagic.tabCrystalMagic);
	}
}
