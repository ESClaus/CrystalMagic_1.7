package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class OreCrystalPlant extends BlockCrops
{
    public OreCrystalPlant()
    {
        this.setTickRandomly(true);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
        this.setCreativeTab(null); //this ensures it's not on creative, it shouldn't be.
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.iconArray = new IIcon[8];

        for (int i = 0; i < this.iconArray.length; i++)
        {
            this.iconArray[i] = iconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5) + "_stage_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if (metadata < 0 || metadata > 7)
        {
            metadata = 7;
        }
        return this.iconArray[metadata];
    }

    @Override
    protected Item func_149866_i()
    {
        return null; //This function is on each plant and sets the ACTUAL drop, it just has to be here to make it work on it's children.
    }

    @Override
    protected Item func_149865_P()
    {
        return null; //This function is on each plant and sets the ACTUAL drop, it just has to be here to make it work on it's children.
    }

    @Override
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_)
    {
        return false; //false meaning Bonemeal check never happens, so bonemeal can't be used in func_149852_a below
        //return parWorld.getBlockMetadata(parX, parY, parZ) != 7; //Checks to ensure its not fully grown. If true, bonemeal CAN be applied (runs func_149852_a)
    }

    @Override
    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return false; //If not fully grown (determined with func_149851_a above), apply bonemeal. False means bonemeal has no effect. Default is true.
        //return true;
    }
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand) //Ticks the block if it's been scheduled
    {
        super.updateTick(parWorld, parX, parY, parZ, parRand);

        int metadata = parWorld.getBlockMetadata(parX, parY, parZ);

        if (parWorld.rand.nextFloat() < 0.125f) //12.5% chance to update per 10 ticks //TODO may need to tweak percentage
        {
            metadata += 1;
        }

        if (metadata > 7)
        {
            metadata = 7;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, metadata, 2);
    }

    @Override
    public boolean isFertile (World world, int x, int y, int z) {
        return false;
    }

}