package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockGoldenBars extends BlockPane
{
    public BlockGoldenBars()
    {
        super(LibMisc.MODID + ":" + "blockGoldenBars", LibMisc.MODID + ":" + "blockGoldenBars", Material.iron, true); //Sets the texture and sidetexture(if any)
        this.setBlockName("BlockGoldenBars");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal); // Sets sound of stepping on block. (Default: depends on material type chosen)
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
