package com.clausgames.crystalmagic.container;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.crafting.SocketStationCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SocketStationContainer extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public SocketStationContainer(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        this.craftMatrix = new InventoryCrafting(this, 1, 1); //specifies how many slots input will be, 1x1
        this.craftResult = new InventoryCraftResult();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;

        this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 131, 36)); //Result Slot

        for (int i = 0; i < 1; i++) //loops to create inventory slots on Gui.
        {
            for (int k = 0; k < 1; k++)
            {
                this.addSlotToContainer(new Slot(craftMatrix, k + i, 4 + k * 18, 3 + i * 18));
            }
        }

        for (int i = 0; i < 3; i++) //loops to create inventory slots of player
        {
            for (int k = 0; k < 9; k++)
            {
                this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) // loops to create inventory slots of player hotbar
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory iInventory)
    {
        craftResult.setInventorySlotContents(0, SocketStationCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        if(worldObj.getBlock(posX, posY, posZ) != ModBlocks.blockSocketStation)
        {
            return false;
        } else
        {
            return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
        }
    }

    public void onContainerClosed(EntityPlayer entityPlayer) //Called when the container is closed and spits items onto ground if we close with items in input.
    {
        super.onContainerClosed(entityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 1; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    entityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot)
    {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 3) {
                // From Block Inventory to Player Inventory
                if (!this.mergeItemStack(current, 9, 37, true))
                    return null;
            } else {
                // From Player Inventory to Block Inventory
                if (!this.mergeItemStack(current, 1, 3, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }
}