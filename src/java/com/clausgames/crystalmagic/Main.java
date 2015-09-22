package com.clausgames.crystalmagic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)

public class Main 
{
	public static final String MODID = "cm";
	public static final String MODNAME = "Crystal Magic";
	public static final String VERSION = "0.0.1";
	
	@Instance
	public static Main instance = new Main();
	
	@SidedProxy(clientSide="com.clausgames.crystalmagic.ClientProxy", serverSide="com.clausgames.crystalmagic.ServerProxy")
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
	
	/*@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item/Block init and registering
		//Config handling
		
		//Armor
		apprenticeHood = new ItemApprenticeArmor(apprenticeArmorMaterial, 0, 0).setUnlocalizedName("ItemApprenticeHood").setTextureName("cm:itemApprenticeHood").setCreativeTab(tabCrystalMagic);
		apprenticeRobe = new ItemApprenticeArmor(apprenticeArmorMaterial, 0, 1).setUnlocalizedName("ItemApprenticeRobe").setTextureName("cm:itemApprenticeRobe").setCreativeTab(tabCrystalMagic);
		apprenticeLeggings = new ItemApprenticeArmor(apprenticeArmorMaterial, 0, 2).setUnlocalizedName("ItemApprenticeLeggings").setTextureName("cm:itemApprenticeLeggings").setCreativeTab(tabCrystalMagic);
		apprenticeBoots = new ItemApprenticeArmor(apprenticeArmorMaterial, 0, 3).setUnlocalizedName("ItemApprenticeBoots").setTextureName("cm:itemApprenticeBoots").setCreativeTab(tabCrystalMagic);
		
		//GameRegistry
			
		//Armor
		GameRegistry.registerItem(apprenticeHood, apprenticeHood.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(apprenticeRobe, apprenticeRobe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(apprenticeLeggings, apprenticeLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(apprenticeBoots, apprenticeBoots.getUnlocalizedName().substring(5));
		
		//OreGen
		GameRegistry.registerWorldGenerator(new CrystalGeneration(), 0); //Registering World Gen with blockCrystal Gen
	}*/
	
	/*@EventHandler
	public void init(FMLInitializationEvent event){
		//Proxy, TileEntity, entity, GUI and Packet Registering
		
		//Crafting Recipes
		
		//Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(apprenticeHood), new Object[]{"WWW","W W", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(apprenticeRobe), new Object[]{"W W","WWW","WWW", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(apprenticeLeggings), new Object[]{"WWW","W W","W W", 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(apprenticeBoots), new Object[]{"W W","W W", 'W', Blocks.wool});
	}*/
	
	/*@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public static CreativeTabs tabCrystalMagic = new CreativeTabs("tabCrystalMagic"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(itemRoughCrystal).getItem(); //setting tab's icon to that of the item inside the ItemStack param
		}
	};*/
}
