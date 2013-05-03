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
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenGlowOres implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
		{
			switch(world.provider.dimensionId){
			case -1:
			generateNether(world, random, chunkX*16, chunkZ*16);
			break;
			case 0:
			generateOverworld(world, random, chunkX*16, chunkZ*16);
			break;
			case 1:
			generateEnd();
			break;
			}
		}
		
		public void generateNether(World world, Random rand, int chunkX, int chunkZ)
		{
			for (int i = 0; i < 2; i++)
			{
				int randPosX = chunkX + rand.nextInt(16);
				int randPosY = 32 + rand.nextInt(64);
				int randPosZ = chunkZ + rand.nextInt(16);
				(new WorldGenMinable(GTBlocks.BlueGlassOre.blockID, 14, Block.netherrack.blockID))
						.generate(world, rand, randPosX, randPosY, randPosZ);
			}
		}
			
		public void generateOverworld(World world, Random rand, int chunkX, int chunkZ)
		{
			// Up to 2 veins of ore per chunk
			for (int i = 0; i < 2; i++)
			{
				// Up to Y co-ord 20
				int randPosX = chunkX + rand.nextInt(16);
				int randPosY = rand.nextInt(20);
				int randPosZ = chunkZ + rand.nextInt(16);
				//Up to 8 blocks per vein
				(new WorldGenMinable(GTBlocks.CandentiniumOre.blockID, 8)).generate(world, rand,
						randPosX, randPosY, randPosZ);
			}
			
			Random ChunkGenRand = new Random();
			int ChunkGenRandNum = ChunkGenRand.nextInt(8)+1;
			
			if(ChunkGenRandNum == 1){
				for (int i = 0; i < 4; i++)
				{
					int randPosX = chunkX + rand.nextInt(16);
					int randPosY = rand.nextInt(72);
					int randPosZ = chunkZ + rand.nextInt(16);
					(new WorldGenMinable(GTBlocks.FlowStoneBlock.blockID, 120)).generate(world, rand,
						randPosX, randPosY, randPosZ);
				}
			}
			
		}
		public void generateEnd() {}
		

}
