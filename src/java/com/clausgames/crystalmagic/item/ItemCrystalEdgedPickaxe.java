package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;

import net.minecraft.item.ItemPickaxe;

public class ItemCrystalEdgedPickaxe extends ItemPickaxe
{

	public ItemCrystalEdgedPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(CrystalMagic.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CrystalMagic.tabCrystalMagic);
	}
}
