package com.clausgames.crystalmagic.plants;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class ModCrystalPlant extends BlockBush implements IGrowable
{
    protected int maxGrowthStage = 7;


    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;

    public ModCrystalPlant()
    {
        // Basic block setup
        setTickRandomly(true);
        float f = 0.5F; //Unsure what this does with next line yet
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f); //unsure what this does with above line yet
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        disableStats();
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", LibMisc.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * is the block OreInfusedStone type needed?
     */
    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == ModBlocks.goldInfusedStone; //TODO Change to our OreInfusedStone ModBlocks.____InfusedStone somehow with a parameter
    }

    public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ)
    {
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) +
                MathHelper.getRandomIntegerInRange(parRand, 2, 5);

        if (growStage > maxGrowthStage)
        {
            growStage = maxGrowthStage;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune)
    {
        return Item.getItemFromBlock(this);
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() //TODO may need to change render type
    {
        return 6; // 4x4 like Wheat
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int parSide, int parGrowthStage)
    {
        return iIcon[parGrowthStage];
    }

    /*
     * Need to implement the IGrowable interface methods
     */

    /*
     * (non-Javadoc)
     * @see net.minecraft.block.IGrowable#func_149851_a(net.minecraft.world.World,
     * int, int, int, boolean)
     */
    @Override
    // checks if finished growing (a grow stage of 7 is final stage)
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ,
                                 boolean p_149851_5_)
    {
        //return false;
        return parWorld.getBlockMetadata(parX, parY, parZ) != 7; //TODO this is supposed to disable bonemeal, enable if crashes and test
    }

    /*
     * (non-Javadoc)
     * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World,
     * java.util.Random, int, int, int)
     */
    @Override
    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_,
                                 int p_149852_4_, int p_149852_5_)
    {
        return false;
        //return true; //TODO this is a bonemeal thing too, may need to enable if crashes
    }

    /*
     * (non-Javadoc)
     * @see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World,
     * java.util.Random, int, int, int)
     */
    @Override
    public void func_149853_b(World parWorld, Random parRand, int parX, int parY,
                              int parZ)
    {
        incrementGrowStage(parWorld, parRand, parX, parY, parZ);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
    {
        super.updateTick(parWorld, parX, parY, parZ, parRand);
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;

        if (growStage > 7)
        {
            growStage = 7;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
}