package com.clausgames.crystalmagic.container;

import com.clausgames.crystalmagic.crafting.Inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.crafting.Inventories.InventorySocketBenchResult;
import com.clausgames.crystalmagic.crafting.SocketBenchRecipeManager;
import com.clausgames.crystalmagic.crafting.slots.SlotSocketBenchInput;
import com.clausgames.crystalmagic.crafting.slots.SlotSocketBenchOutput;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class SocketBenchContainer extends Container
{
    /*
    Slot {0}; //Input Slot where Tool/Weapon/Armor goes
    Slot {1, 2, 3}; //Input Slots where sockets go
    Slot {4}; //Output Slot
    */
    public InventorySocketBenchInput inputInventory1x1 = new InventorySocketBenchInput(); //Creates 1x1 inventory for input of armor/tool/weapon
    public InventorySocketBenchInput inputInventory1x3 = new InventorySocketBenchInput(); //Creates 1x3 inventory for input of sockets
    public int inputSlotNumber1x1 = 0;
    public int inputSlotNumberSocketTop = 1;
    public int inputSlotNumberSocketMid = 2;
    public int inputSlotNumberSocketBottom = 3;
    public int outputSlotNumber = 4;
    public InventorySocketBenchResult outputInventory = new InventorySocketBenchResult(); //Creates 1x1 inventory for output
    public SocketBenchRecipeManager socketBenchRecipeManager;
    private final World worldObj;
    public InventoryPlayer playerInventory;
    public int x = 0;
    public int y = 0;
    public int z = 0;

    public SocketBenchContainer(InventoryPlayer parPlayerInventory, World parWorld, int parX, int parY, int parZ)
    {
        x = parX;
        y = parY;
        z = parZ;
        worldObj = parWorld;

        socketBenchRecipeManager = new SocketBenchRecipeManager();

        //Start Drawing Custom Slots

        this.addSlotToContainer(new SlotSocketBenchInput(inputInventory1x1, inputSlotNumber1x1, 20, 35)); //Draws our slot for 1x1 Tool/Armor/Weapon Slot

        for (int inputSlotIndexX = 0; inputSlotIndexX < 1; ++inputSlotIndexX) //Draws our slots for 1x3 Socket Slots
        {
            for (int inputSlotIndexY = 0; inputSlotIndexY < 3; ++inputSlotIndexY)
            {
                addSlotToContainer(new SlotSocketBenchInput(inputInventory1x3, inputSlotIndexY + inputSlotIndexX + 1, 78, 18 * (inputSlotIndexY + 1) - 1));
            }
        }

        this.addSlotToContainer(new SlotSocketBenchOutput(outputInventory, this, this.outputSlotNumber, 136, 35)); //Draws our output slot

        //End Drawing Custom Slots

        //Start Drawing Player Slots

        playerInventory = parPlayerInventory;

        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) //Creates player inventory
        {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX)
            {
                addSlotToContainer(new Slot(parPlayerInventory, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }

        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) //Created player hotbar
        {
            addSlotToContainer(new Slot(parPlayerInventory, hotbarSlotIndex,
                    8 + hotbarSlotIndex * 18, 142));
        }

        //End Drawing Player Slots
    }

    @Override
    public void onCraftMatrixChanged(IInventory parInventory)
    {
        //Gets ItemStack for output based on what's in each slot
        ItemStack outputItemStackResult = SocketBenchRecipeManager.getInstance().getSocketResults(inputInventory1x1.getStackInSlot(inputSlotNumber1x1), inputInventory1x3.getStackInSlot(inputSlotNumberSocketTop), inputInventory1x3.getStackInSlot(inputSlotNumberSocketMid), inputInventory1x3.getStackInSlot(inputSlotNumberSocketBottom));

        if (outputItemStackResult == null)
        {
            return;
        }
        if (!outputInventory.isEmpty())
        {
            ItemStack itemStackInOutputSlot = outputInventory.getStackInSlot(outputSlotNumber);
            if (itemStackInOutputSlot != null && outputItemStackResult != null)
            {
                if (!itemStackInOutputSlot.isItemEqual(outputItemStackResult))
                {
                    if (!playerInventory.addItemStackToInventory(itemStackInOutputSlot))
                    {
                        EntityItem entityItem = playerInventory.player.entityDropItem(itemStackInOutputSlot, 0.5f);
                        entityItem.posX = playerInventory.player.posX;
                        entityItem.posY = playerInventory.player.posY;
                        entityItem.posZ = playerInventory.player.posZ;
                    }
                    outputInventory.setInventorySlotContents(outputSlotNumber, null);
                }
            }
        }

        ItemStack currentStack = outputInventory.getStackInSlot(outputSlotNumber);
        if (outputItemStackResult != null)
        {
            int metadata = outputItemStackResult.getItemDamage();
            if (metadata == 32767)
            {
                metadata = 0;
            }
            ItemStack newStack = null;
            if (currentStack != null && 1 + currentStack.stackSize <= outputItemStackResult.getMaxStackSize())
            {
                newStack = new ItemStack(outputItemStackResult.getItem(), 1 + currentStack.stackSize, metadata);
            } else
            {
                if (currentStack != null && !playerInventory.addItemStackToInventory(currentStack))
                {
                    EntityItem entityItem = playerInventory.player.entityDropItem(currentStack, 0.5f);
                    entityItem.posX = playerInventory.player.posX;
                    entityItem.posY = playerInventory.player.posY;
                    entityItem.posZ = playerInventory.player.posZ;
                }
                newStack = new ItemStack(outputItemStackResult.getItem(), 1, metadata);
            }
            outputInventory.setInventorySlotContents(outputSlotNumber, newStack);
        }
        inputInventory1x1.decrStackSize(inputSlotNumber1x1, 1);
        inputInventory1x3.decrStackSize(inputSlotNumberSocketTop, 1);
        inputInventory1x3.decrStackSize(inputSlotNumberSocketMid, 1);
        inputInventory1x3.decrStackSize(inputSlotNumberSocketBottom, 1);
    }

    @Override
    public ItemStack slotClick(int parSlotId, int parMouseButtonId, int parClickMode, EntityPlayer parPlayer) //This handles click/drag function within slots I believe.
    {
        ItemStack clickItemStack = super.slotClick(parSlotId, parMouseButtonId, parClickMode, parPlayer);
        if(inventorySlots.size() > parSlotId && parSlotId >= 0)
        {
            if(inventorySlots.get(parSlotId) != null)
            {
                if(((Slot) inventorySlots.get(parSlotId)).inventory == inputInventory1x1)
                {
                    onCraftMatrixChanged(inputInventory1x1);
                }

                if(((Slot) inventorySlots.get(parSlotId)).inventory == inputInventory1x3)
                {
                    onCraftMatrixChanged(inputInventory1x3);
                }

                if(((Slot) inventorySlots.get(parSlotId)).inventory == outputInventory)
                {
                    onCraftMatrixChanged(outputInventory);
                }
            }

        }
        return clickItemStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer parPlayer) //Callback for when the crafting gui is closed.
    {
        if(playerInventory.getItemStack() != null)
        {
            parPlayer.entityDropItem(playerInventory.getItemStack(), 0.5f);
        }
        if(!worldObj.isRemote)
        {
            ItemStack itemStack = inputInventory1x1.getStackInSlotOnClosing(inputSlotNumber1x1);

            if(itemStack != null) //Drops inputInventory1x1 on Close
            {
                parPlayer.entityDropItem(itemStack, 0.5f);
            }

            for(int i = 1; i < inputInventory1x3.getSizeInventory(); i++ ) //Drops inputInventory1x3 on Close
            {
                itemStack = inputInventory1x3.getStackInSlotOnClosing(i);

                if(itemStack != null)
                {
                    parPlayer.entityDropItem(itemStack, 0.5f);
                }
            }

            for(int i = 0; i < outputInventory.getSizeInventory(); i++ ) //Drops ouputInventory on Close
            {
                itemStack = outputInventory.getStackInSlotOnClosing(i);

                if(itemStack != null)
                {
                    parPlayer.entityDropItem(itemStack, 0.5f);
                }
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    @Override
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

            // From Container Inventory to Player Inventory
            if (fromSlot <= outputSlotNumber) {
                if (!this.mergeItemStack(current, outputSlotNumber, 41, true))
                    return null;
                // From Player Inventory to Container Inventory Input Slot 0
            } else if(fromSlot > outputSlotNumber && slot0Valid) {
                if (!this.mergeItemStack(current, inputSlotNumber1x1, inputSlotNumberSocketTop, false))
                    return null;
                // From Player Inventory to Container Inventory Socket Slots 1/2/3
            } else if(fromSlot > outputSlotNumber && slot123Valid)
            {
                if (!this.mergeItemStack(current, inputSlotNumberSocketTop, outputSlotNumber, false))
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

    @Override
    public Slot getSlot(int parSlotIndex)
    {
        if(parSlotIndex >= inventorySlots.size())
            parSlotIndex = inventorySlots.size() - 1;
        return super.getSlot(parSlotIndex);
    }
}