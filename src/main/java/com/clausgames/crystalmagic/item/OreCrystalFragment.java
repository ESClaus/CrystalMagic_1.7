package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

public class OreCrystalFragment extends ItemSeeds
{
    public OreCrystalFragment(Block blockPlant, Block blockSoil)
    {
        super(blockPlant, blockSoil);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
