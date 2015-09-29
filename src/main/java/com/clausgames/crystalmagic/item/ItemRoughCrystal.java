package com.clausgames.crystalmagic.item;

import com.clausgames.crystalmagic.achievement.IPickupAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemRoughCrystal extends ItemCrystalMagic implements IPickupAchievement
{
    public ItemRoughCrystal()
    {
        super();
        this.setUnlocalizedName("ItemRoughCrystal");
    }

    @Override
    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item) {
        return stack.getItemDamage() == 0 ? ModAchievements.roughCrystal : null;
    }
}