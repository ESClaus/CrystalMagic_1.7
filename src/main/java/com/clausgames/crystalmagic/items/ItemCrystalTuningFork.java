package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.blocks.BlockCrystalOre;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCrystalTuningFork extends ItemCrystalMagic
{
    public ItemCrystalTuningFork(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int worldX, int worldY, int worldZ, int blockSide, float hitX, float hitY, float hitZ)
    {
        /*Block block = world.getBlock(worldX, worldY, worldZ); /?TODO Work out code that would return the ItemCrystal, ItemFireCrystal, ItemNatureCrystal, etc.
        Boolean isCrystal = block instanceof BlockCrystalOre;
        Boolean isCreative = player.capabilities.isCreativeMode;*/

        return false;
    }
}
