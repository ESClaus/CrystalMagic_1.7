package com.clausgames.crystalmagic.crafting.Inventories;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventorySocketBenchResult implements IInventory
{
    private final ItemStack[] stackResult = new ItemStack[1];
    public String customName;

    /*
    SLOTS

    Slot {0}; //Input Slot where Tool/Armor go
    Slot {1, 2, 3}; //Input Slots where sockets go
    Slot {4}; //Result Slot - InventorySocketBenchResult

    END SLOTS
    */

    @Override
    public int getSizeInventory() // Returns the number of slots in the inventory.
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int par1) // Returns the stack in slot i
    {
        return stackResult[0];
    }

    public ItemStack decrStackSize(int index, int count)
    {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).stackSize <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }
                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) //Spits items in slot out like when you close crafting table.
    {
        if (this.stackResult[0] != null)
        {
            ItemStack itemstack = this.stackResult[0];
            this.stackResult[0] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) // Sets the given item stack to the specified slot in the inventory
    {
        stackResult[0] = par2ItemStack;
    }

    @Override
    public int getInventoryStackLimit() //Returns the maximum stack size for a inventory slot.
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }

    public boolean isEmpty() //Checks if result slots is empty
    {
        if(stackResult[0] != null)
        {
            return false;
        } else
        {
            return true;
        }
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public String getInventoryName()
    {
        return "Result";
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}
}
