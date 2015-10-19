package com.clausgames.crystalmagic.tile;

import com.clausgames.crystalmagic.crafting.SocketStationRecipes;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySocketStation extends TileEntity implements IInventory
{
    public ItemStack slots[];

    /*
    SLOTS

    Slot {0}; //Input Slot where Tool/Armor go
    Slot {1, 2, 3}; //Input Slots where sockets go
    Slot {4}; //Result Slot

    END SLOTS
    */

    public String customName;

    public TileEntitySocketStation()
    {
        slots = new ItemStack[5]; //How many custom slots we have
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        if (i < 0 || i >= this.getSizeInventory())
            return null;
        return this.slots[i];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        ItemStack stack = this.getStackInSlot(i);
        this.setInventorySlotContents(i, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        if (i < 0 || i >= this.getSizeInventory())
            return;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();

        if (stack != null && stack.stackSize == 0)
            stack = null;

        this.slots[i] = stack;
        this.markDirty();
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) //Is player within range of block to open GUI and interact with it
    {
        if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }else
        {
            return player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64;
        }
    }

    public void openInventory(){}
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) //Has to do with automation only
    {
        if (itemStack != null)
        {
            boolean slot0Valid = (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemHoe); //Checks if item going to slot 0 is Tool or Armor (or Hoe)
            boolean slot123Valid = (itemStack.getItem() instanceof ItemSocket); //Checks if item going to slot 1, 2, or 3 is a Socket

            if (i == 0 && slot0Valid)
            {
                return true;
            } else if (i == 1 && slot123Valid)
            {
                return true;
            } else if (i == 2 && slot123Valid)
            {
                return true;
            } else if (i == 3 && slot123Valid)
            {
                return true;
            } else
            {
                return false;
            }
        }
        return false;
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
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null) {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }
        nbt.setTag("Items", list);

        if (this.hasCustomInventoryName()) {
            nbt.setString("CustomName", this.getInventoryName());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomInventoryName(nbt.getString("CustomName"));
        }
    }

    public void setCustomInventoryName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : "container.socketStation";
    }

    private boolean canSocket() //Checks for recipe and get's result
    {
        if (slots[0] == null)
        {
            return false;
        }

        if (slots[1] == null || slots[2] == null || slots[3] == null)
        {
            return false;
        }else
        {
            ItemStack itemStack = SocketStationRecipes.getSocketingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem()); //Gets the result based on Input slots 0 (Tool/Armor) and 1, 2, 3 (sockets)

            if (itemStack == null) //If no crafting recipe was found, CANNOT craft.
            {
                return false;
            }

            if (slots[4] == null) //If output slot is empty
            {
                return true;
            }

            if (!slots[4].isItemEqual(itemStack)) //If output slot has an item that is NOT the current crafting recipe inputted.
            {
                return false;
            }

            if (slots[4].stackSize < getInventoryStackLimit() && slots[4].stackSize < slots[4].getMaxStackSize()) //As long as the output slot has less than 64 items and is less than max stack size of that item's stack limit
            {
                return true;
            }else
            {
                return slots[4].stackSize < itemStack.getMaxStackSize(); //Puts crafted result into output as long as the item's max stack size hasn't been hit, if it has, will wait to put item in slot.
            }
        }
    }

    private void socketItem()
    {
        if (canSocket())
        {
            ItemStack itemStack = SocketStationRecipes.getSocketingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem()); //Grabs the result of said items in said slots and puts into an itemstack

            if (slots[4] == null) //If result is empty, copy whatever the item is and put into result slot.
            {
                slots[4] = itemStack.copy(); //Puts result into result slot.
            } else if(slots[4].isItemEqual(itemStack)) //If it has an item in result slot already, increment the stack size until you hit max stack size of item.
            {
                slots[4].stackSize += itemStack.stackSize;
            }

            for (int i = 0; i < 4; i++)
            {
                if (slots[i].stackSize <= 0)
                {
                    slots[i] = new ItemStack(slots[i].getItem().setFull3D());
                } else
                {
                    slots[i].stackSize --;
                }

                if (slots[i].stackSize <= 0)
                {
                    slots[i] = null;
                }
            }
        }
    }

    public void updateEntity()
    {
        if(!worldObj.isRemote && canSocket())
        {
            this.socketItem();
            this.markDirty();
        }
    }
}
