package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.Main;

import net.minecraft.item.ItemSpade;

public class ItemFlintShovel extends ItemSpade {

	public ItemFlintShovel(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}
}