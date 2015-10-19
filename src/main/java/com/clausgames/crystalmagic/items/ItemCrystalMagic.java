package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import net.minecraft.item.Item;

public class ItemCrystalMagic extends Item
{
    public ItemCrystalMagic()
    {
        super();
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}

    /*@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add(EnumChatFormatting.LIGHT_PURPLE + "Debug tool to test OreCrystalPlants");
        list.add("Right click to increase grow, shift + right click to decrease growth.");
    }*/