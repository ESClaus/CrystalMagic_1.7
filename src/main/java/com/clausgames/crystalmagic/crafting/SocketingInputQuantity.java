package com.clausgames.crystalmagic.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class SocketingInputQuantity
{
    public static int getStackSizeNeeded(int slotNumber, ItemStack parItemStack)
    {
        ItemStack theItem = parItemStack;
        int slot = slotNumber;
        int inputSlotNumber1x1 = 0;
        int inputSlotNumberSocketTop = 1;
        int inputSlotNumberSocketMid = 2;
        int inputSlotNumberSocketBottom = 3;

        if(theItem == null)
        {
            return 0;
        }

        if (slot == inputSlotNumber1x1)
        {
            return 1;
        } else if (slot == inputSlotNumberSocketTop || slot == inputSlotNumberSocketBottom)
        {
            if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") > 2)
            {
                return 1;
            } else if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") == 2)
            {
                return 0;
            } else if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") < 2)
            {
                return 0;
            }
        } else if (slot == inputSlotNumberSocketMid)
        {
            if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") > 2)
            {
                return 1;
            } else if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") == 2)
            {
                return 1;
            } else if (theItem.getItem().getHarvestLevel(theItem, "pickaxe") < 2)
            {
                return 0;
            }
        }
        return 0;
    }
}
