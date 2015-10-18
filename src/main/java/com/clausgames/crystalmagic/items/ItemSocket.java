package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemSocket extends Item
{
    public ItemSocket()
    {
        super();
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    /*@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add(EnumChatFormatting.LIGHT_PURPLE + "I'm Empty");
    }*/
}