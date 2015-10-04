package com.clausgames.crystalmagic.handler;

import com.clausgames.crystalmagic.item.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

public class CMEventHandler
{
    public static void init()
    {
        MinecraftForge.EVENT_BUS.register(new CMEventHandler());
    }

    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event)
    {
        if (event.block == Blocks.gold_ore)
        {
            ItemStack stack = new ItemStack(ModItems.itemGoldCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            String toolUsed = player.getCurrentEquippedItem().getItem().getUnlocalizedName().substring(5); // Checks what tool was that player used to break item.
            if (toolUsed.equals("ItemCrystalEdgedPickaxe"))
            {
                if (world.rand.nextFloat() < 0.03f) //3% Chance to drop a GoldCrystalFragment Seed if using the right pick!
                {
                    event.drops.add(stack);
                }
            }
        }
    }
}