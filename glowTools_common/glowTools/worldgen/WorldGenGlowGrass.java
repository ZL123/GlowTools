/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.worldgen;

import glowTools.blocks.GTBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenGlowGrass implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOverworld(world, random, chunkX*16, chunkZ*16);
	}
	
	public void generateOverworld(World world, Random rand, int chunkX, int chunkZ)
	{
		Random ChunkGenRand = new Random();
		int ChunkGenRandNum = ChunkGenRand.nextInt(75)+1;
		
		if(ChunkGenRandNum == 1){
			for (int i = 0; i < 14; i++)
			{
				int randPosX = chunkX + rand.nextInt(16);
				int randPosZ = chunkZ + rand.nextInt(16);
				int randPosY = world.getHeightValue(randPosX, randPosZ);
				if (world.getBlockId(randPosX, randPosY - 1, randPosZ) == Block.grass.blockID ||
					world.getBlockId(randPosX, randPosY - 1, randPosZ) == Block.dirt.blockID)
				{
					world.setBlock(randPosX, randPosY, randPosZ, GTBlocks.blockGlowGrass.blockID);
				}
			}
		}
	}
}
