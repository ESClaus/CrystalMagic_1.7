package com.clausgames.crystalmagic.world.gen;

import com.clausgames.crystalmagic.block.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGeneratorCrystals implements IWorldGenerator
{
    private WorldGenerator genCrystalBlock; // Generates CrystalBlock (used in Overworld)

    public WorldGeneratorCrystals()
    {
        this.genCrystalBlock = new WorldGenMinable(ModBlocks.blockCrystal, 5, Blocks.stone);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case 0: // Overworld
                this.runGenerator(this.genCrystalBlock, world, random, chunkX, chunkZ, 4, 0, 40);
                break;
            case -1: // Nether

                break;
            case 1: // End

                break;
        }
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
    {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++)
        {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, x, y, z);
        }
    }
}