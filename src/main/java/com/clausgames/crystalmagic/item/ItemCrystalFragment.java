package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.achievement.IPickupAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.command.CommandGive;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemCrystalFragment extends ItemCrystalMagic implements IPickupAchievement
{
    public ItemCrystalFragment(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item) {
        if (stack.getItemDamage() == 0)
        {
            //TODO Add code to give player CrystalCodex when this code runs.
            return ModAchievements.crystalFragmentPickup;
        } else
        {
            return null;
        }
    }
}
