package com.clausgames.crystalmagic.block;

import java.util.Random;

import com.clausgames.crystalmagic.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CrystalBlock extends Block
{
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	protected CrystalBlock(String unlocalizedName, Material material, Item drop, int meta, int least_quantity, int most_quantity)
	{
		super(material);
		this.drop = drop;
	    this.meta = meta;
	    this.least_quantity = least_quantity;
	    this.most_quantity = most_quantity;
		this.setBlockName(unlocalizedName); //Name of block
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName); //Name of texture of block
		this.setCreativeTab(CreativeTabs.tabBlock); //Sets creative tab to display block in (Default: tabBlock)
		this.setHardness(2.0f); //Sets how long it takes to break block (Default: Depends on material; stone:1.5f; obsidian:50.0f) 
		this.setResistance(6.0f); //Sets block's resistance to explosions (TNT, Creeper, Etc) (Default: Depends on material; stone:10.0f; obsidian:2000.0f)
		this.setLightLevel(0.75f); //Sets how much light is emitted from block (Default: 0.0f (nothing); maximum 1.0f(full sunlight))
		this.setHarvestLevel("pickaxe", 2); //Sets the tool and tool level required to break the block. If you don't use this the block destruction is set by material type chosen. (Tool: Pickaxe, Axe, Shovel. Level: 0=Wood; 1=Stone; 2=Iron; 3=Diamond)
		this.setStepSound(soundTypeGlass); //Sets sound of stepping on block. (Default: depends on material type chosen)
	}
	protected CrystalBlock(String unlocalizedName, Material mat, Item drop, int least_quantity, int most_quantity)
	{
	    this(unlocalizedName, mat, drop, 0, least_quantity, most_quantity);
	}
	protected CrystalBlock(String unlocalizedName, Material mat, Item drop)
	{
	    this(unlocalizedName, mat, drop, 1, 1);
	}
	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
	    return this.drop;
	}

	@Override
	public int damageDropped(int metadata)
	{
	    return this.meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
}
