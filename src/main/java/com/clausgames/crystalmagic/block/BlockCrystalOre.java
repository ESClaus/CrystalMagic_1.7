package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.item.ModItems;
import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import com.clausgames.crystalmagic.tile.TileEntityBlockCrystalOre;

import java.util.Random;


public class BlockCrystalOre extends BlockContainer
{
    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;

    protected BlockCrystalOre(Material material)
    {
        super(material);
        this.setBlockName("BlockCrystalOre");
        this.setHardness(2.0f); // Sets how long it takes to break block (Default: Depends on material; stone:1.5f; obsidian:50.0f)
        this.setResistance(6.0f); // Sets block's resistance to explosions (TNT, Creeper, Etc) (Default: Depends on material; stone:10.0f; obsidian:2000.0f)
        this.setLightLevel(0.3f); // Sets how much light is emitted from block (Default: 0.0f (nothing); maximum 1.0f(full sunlight))
        this.setHarvestLevel("pickaxe", 2); // Sets the tool and tool level required to break the block. If you don't use this the block destruction is set by material type chosen. (Tool: Pickaxe, Axe, Shovel. Level: 0=Wood; 1=Stone; 2=Iron; 3=Diamond)
        this.setStepSound(soundTypeStone); // Sets sound of stepping on block. (Default: depends on material type chosen)
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    public int getRenderType()
    {
        return -1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityBlockCrystalOre();
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        String toolUsed = harvesters.get().getCurrentEquippedItem().getItem().getUnlocalizedName().substring(5); // Checks what tool was that player used to break item.
        if (toolUsed.equals("ItemCrystalEdgedPickaxe"))
        {
            this.drop = ModItems.itemRoughCrystal;
            return this.drop;
        } else
        {
            this.drop = ModItems.itemCrystalFragment;
            return this.drop;
        }
    }

    @Override
    public int damageDropped(int metadata)
    {
        return this.meta;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        if (drop == ModItems.itemRoughCrystal)
        {
            if (this.least_quantity >= this.most_quantity)
                return this.least_quantity;
            return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
        } else
        {
            this.least_quantity = 1;
            this.most_quantity = 2;
            if (this.least_quantity >= this.most_quantity)
                return this.least_quantity;
            return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
        }
    }
}
