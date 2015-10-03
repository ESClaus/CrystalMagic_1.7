package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockCrystalMagic extends Block
{
    public BlockCrystalMagic(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    public BlockCrystalMagic()
    {
        this(Material.rock);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
