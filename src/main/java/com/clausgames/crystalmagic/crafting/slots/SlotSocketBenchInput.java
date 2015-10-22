package com.clausgames.crystalmagic.crafting.slots;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import com.clausgames.crystalmagic.crafting.Inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class SlotSocketBenchInput extends Slot
{
    int slotIndex;
    private EntityPlayer thePlayer;
    public SocketBenchContainer socketBench;
    public InventorySocketBenchInput inventory;
    private int amountCrafted;

    public SlotSocketBenchInput(EntityPlayer entityPlayer, InventorySocketBenchInput inventorySocketBenchInput, SocketBenchContainer socketBenchContainer, int i, int j, int k)
    {
        super(inventorySocketBenchInput, i, j, k);
        slotIndex = i;
        inventory = inventorySocketBenchInput;
        this.thePlayer = entityPlayer;
        socketBench = socketBenchContainer;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        boolean slot2Valid = (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemHoe); //Checks if item going to slots 0 is Tool or Armor (or Hoe)
        boolean slot135Valid = (itemStack.getItem() instanceof ItemSocket); //Checks if item going to slots 1, 3, or 5 is a Socket

        if (slotIndex == socketBench.inputSlotNumber1x1 && slot2Valid)
        {
            return true;
        }else if(slotIndex >= socketBench.inputSlotNumberSocketTop && slotIndex <= socketBench.inputSlotNumberSocketBottom && slot135Valid && slotIndex !=socketBench.inputSlotNumber1x1)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amountCrafted if there's a stack in slot. Returns the new
     * stack.
     */
    @Override
    public ItemStack decrStackSize(int amount)
    {
        return this.inventory.decrStackSize(this.slotIndex, amount);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    @Override
    protected void onCrafting(ItemStack outputItem, int count)
    {
        this.amountCrafted += count;
        this.onCrafting(outputItem);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
    protected void onCrafting(ItemStack outputItem)
    {
        outputItem.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
        this.amountCrafted = 0;

        /*if (outputItem.getItem() == Item.getItemFromBlock(Blocks.crafting_table)) //TODO add achievements for anything we want that is crafted in SocketBench
        {
            this.thePlayer.addStat(AchievementList.buildWorkBench, 1);
        }*/
    }

    @Override
    public void onPickupFromSlot(EntityPlayer p_82870_1_, ItemStack p_82870_2_)
    {
        FMLCommonHandler.instance().firePlayerCraftingEvent(p_82870_1_, p_82870_2_, inventory);
        this.onCrafting(p_82870_2_);

        for (int i = 0; i < this.inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = this.inventory.getStackInSlot(i);

            if (itemstack1 != null)
            {
                this.inventory.decrStackSize(i, 1);

                if (itemstack1.getItem().hasContainerItem(itemstack1))
                {
                    ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

                    if (itemstack2 != null && itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
                        continue;
                    }

                    if (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))
                    {
                        if (this.inventory.getStackInSlot(i) == null)
                        {
                            this.inventory.setInventorySlotContents(i, itemstack2);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
                        }
                    }
                }
            }
        }
    }
    /**
     * if par2 has more items than par1, onCrafting(item,countIncrease) is called
     */
    @Override
    public void onSlotChange(ItemStack itemStack, ItemStack itemStack2)
    {
        if (itemStack != null && itemStack2 != null)
        {
            if (itemStack.getItem() == itemStack2.getItem())
            {
                int i = itemStack2.stackSize - itemStack.stackSize;

                if (i > 0)
                {
                    this.onCrafting(itemStack, i);
                }
            }
        }
    }
    /**
     * Helper func to get the stack in the slot.
     */
    @Override
    public ItemStack getStack()
    {
        return this.inventory.getStackInSlot(this.slotIndex);
    }
    /**
     * Returns if this slot contains a stack.
     */
    @Override
    public boolean getHasStack()
    {
        return this.getStack() != null;
    }
    /**
     * Helper method to put a stack in the slot.
     */
    @Override
    public void putStack(ItemStack itemStack)
    {
        this.inventory.setInventorySlotContents(this.slotIndex, itemStack);
        this.onSlotChanged();
    }
    /**
     * Called when the stack in a Slot changes
     */
    @Override
    public void onSlotChanged()
    {
        this.inventory.markDirty();
    }
    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    @Override
    public int getSlotStackLimit()
    {
        return this.inventory.getInventoryStackLimit();
    }
    /**
     * returns true if this slot is in par2 of par1
     */
    public boolean isSlotInInventory(InventorySocketBenchInput inventorySocketBenchInput, int slot)
    {
        return inventorySocketBenchInput == this.inventory && slot == this.slotIndex;
    }
    /**
     * Return whether this slot's stack can be taken from this slot.
     */
    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        return true;
    }

}
