package com.clausgames.crystalmagic.gui;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CrystalCodexGui extends GuiScreen
{
    int guiWidth = 145;
    int guiHeight = 179;

    @Override
    public void drawScreen(int x, int y, float ticks)
    {
        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        mc.renderEngine.bindTexture(new ResourceLocation(LibMisc.MODID, "textures/gui/crystalCodexGui.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight); //gui x/y position on screen, u/v position, gui width/height
        fontRendererObj.drawString("Crystal Magic", guiX + 40, guiY + 15, 0x404040); //Text, X, Y, Color in Hex

        super.drawScreen(x, y, ticks);
    }
}
