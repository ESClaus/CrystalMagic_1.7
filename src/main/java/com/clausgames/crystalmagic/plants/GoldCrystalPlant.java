package com.clausgames.crystalmagic.plants;

import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class GoldCrystalPlant extends ModCrystalPlant
{

    public GoldCrystalPlant()
    {
        // Basic block setup
        setBlockName("GoldCrystalPlant");
        setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_0");
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (1); //TODO Change drop quantity to random stuff
    }

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)
    {
        // DEBUG
        System.out.println("GoldCrystalPlant getItemDropped()"); //TODO Remove debug
        //return (ModItems.goldCrystalFragment); //TODO Drop Fragment and ore block
        return (Item.getItemFromBlock(Blocks.gold_ore));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
        iIcon = new IIcon[maxGrowthStage+1];
        // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
        // to make generic should loop to maxGrowthStage //TODO Change textures for each stage
        iIcon[0] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_0");
        iIcon[1] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_0");
        iIcon[2] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_1");
        iIcon[3] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_1");
        iIcon[4] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_2");
        iIcon[5] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_2");
        iIcon[6] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_3");
        iIcon[7] = parIIconRegister.registerIcon(LibMisc.MODID + ":" + this.getUnlocalizedName() + "_stage_3");
    }
}

