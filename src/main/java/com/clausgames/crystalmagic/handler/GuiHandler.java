package com.clausgames.crystalmagic.handler;

import com.clausgames.crystalmagic.CrystalMagic;

import com.clausgames.crystalmagic.container.SocketStationContainer;
import com.clausgames.crystalmagic.gui.CrystalCodexGui;
import com.clausgames.crystalmagic.gui.SocketStationGui;
import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null)
        {
            if (ID == CrystalMagic.GUI_ENUM.SOCKET_STATION.ordinal())
            {
                if(entity instanceof TileEntitySocketStation)
                {
                    return new SocketStationContainer(player.inventory, (TileEntitySocketStation) entity);
                } else
                {
                    return null;
                }
            }
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Minecraft mc = Minecraft.getMinecraft();
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null)
        {
            if(ID == CrystalMagic.GUI_ENUM.SOCKET_STATION.ordinal())
            {
                if(entity instanceof TileEntitySocketStation)
                {
                    return new SocketStationGui(player.inventory, (TileEntitySocketStation) entity);
                }
            } else
            {
                return null;
            }
        }

        if (ID == CrystalMagic.GUI_ENUM.CRYSTALCODEX.ordinal())
        {
            return new CrystalCodexGui(mc);
        }
        return null;
    }
}
