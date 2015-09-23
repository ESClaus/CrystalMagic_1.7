package com.clausgames.crystalmagic;

import java.util.Random;

import com.clausgames.crystalmagic.block.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class CrystalGeneration implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case -1: //Nether
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0: //Overworld
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1: //End
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}
	}
	public void generateNether(World world, Random rand, int x, int z)
	{ //Dimension ID -1
		
	}
	public void generateOverworld(World world, Random rand, int x, int z)
	{ //Dimension ID 0
		generateOre(ModBlocks.blockCrystal, world, rand, x, z, 4, 8, 10, 0, 100, Blocks.stone); //Look at generateOre method below
	}
	public void generateEnd(World world, Random rand, int x, int z)
	{ //Dimension ID 1
		
	}
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn)
	{ //Block we are spawning, world, rand, x, z, min Vein, Max Vein, chance it will occur, y level min, y level max, what block types it generates in (stone, grass/dirt, etc).
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize); //How many will occur together.
		int heightRange = maxY - minY; //Y Level Generates at in world.
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
		for(int i = 0; i < chance; i++)
		{
			int xRand = chunkX * 16 + random.nextInt(16); //random X position within Chunk
			int yRand = random.nextInt(heightRange) + minY; //random Y position with Y Range
			int zRand = chunkZ * 16 + random.nextInt(16); //random Z position within Chunk
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}