package com.clausgames.crystalmagic.gui;

import com.clausgames.crystalmagic.container.SocketStationContainer;
import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.tile.TileEntitySocketStation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SocketStationGui extends GuiContainer
{
    private ResourceLocation texture = new ResourceLocation(LibMisc.MODID + ":textures/gui/socketStationGui.png");
    private TileEntitySocketStation socketStation;

    public SocketStationGui(InventoryPlayer invPlayer, TileEntitySocketStation teSocketStation)
    {
        super(new SocketStationContainer(invPlayer, teSocketStation));
        socketStation = teSocketStation;

        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        String name = this.socketStation.hasCustomInventoryName() ? this.socketStation.getInventoryName() : I18n.format(this.socketStation.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 0xFFFFFF); //Centers String in top middle of GUI, 6 pixels down, color we choose.
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 4, 0xFFFFFF); //Says "Inventory" on GUI
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
