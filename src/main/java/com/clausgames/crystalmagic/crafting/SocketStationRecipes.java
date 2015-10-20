package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.items.sockets.ModSockets;
import com.clausgames.crystalmagic.items.tool.ModTools;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SocketStationRecipes
{
    public SocketStationRecipes()
    {

    }

    public static ItemStack getSocketingResult(Item itemSlot0, Item itemSlot1, Item itemSlot2, Item itemSlot3) //Checks item in each slots specified and checks for recipe
    {
        return getOutput(itemSlot0, itemSlot1, itemSlot2, itemSlot3);
    }

    public static ItemStack getOutput(Item itemSlot0, Item itemSlot1, Item itemSlot2, Item itemSlot3)
    {
        System.out.println(" Slot0 = " + itemSlot0 + " Slot1 = " + itemSlot1 + " Slot2 = " + itemSlot2 + " Slot3 = " + itemSlot3 + "DEBUGDEBUG");
        if (itemSlot0 == Items.iron_pickaxe && itemSlot1 == null && itemSlot2 == ModSockets.itemEmptySocket && itemSlot3 == null) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1);
        }

        if (itemSlot0 == Items.diamond_pickaxe && itemSlot1 == ModSockets.itemEmptySocket && itemSlot2 == ModSockets.itemEmptySocket && itemSlot3 == ModSockets.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1); //TODO change to Socketed Diamond Pick
        }

        /*//Testing theory that saying instanceOf any Tool will make item, it worked! //TODO Now to use it properly
        if (itemSlot0 instanceof ItemTool && itemSlot1 == ModSockets.itemEmptySocket && itemSlot2 == ModSockets.itemEmptySocket && itemSlot3 == ModSockets.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1);
        }*/

        return null; //No recipe found
    }
}
