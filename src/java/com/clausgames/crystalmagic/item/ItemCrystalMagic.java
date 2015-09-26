package com.clausgames.crystalmagic.item;

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
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", LibMisc.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        //itemCrystalFragment = new Item().setUnlocalizedName("ItemCrystalFragment").setTextureName(LibMisc.MODID + ":itemCrystalFragment").setCreativeTab(CrystalMagic.tabCrystalMagic);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", LibMisc.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
