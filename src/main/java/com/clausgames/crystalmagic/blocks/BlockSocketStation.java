package com.clausgames.crystalmagic.blocks;

import codechicken.lib.math.MathHelper;
import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSocketStation extends BlockContainer
{
    private Random rand;

    @SideOnly(Side.CLIENT)
    private IIcon socketStationTop131; //Sets top texture, side is already built in with blockIcon

    @SideOnly(Side.CLIENT)
    private IIcon socketStationBottom131; //Sets bottom texture, side is already built in with blockIcon


    public BlockSocketStation()
    {
        super(Material.wood);
        this.setBlockName("BlockSocketStation");
        this.setHardness(3.5f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
        rand = new Random();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(LibMisc.MODID + ":socketStationSide131");
        this.socketStationBottom131 = iconRegister.registerIcon(LibMisc.MODID + ":socketStationBottom131");
        this.socketStationTop131 = iconRegister.registerIcon(LibMisc.MODID + ":socketStationTop131");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 0 && side == 3) //This is front texture if we ever want one.
        {
            return this.blockIcon;
        }else if(side == metadata)
        {
            return this.blockIcon; //This would be front texture if we wanted one
        }else if(side == 0)
        {
            return this.socketStationBottom131; //Bottom Texture
        }else if(side == 1)
        {
            return this.socketStationTop131; //Top Texture
        }else
        {
            return this.blockIcon; //Side Texture
        }
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) //Sets direciton based on blocks to left/right/front/back of it and changes metadata, which will change texture.
    {
        if(!world.isRemote)
        {
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);

            byte b0 = 3;

            if(block1.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 3;
            }
            if(block2.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 2;
            }
            if(block3.func_149730_j() && !block4.func_149730_j())
            {
                b0 = 5;
            }
            if(block4.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemStack)
    {
        int i = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0f / 360f) + 0.5d) & 3;

        if (i == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (i == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (i == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (i == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int blockSide, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
        {
            return true;
        }else if(!player.isSneaking())
        {
            TileEntitySocketStation entity = (TileEntitySocketStation) world.getTileEntity(x, y, z);
            if(entity != null)
            {
                FMLNetworkHandler.openGui(player, CrystalMagic.instance, CrystalMagic.GUI_ENUM.SOCKET_STATION.ordinal(), world, x, y, z); //Grabs GUI elements from TileEntity for Server and Client
            }
            return true;
        }else
        {
            return false;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2)
    {
        return new TileEntitySocketStation();
    }
}
