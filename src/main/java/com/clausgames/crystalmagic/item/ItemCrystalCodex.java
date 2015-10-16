package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.gui.CrystalCodexGui;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCrystalCodex extends ItemCrystalMagic
{
    public ItemCrystalCodex(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick (ItemStack item, World world, EntityPlayer player)
    {
        Minecraft mc = Minecraft.getMinecraft();
        if(!world.isRemote)
        {
            mc.displayGuiScreen(new CrystalCodexGui(mc));
        }
        return super.onItemRightClick(item, world, player);
    }
}
