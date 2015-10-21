package com.clausgames.crystalmagic.crafting;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

public class SocketBenchRecipeSorter implements Comparator
{
    final SocketBenchRecipeManager socketBench;

    public SocketBenchRecipeSorter(SocketBenchRecipeManager socketBenchRecipeManager)
    {
        this.socketBench = socketBenchRecipeManager;
    }

    public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2)
    {
        return (irecipe1 instanceof SocketBenchShapelessRecipes && irecipe2 instanceof SocketBenchShapedRecipes) ? 1 : (irecipe2 instanceof SocketBenchShapelessRecipes && irecipe1 instanceof SocketBenchShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object o1, Object o2)
    {
        return  this.compareRecipes((IRecipe) o1, (IRecipe) o2);
    }
}
