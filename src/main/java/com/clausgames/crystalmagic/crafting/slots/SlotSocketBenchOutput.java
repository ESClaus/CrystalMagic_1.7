package com.clausgames.crystalmagic.crafting.slots;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import com.clausgames.crystalmagic.crafting.Inventories.InventorySocketBenchResult;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlotSocketBenchOutput extends Slot
{
    int slot;
    World world = Minecraft.getMinecraft().theWorld;
    public SocketBenchContainer socketBench;
    public InventorySocketBenchResult inventory;

    public SlotSocketBenchOutput(InventorySocketBenchResult iInventory, SocketBenchContainer socketBenchContainer, int i, int j, int k)
    {
        super(iInventory, i, j, k);
        slot = i;
        inventory = iInventory;
        socketBench = socketBenchContainer;
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        if(!world.isRemote && inventory.getStackInSlot(0) != null)
        {
            socketBench.onCraftMatrixChanged(socketBench.outputInventory);
        }
    }

    @Override
    public void onSlotChanged()
    {
        //this.inventory.markDirty();
        if(!world.isRemote && inventory.getStackInSlot(0) != null)
        {
            socketBench.onCraftMatrixChanged(socketBench.outputInventory);
        }
    }
}