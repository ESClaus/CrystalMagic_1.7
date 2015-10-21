package com.clausgames.crystalmagic.crafting.slots;

import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class SlotSocketBenchInput extends Slot
{
    int slot;

    public SlotSocketBenchInput(IInventory iInventory, int i, int j, int k)
    {
        super(iInventory, i, j, k);
        slot = i;
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        boolean slot0Valid = (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemHoe); //Checks if item going to slots 0 is Tool or Armor (or Hoe)
        boolean slot123Valid = (itemStack.getItem() instanceof ItemSocket); //Checks if item going to slots 1, 2, or 3 is a Socket

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
