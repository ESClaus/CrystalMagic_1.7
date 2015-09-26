package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;

import net.minecraft.item.ItemPickaxe;

public class ItemCrystalEdgedPickaxe extends ItemPickaxe
{

	public ItemCrystalEdgedPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(LibMisc.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
		this.setMaxStackSize(1);
	}
}
