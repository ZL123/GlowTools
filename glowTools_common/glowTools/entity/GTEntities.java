/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.entity;

import glowTools.GlowTools;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class GTEntities {
	public static void registerEntities(){
		EntityRegistry.registerModEntity(EntitySkidglow.class, "Skidglow", 1, GlowTools.instance, 100, 3, true);
		
		
		EntityRegistry.addSpawn(EntitySkidglow.class, 3, 2, 6, EnumCreatureType.monster, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.hell, BiomeGenBase.sky, BiomeGenBase.swampland);
	}
}
