package com.clausgames.crystalmagic;

import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.lib.LibMisc;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = LibMisc.MODID, name = LibMisc.MODNAME, version = LibMisc.VERSION)

public class CrystalMagic
{


	@Instance
	public static CrystalMagic instance = new CrystalMagic();

	@SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_SERVER)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}

	public static CreativeTabs tabCrystalMagic = new CreativeTabs("tabCrystalMagic")
	{
		@Override
		public Item getTabIconItem()
		{
			return new ItemStack(ModItems.itemCrystalFragment).getItem();
		}
	};
}
