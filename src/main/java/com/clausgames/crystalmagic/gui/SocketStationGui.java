package com.clausgames.crystalmagic.gui;

import com.clausgames.crystalmagic.container.SocketStationContainer;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class SocketStationGui extends GuiContainer
{
    private ResourceLocation texture = new ResourceLocation(LibMisc.MODID + ":textures/gui/socketStationGui.png");
    public SocketStationGui(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        super(new SocketStationContainer(invPlayer, world, x, y, z));
        this.xSize = 176; //TODO what are these sizes, adjust to what we need
        this.ySize = 166;
    }

    public void onGuiClosed() //Called when the screen is unloaded. Used to disable keyboard repeat events
    {
        if (this.mc.thePlayer != null)
        {
            this.inventorySlots.onContainerClosed(this.mc.thePlayer);
        }
    }

    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Socket Station"), 95, 8, 0xA634DB);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1f, 1f, 1f, 1f);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
