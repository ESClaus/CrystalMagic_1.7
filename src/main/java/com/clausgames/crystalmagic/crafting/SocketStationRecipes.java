package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.tool.ModTools;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class SocketStationRecipes
{
    public SocketStationRecipes()
    {

    }

    public static ItemStack getSocketingResult(Item itemSlot0, Item itemSlot1, Item itemSlot2, Item itemSlot3) //Checks item in each slot specified and checks for recipe
    {
        return getOutput(itemSlot0, itemSlot1, itemSlot2, itemSlot3);
    }

    public static ItemStack getOutput(Item itemSlot0, Item itemSlot1, Item itemSlot2, Item itemSlot3)
    {
        if (itemSlot0 == Items.iron_pickaxe && itemSlot1 == ModItems.itemEmptySocket && itemSlot2 == ModItems.itemEmptySocket && itemSlot3 == ModItems.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1);
        }

        if (itemSlot0 == Items.diamond_pickaxe && itemSlot1 == ModItems.itemEmptySocket && itemSlot2 == ModItems.itemEmptySocket && itemSlot3 == ModItems.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1);
        }

        //Testing theory that saying instanceOf any Tool will make item, it worked! //TODO Now to use it properly
        if (itemSlot0 instanceof ItemTool && itemSlot1 == ModItems.itemEmptySocket && itemSlot2 == ModItems.itemEmptySocket && itemSlot3 == ModItems.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1);
        }

        return null; //No recipe found
    }
}
