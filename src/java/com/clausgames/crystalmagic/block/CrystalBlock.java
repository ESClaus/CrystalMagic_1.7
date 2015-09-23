package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CrystalBlock extends Block
{

	protected CrystalBlock(String unlocalizedName, Material material)
	{
		super(material);
		this.setBlockName(unlocalizedName); //Name of block
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName); //Name of texture of block
		this.setCreativeTab(CreativeTabs.tabBlock); //Sets creative tab to display block in (Default: tabBlock)
		this.setHardness(2.0f); //Sets how long it takes to break block (Default: Depends on material; stone:1.5f; obsidian:50.0f) 
		this.setResistance(6.0f); //Sets block's resistance to explosions (TNT, Creeper, Etc) (Default: Depends on material; stone:10.0f; obsidian:2000.0f)
		this.setLightLevel(0.75f); //Sets how much light is emitted from block (Default: 0.0f (nothing); maximum 1.0f(full sunlight))
		this.setHarvestLevel("pickaxe", 2); //Sets the tool and tool level required to break the block. If you don't use this the block destruction is set by material type chosen. (Tool: Pickaxe, Axe, Shovel. Level: 0=Wood; 1=Stone; 2=Iron; 3=Diamond)
		this.setStepSound(soundTypeGlass); //Sets sound of stepping on block. (Default: depends on material type chosen)
	}
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
