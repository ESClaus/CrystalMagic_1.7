package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.items.sockets.ModSockets;
import com.clausgames.crystalmagic.items.tool.ModTools;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SocketBenchRecipeManager
{
    // The items inputted to the Socket Bench

    private static final SocketBenchRecipeManager instance = new SocketBenchRecipeManager();
    public Item item1x1;
    public Item itemTop;
    public Item itemMid;
    public Item itemBottom;
    public World world;

    public static final SocketBenchRecipeManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    public SocketBenchRecipeManager() {}

    public ItemStack getSocketResults(ItemStack inputInventory1x1, ItemStack inputInventoryTop, ItemStack inputInventoryMid, ItemStack inputInventoryBottom, World worldObj)
    {
        // Allow recipes for some vanilla items that normally don't have recipes
        item1x1 = inputInventory1x1 == null ? null : inputInventory1x1.getItem();
        itemTop = inputInventoryTop == null ? null : inputInventoryTop.getItem();
        itemMid = inputInventoryMid == null ? null : inputInventoryMid.getItem();
        itemBottom = inputInventoryBottom == null ? null : inputInventoryBottom.getItem();
        world = worldObj;

        // DEBUG
        System.out.println("Looking for deconstructing a recipe for " + (item1x1 == null ? "empty1x1" : item1x1.getUnlocalizedName()) + " with Top Input of " + (itemTop == null ? "emptyTop" : itemTop.getUnlocalizedName()) + ", with Mid Input of " + (itemMid == null ? "emptyMid" : itemMid.getUnlocalizedName()) + ", with Bottom Input of " + (itemBottom == null ? "emptyBottom" : itemBottom.getUnlocalizedName()));

        return getOutput(item1x1, itemTop, itemMid, itemBottom);

    }

    public static ItemStack getOutput(Item item1x1, Item itemTop, Item itemMid, Item itemBottom)
    {
        // Checks for recipe using Items
        if (item1x1 == Items.iron_pickaxe && itemTop == null && itemMid == ModSockets.itemEmptySocket && itemBottom == null) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return (new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1)); //TODO change to socketed Iron Pick
        }

        if (item1x1 == Items.diamond_pickaxe && itemTop == ModSockets.itemEmptySocket && itemMid == ModSockets.itemEmptySocket && itemBottom == ModSockets.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return (new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1)); //TODO change to Socketed Diamond Pick
        }
        //TODO find easy way to make this shapeless.
        if (item1x1 == ModTools.itemCrystalEdgedPickaxe && itemTop == ModSockets.itemFierySocket && itemMid == ModSockets.itemLuckySocket && itemBottom == ModSockets.itemSpeedySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return (new ItemStack(Items.nether_star, 1)); //TODO change to Pick with NBT data.
        }

        /*//Testing theory that saying instanceOf any Tool will make item, it worked! //TODO Now to use it properly
        if (item1x1 instanceof ItemTool && itemTop == ModSockets.itemEmptySocket && itemMid == ModSockets.itemEmptySocket && itemBottom == ModSockets.itemEmptySocket) //When sockets are in place, add OR to allow sockets to be interchangeable in GUI slots.
        {
            return (new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1));
        }*/

        return null; //No recipe found
    }
}