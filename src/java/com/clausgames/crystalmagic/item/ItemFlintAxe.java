package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.Main;

import net.minecraft.item.ItemAxe;

public class ItemFlintAxe extends ItemAxe {

	public ItemFlintAxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}
}