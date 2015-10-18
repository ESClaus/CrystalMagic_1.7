package com.clausgames.crystalmagic.container;

import com.clausgames.crystalmagic.slot.SlotSocketStation;
import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class SocketStationContainer extends Container
{
    private TileEntitySocketStation socketer;

    public SocketStationContainer(InventoryPlayer invPlayer, TileEntitySocketStation teSocketStation)
    {

        socketer = teSocketStation;

        this.addSlotToContainer(new Slot(teSocketStation, 0, 20, 35)); //ItemTool/Armor Input Slot
        this.addSlotToContainer(new Slot(teSocketStation, 1, 78, 17)); //Socket SlotTop
        this.addSlotToContainer(new Slot(teSocketStation, 2, 78, 35)); //Socket SlotMid
        this.addSlotToContainer(new Slot(teSocketStation, 3, 78, 53)); //Socket SlotBottom
        this.addSlotToContainer(new SlotSocketStation(invPlayer.player, teSocketStation, 4, 136, 35)); //Result Slot

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

    public ItemStack transferStackInSlot(EntityPlayer player, int p_82846_2_) // Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }
}
