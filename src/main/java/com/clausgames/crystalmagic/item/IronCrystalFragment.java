package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IronCrystalFragment extends OreCrystalFragment
{
    private Block blockPlant;
    private Block blockSoil;

    public IronCrystalFragment(String unlocalizedName, String textureName)
    {
        super(ModBlocks.ironCrystalPlant, ModBlocks.ironInfusedStone); //blockPlant, blockSoil
        this.blockPlant = ModBlocks.ironCrystalPlant;
        this.blockSoil = ModBlocks.ironInfusedStone;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int worldX, int worldY, int worldZ, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(worldX, worldY, worldZ, p_77648_7_, itemStack) && player.canPlayerEdit(worldX, worldY + 1, worldZ, p_77648_7_, itemStack))
        {
            if (world.getBlock(worldX, worldY, worldZ) == this.blockSoil && world.isAirBlock(worldX, worldY + 1, worldZ))
            {
                world.setBlock(worldX, worldY + 1, worldZ, this.blockPlant);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}