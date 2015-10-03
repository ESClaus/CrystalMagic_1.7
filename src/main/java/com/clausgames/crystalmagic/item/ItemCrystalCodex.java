package com.clausgames.crystalmagic.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
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
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
        if(!world.isRemote){
            player.addChatMessage(new ChatComponentText(" One day, this will open a nice book GUI for you in game. For now I live in the console logs"));
        }
        return stack;
    }
}
