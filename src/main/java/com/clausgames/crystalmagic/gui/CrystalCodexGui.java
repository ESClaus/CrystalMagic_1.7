package com.clausgames.crystalmagic.gui;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CrystalCodexGui extends GuiScreen
{
    int guiWidth = 246;
    int guiHeight = 181;
    String title = "Crystal Magic";

    public CrystalCodexGui(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = scaled.getScaledWidth(); //Gets EXACT width of screen, even when scaled
        int height = scaled.getScaledHeight(); //Gets EXACT height of screen, even when scaled
    }

    @Override
    public void drawScreen(int x, int y, float ticks)
    {
        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        mc.renderEngine.bindTexture(new ResourceLocation(LibMisc.MODID, "textures/gui/codexbg.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight); //gui x/y position on screen, u/v position, gui width/height
        drawCenteredString(mc.fontRenderer, title, width / 2, guiY + 15, 0xFFFFFF); //Centers string for me.

        super.drawScreen(x, y, ticks);
    }

    @Override
    public boolean doesGuiPauseGame()
    {

        return false;
    }
}
