package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

//This Class controls the properties of Apprentice Armor

public class ItemApprenticeArmor extends ItemArmor
{
	public String textureName;

	public ItemApprenticeArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type)
	{
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(CrystalMagic.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CrystalMagic.tabCrystalMagic);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return CrystalMagic.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
		// Texture naming will be textureName_1.png for helmet/chestplate/boots, textureName_2.png for leggings.
	}
}