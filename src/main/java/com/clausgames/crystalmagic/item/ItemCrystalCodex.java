package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.gui.CrystalCodexGui;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCrystalCodex extends ItemCrystalMagic
{
    public ItemCrystalCodex(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick (ItemStack item, World world, EntityPlayer player)
    {
        if(world.isRemote)
        {
            // DEBUG
            System.out.println("ItemCrystalCodex onItemRightClick");

            player.openGui(CrystalMagic.instance, CrystalMagic.GUI_ENUM.CRYSTALCODEX.ordinal(), world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return super.onItemRightClick(item, world, player);
    }
}