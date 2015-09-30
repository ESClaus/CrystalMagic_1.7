package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockGoldenBars extends BlockPane
{
    public BlockGoldenBars()
    {
        super("cg_crystalmagic:blockGoldenBars", "cg_crystalmagic:blockGoldenBars", Material.iron, true); //Sets the texture and sidetexture(if any) TODO Would like to not have it hard coded in case we change MODID
        this.setBlockName("BlockGoldenBars");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName());
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal); // Sets sound of stepping on block. (Default: depends on material type chosen)
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
