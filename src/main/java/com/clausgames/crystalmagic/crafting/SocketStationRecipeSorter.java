package com.clausgames.crystalmagic.crafting;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

public class SocketStationRecipeSorter implements Comparator
{
    final SocketStationCraftingManager socketStation;

    public SocketStationRecipeSorter(SocketStationCraftingManager socketStationCraftingManager)
    {
        this.socketStation = socketStationCraftingManager;
    }

    public int compareRecipes(IRecipe iRecipe1, IRecipe iRecipe2)
    {
        if (iRecipe1 instanceof SocketStationShapelessRecipes && iRecipe2 instanceof SocketStationShapedRecipes)
        {
            return 1;
        } else if (iRecipe2 instanceof SocketStationShapelessRecipes && iRecipe1 instanceof SocketStationShapedRecipes)
        {
            return -1;
        } else if (iRecipe2.getRecipeSize() < iRecipe1.getRecipeSize())
        {
            return -1;
        } else if (iRecipe2.getRecipeSize() > iRecipe1.getRecipeSize())
        {
            return 1;
        } else
        {
            return 0;
        }
    }

    @Override
    public int compare(Object o1, Object o2)
    {
        return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
    }
}
