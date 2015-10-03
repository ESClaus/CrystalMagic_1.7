package com.clausgames.crystalmagic.block;

import com.clausgames.crystalmagic.achievement.ICraftAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class BlockGoldenBars extends BlockPane implements ICraftAchievement
{
    public BlockGoldenBars()
    {
        super(LibMisc.MODID + ":" + "blockGoldenBars", LibMisc.MODID + ":" + "blockGoldenBars", Material.iron, true); //Sets the texture and sidetexture(if any)
        this.setBlockName("BlockGoldenBars");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal); // Sets sound of stepping on block. (Default: depends on material type chosen)
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    @Override
    public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix)
    {
        return ModAchievements.goldenBarsCraft;
    }
}
