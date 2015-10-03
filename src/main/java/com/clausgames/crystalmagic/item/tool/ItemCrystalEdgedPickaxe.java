package com.clausgames.crystalmagic.item.tool;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

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
