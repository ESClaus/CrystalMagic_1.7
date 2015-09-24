package com.clausgames.crystalmagic;

import com.clausgames.crystalmagic.item.ModItems;

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

@Mod(modid = CrystalMagic.MODID, name = CrystalMagic.MODNAME, version = CrystalMagic.VERSION)

public class CrystalMagic
{
	public static final String MODID = "cg_crystalmagic";
	public static final String MODNAME = "Crystal Magic";
	public static final String VERSION = "0.0.1";

	@Instance
	public static CrystalMagic instance = new CrystalMagic();

	@SidedProxy(clientSide = "com.clausgames.crystalmagic.ClientProxy", serverSide = "com.clausgames.crystalmagic.ServerProxy")
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
