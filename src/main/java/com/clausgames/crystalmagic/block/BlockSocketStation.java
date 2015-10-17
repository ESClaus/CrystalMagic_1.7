package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSocketStation extends BlockCrystalMagic
{
    @SideOnly(Side.CLIENT)
    private IIcon socketStationTop; //Sets top texture, side is already built in with blockIcon

    @SideOnly(Side.CLIENT)
    private IIcon socketStationBottom; //Sets bottom texture, side is already built in with blockIcon

    public BlockSocketStation(Material material)
    {
        super(Material.wood);
        this.setBlockName("BlockSocketStation");
        this.setHardness(3.5f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 0)
        {
            return this.socketStationBottom;
        }else if(side == 1)
        {
            return this.socketStationTop;
        }else
        {
            return this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(LibMisc.MODID + ":socketStationSide");
        this.socketStationBottom = iconRegister.registerIcon(LibMisc.MODID + ":socketStationBottom");
        this.socketStationTop = iconRegister.registerIcon(LibMisc.MODID + ":socketStationTop");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int blockSide, float hitX, float hitY, float hitZ)
    {
        if(!player.isSneaking())
        {
            player.openGui(CrystalMagic.instance, CrystalMagic.GUI_ENUM.SOCKET_STATION.ordinal(), world, x, y, z);
            return true;
        }else
        {
            return false;
        }
    }
}