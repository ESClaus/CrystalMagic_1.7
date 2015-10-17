package com.clausgames.crystalmagic.handler;

import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.gui.CrystalCodexGui;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Minecraft mc = Minecraft.getMinecraft();

        if (ID == CrystalMagic.GUI_ENUM.CRYSTALCODEX.ordinal())
        {
            return new CrystalCodexGui(mc);
        }
        return null;
    }
}
