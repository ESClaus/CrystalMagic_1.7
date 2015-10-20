package com.clausgames.crystalmagic.container;

import com.clausgames.crystalmagic.crafting.slots.SlotSocketStationResult;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import com.clausgames.crystalmagic.crafting.slots.SlotSocketStation;
import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class SocketStationContainer extends Container
{
    public TileEntitySocketStation socketer;

    public SocketStationContainer(InventoryPlayer invPlayer, TileEntitySocketStation teSocketStation)
    {
        socketer = teSocketStation;

        this.addSlotToContainer(new SlotSocketStation(invPlayer.player, teSocketStation, 0, 20, 35)); //ItemTool/Armor Input Slot
        this.addSlotToContainer(new SlotSocketStation(invPlayer.player, teSocketStation, 1, 78, 17)); //Socket SlotTop
        this.addSlotToContainer(new SlotSocketStation(invPlayer.player, teSocketStation, 2, 78, 35)); //Socket SlotMid
        this.addSlotToContainer(new SlotSocketStation(invPlayer.player, teSocketStation, 3, 78, 53)); //Socket SlotBottom
        this.addSlotToContainer(new SlotSocketStationResult(invPlayer.player, teSocketStation, teSocketStation, 4, 136, 35)); //Result Slot
        //a//

        //Inventory of Player
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        //HotBar aka ActionBar
        for (int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return socketer.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int fromSlot) // Called when a player shift-clicks on a slots. You must override this or you will crash when someone does that.
    {
        ItemStack previous = null;
        Slot slot = (Slot)this.inventorySlots.get(fromSlot); //Slot shift-clicked on

        if (slot != null && slot.getHasStack()) //Slot isn't empty and has an ItemStack
        {
            ItemStack current = slot.getStack(); //gets current item in slots.
            previous = current.copy();
            boolean slot0Valid = (current.getItem() instanceof ItemTool || current.getItem() instanceof ItemArmor || current.getItem() instanceof ItemHoe); //Checks if item going to slots 0 is Tool or Armor (or Hoe)
            boolean slot123Valid = (current.getItem() instanceof ItemSocket); //Checks if item going to slots 1, 2, or 3 is a Socket

            // From TE Inventory to Player Inventory
            if (fromSlot < socketer.slots.length) {
                if (!this.mergeItemStack(current, socketer.slots.length, 41, true))
                    return null;
            // From Player Inventory to TE Inventory Input Slot 0
            } else if(fromSlot > 4 && slot0Valid) {
                if (!this.mergeItemStack(current, 0, 1, false))
                    return null;
            // From Player Inventory to TE Inventory Socket Slots 1/2/3
            } else if(fromSlot > 4 && slot123Valid)
            {
                if (!this.mergeItemStack(current, 1, 4, false))
                    return null;
            }

            if (current.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (current.stackSize == previous.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, current);
        }

        return previous;
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        for (int i = 0; i < 5; i++)
        {
            ItemStack itemstack = this.socketer.getStackInSlotOnClosing(i);

            if (itemstack != null)
            {
                player.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
}
