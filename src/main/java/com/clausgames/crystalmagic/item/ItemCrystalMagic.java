package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCrystalMagic extends Item
{
    public ItemCrystalMagic()
    {
        super();
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
