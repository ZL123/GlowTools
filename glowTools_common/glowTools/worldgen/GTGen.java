package glowTools.worldgen;

import glowTools.lib.Reference;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTGen {
	
	public static void gen(){
		GameRegistry.registerWorldGenerator(new WorldGenGlowOres());
		GameRegistry.registerWorldGenerator(new WorldGenGlowGrass());
	}
	
}
