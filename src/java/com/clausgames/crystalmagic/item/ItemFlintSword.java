package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.Main;

import net.minecraft.item.ItemSword;

public class ItemFlintSword extends ItemSword {

	public ItemFlintSword(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}
}