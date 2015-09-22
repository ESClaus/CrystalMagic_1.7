package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.Main;

import net.minecraft.item.ItemHoe;

public class ItemFlintHoe extends ItemHoe {

	public ItemFlintHoe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}
}