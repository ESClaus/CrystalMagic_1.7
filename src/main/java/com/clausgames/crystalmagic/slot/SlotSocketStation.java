package com.clausgames.crystalmagic.slot;

import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class SlotSocketStation extends Slot
{
    int slot;

    public SlotSocketStation(EntityPlayer player, IInventory iInventory, int i, int j, int k)
    {
        super(iInventory, i, j, k);
        slot = i;
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        boolean slot0Valid = (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemHoe); //Checks if item going to slot 0 is Tool or Armor (or Hoe)
        boolean slot123Valid = (itemStack.getItem() instanceof ItemSocket); //Checks if item going to slot 1, 2, or 3 is a Socket

        if (slot == 0 && slot0Valid)
        {
            return true;
        }else if(slot > 0 && slot < 4 && slot123Valid)
        {
            return true;
        }else
        {
            return false;
        }
    }
}
