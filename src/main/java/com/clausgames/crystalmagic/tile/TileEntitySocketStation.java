package com.clausgames.crystalmagic.tile;

import com.clausgames.crystalmagic.crafting.SocketStationRecipes;
import com.clausgames.crystalmagic.items.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySocketStation extends TileEntity implements ISidedInventory
{
    private ItemStack slots[];

    //Hopper-like interaction for automation. Any side = Tool or Armor. Top = Sockets. Bottom = Craft Result.
    private static final int[] slots_side = new int[] {0}; //Input Slot where Tool/Armor go
    private static final int[] slots_top = new int[] {1, 2, 3}; //Input Slots where sockets go
    private static final int[] slots_bottom = new int[] {4}; //Result Slot

    private String customName;

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
        return slots[i];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (slots[i] != null)
        {
            ItemStack itemstack = slots[i];
            slots[i] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        slots[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
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
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }else
        {
            return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64;
        }
    }

    public void openInventory(){}
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) //Has to do with automation only //TODO figure this out to change what is valid for each slot with if statements
    {
        if (itemstack != null)
        {
            if (i == 0)
            {
                return itemstack.getItem() instanceof  ItemTool;
            } else if (i == 1)
            {
                return itemstack.getItem() instanceof ItemSocket;
            } else if (i == 2)
            {
                return itemstack.getItem() instanceof ItemSocket;
            } else if (i == 3)
            {
                return itemstack.getItem() instanceof ItemSocket;
            } else
            {
                return true;
            }
        }
        return false;
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if (slots[i] != null)
        {
            if (slots[i].stackSize <= j)
            {
                ItemStack itemstack = slots[i];
                slots[i] = null;
                return itemstack; //Gives item back to player when they remove from slot.
            }

            ItemStack itemstack1 = slots[i].splitStack(j);

            if(slots[i].stackSize == 0)
            {
                slots[i] = null;
            }

            return itemstack1; //Gives item back to player when they right click to remove half of it (splitStack).
        } else
        {
            return null;
        }
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", 10);
        slots = new ItemStack[getSizeInventory()];

        for (int i = 0; i < list.tagCount(); i++) //gets whatever is in NBT to GUI slots
        {
            NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
            byte b0 = nbt1.getByte("Slot");

            if (b0 >= 0 && b0 < slots.length)
            {
                slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < slots.length; i++) //sends whatever is in GUI slots to NBT and save's data
        {
            if (slots[i] != null)
            {
                NBTTagCompound nbt1 = new NBTTagCompound();
                nbt1.setByte("Slot", (byte)i);
                slots[i].writeToNBT(nbt1);
                list.appendTag(nbt1);
            }
        }

        nbt.setTag("Items", list);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i)
    {
        return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : "container.socketStation";
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int j)
    {
        return this.isItemValidForSlot(i, itemStack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j)
    {
        return j != 0 || i != 0 || i != 1 || i != 2 || i != 3;
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
