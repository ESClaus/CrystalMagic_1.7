package com.clausgames.crystalmagic.crafting.slots;

import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlotSocketStationResult extends Slot
{
    int slot;
    World world = Minecraft.getMinecraft().theWorld;
    public TileEntitySocketStation socketer;

    public SlotSocketStationResult(EntityPlayer player, TileEntitySocketStation teSocketStation, IInventory iInventory, int i, int j, int k)
    {
        super(iInventory, i, j, k);
        slot = i;
        socketer = teSocketStation;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        if(!world.isRemote && socketer.canSocket())
        {
            socketer.socketItem();
            socketer.markDirty();
        }
    }
}