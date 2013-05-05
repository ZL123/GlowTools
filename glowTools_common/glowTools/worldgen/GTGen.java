/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.worldgen;

import glowTools.lib.Reference;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTGen {
	
	public static void generate(){
		GameRegistry.registerWorldGenerator(new WorldGenGlowOres());
		GameRegistry.registerWorldGenerator(new WorldGenGlowGrass());
	}
	
}
