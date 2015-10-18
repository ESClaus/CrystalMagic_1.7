package com.clausgames.crystalmagic.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotSocketStation extends Slot
{
    public SlotSocketStation(EntityPlayer player, IInventory iInventory, int i, int j, int k)
    {
        super(iInventory, i, j, k);
    }
}
