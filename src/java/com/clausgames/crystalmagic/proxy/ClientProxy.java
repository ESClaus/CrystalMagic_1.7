package com.clausgames.crystalmagic.proxy;

import com.clausgames.crystalmagic.client.renderer.RenderCrystalOre;
import com.clausgames.crystalmagic.tile.TileEntityBlockCrystalOre;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends CommonProxy
{
	public void registerRenderThings()
	{
		//CrystalOreBlock
		TileEntitySpecialRenderer render = new RenderCrystalOre();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockCrystalOre.class, render);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}

	@Override
	public ClientProxy getClientProxy()
	{
		return this;
	}
}
