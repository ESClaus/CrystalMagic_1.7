package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class GoldCrystalPlant extends OreCrystalPlant
{
    public GoldCrystalPlant()
    {
        this.setBlockName("GoldCrystalPlant");
    }

    @Override
    protected boolean canPlaceBlockOn(Block parSoil)
    {
        return parSoil == ModBlocks.goldInfusedStone;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1; //Currently, sets how many items drop of "seed" before fully grown, but when fully grown it sets how many of fully grown item drop.
    }

    @Override
    protected Item func_149866_i()
    {
        return ModItems.itemGoldCrystalFragment; //This drops the "seed", as in when not fully grown, quantity determined by quantityDropped above. By default, at fully grown drops 1-2 based on random.
    }

    @Override
    protected Item func_149865_P()
    {
        return Item.getItemFromBlock(Blocks.gold_ore); //This drops when fully grown, based on quantityDropped above.
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        if (metadata == 7)
        {
            return this.func_149865_P();
        } else
        {
            return this.func_149866_i();
        }
    }
}
