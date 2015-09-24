package com.clausgames.crystalmagic;

import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.crafting.ModCrafting;
import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.world.CrystalGeneration;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e)
	{
		// Initialize each class' init.
		ModItems.init();
		ModBlocks.init();
		ModCrafting.init();
	}

	public void init(FMLInitializationEvent e)
	{
		// WorldGen
		GameRegistry.registerWorldGenerator(new CrystalGeneration(), 0);
	}

	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
}
