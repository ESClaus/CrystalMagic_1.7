package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class EmeraldCrystalPlant extends OreCrystalPlant
{
    public EmeraldCrystalPlant()
    {
        this.setBlockName("EmeraldCrystalPlant");
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, int x, int y, int z) {
        return worldIn.getBlock(x, y, z).isReplaceable(worldIn, x, y, z) && worldIn.getBlock(x, y + 1, z) == ModBlocks.emeraldInfusedStone; //The Soil Block
    }

    @Override
    public boolean canBlockStay(World worldIn, int x, int y, int z) {
        return worldIn.isAirBlock(x, y - 1, z) && worldIn.getBlock(x, y + 1, z) == ModBlocks.emeraldInfusedStone; //The Soil Block
    }

    @Override
    protected Item func_149866_i()
    {
        return ModItems.itemEmeraldCrystalFragment; //This drops the "seed", as in when not fully grown, quantity determined by quantityDropped above. By default, at fully grown drops 1-2 based on random.
    }

    @Override
    protected Item func_149865_P()
    {
        return Item.getItemFromBlock(Blocks.emerald_ore); //This drops when fully grown, based on quantityDropped above.
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        if(metadata >= 7)
        {
            drops.add(new ItemStack(this.func_149865_P(), 1)); //Guaranteed Ore Drop if full growth
            if(world.rand.nextFloat() < 0.03f)
            {
                drops.add(new ItemStack(this.func_149866_i(), 1)); //3% chance for additional Seed Drop
            }
        }
        drops.add(new ItemStack(this.func_149866_i(), 1)); //Guaranteed 1 Seed Drop whether fully grown or not
        return drops;
    }
}
