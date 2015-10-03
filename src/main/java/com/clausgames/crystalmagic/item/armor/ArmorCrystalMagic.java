package com.clausgames.crystalmagic.item.armor;

import net.minecraft.item.ItemArmor;
import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;

public class ArmorCrystalMagic extends ItemArmor
{
    public ArmorCrystalMagic(ArmorMaterial material, int type)
    {
        super(material, 0, type);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
        this.setMaxStackSize(1);
    }
}
