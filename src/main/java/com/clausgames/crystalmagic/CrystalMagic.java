package com.clausgames.crystalmagic;

import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.block.ModBlocks;
import com.clausgames.crystalmagic.crafting.ModCrafting;
import com.clausgames.crystalmagic.handler.VanillaOreDropHandler;
import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.item.armor.ModArmor;
import com.clausgames.crystalmagic.item.tool.ModTools;
import com.clausgames.crystalmagic.lib.LibMisc;

import com.clausgames.crystalmagic.proxy.IProxy;
import com.clausgames.crystalmagic.tile.ModTileEntities;
import com.clausgames.crystalmagic.world.gen.ModWorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibMisc.MODID, name = LibMisc.MODNAME, version = LibMisc.VERSION)

public class CrystalMagic
{
	@Instance(LibMisc.MODID)
	public static com.clausgames.crystalmagic.CrystalMagic instance;

	@SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_SERVER)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Initialize each class' init.
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		ModArmor.init();
		ModAchievements.init();
		ModTileEntities.init();
		VanillaOreDropHandler.init(); //This init is this way because we need to call OUR handler and not just Forge's by mistake

		//Renderers
		proxy.registerRenderThings();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModCrafting.init();
		ModWorldGen.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}