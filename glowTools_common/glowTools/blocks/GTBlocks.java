/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import glowTools.GlowTools;
import glowTools.config.ConfigSettings;
import glowTools.lib.Reference;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTBlocks {
		
	//Blocks
	public static Block blockGlowIron;
	public static Block blockRedIron;
	public static Block blockGlowSand;
	public static Block oreCandentinium;
	public static Block oreCandentiniumGlowing;
	public static Block blockGlowGlass;
	public static Block blockGlowSandstone;
	public static Block blockCandentinium;
	public static Block blockGlowGrass;
	public static Block blockGlowDirt;
	public static Block blockGlowCobble;
	public static Block blockGlowingStone;
	public static Block blockFlowStone;
	public static Block blockDoorDark;
	public static Block blockGlowstoneInfuser;
	public static Block blockGlowstoneInfuserActive;
	public static Block oreBlueGlass;
	public static Block blockGlowFarm;
	
	
	public static void init(){
		
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Blocks...", "");
		blockGlowIron = new BlockGlowironBlock(ConfigSettings.blockGlowIronID).setUnlocalizedName("glowironBlock");
		blockRedIron = new BlockRedironBlock(ConfigSettings.blockRedIronID).setUnlocalizedName("redironBlock");
		blockGlowSand = new BlockGlowsandBlock(ConfigSettings.blockGlowSandID).setUnlocalizedName("glowsandBlock");
		oreCandentinium = new BlockCandentiniumOre(ConfigSettings.oreCandentiniumID, false).setUnlocalizedName("CandentiniumOre").setCreativeTab(GlowTools.tabGlowTools);
		oreCandentiniumGlowing = new BlockCandentiniumOre(ConfigSettings.oreCandentiniumGlowingID, true).setLightValue(0.625F).setUnlocalizedName("CandentiniumOre");
		blockGlowGlass = new BlockGlowglassBlock(ConfigSettings.blockGlowGlassID, Material.glass, false).setHardness(0.3F).setUnlocalizedName("glowglassBlock");
		blockGlowSandstone = new BlockGlowSandStoneBlock(ConfigSettings.blockGlowSandstoneID).setHardness(0.8F).setUnlocalizedName("glowsandstoneBlock");
		blockCandentinium = new BlockCandentiniumBlock(ConfigSettings.blockCandentiniumID).setHardness(4F).setResistance(10F).setLightValue(0.625F).setUnlocalizedName("CandentiniumBlock");
		blockGlowGrass = new BlockGlowGrassBlock(ConfigSettings.blockGlowGrassID).setUnlocalizedName("glowgrassBlock");
		blockGlowDirt = new BlockGlowDirtBlock(ConfigSettings.blockGlowDirtID).setUnlocalizedName("glowdirtBlock");
		blockGlowCobble = new BlockGlowCobbleBlock(ConfigSettings.blockGlowCobbleID).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("glowcobbleBlock");
		blockGlowingStone = new BlockGlowingStoneBlock(ConfigSettings.blockGlowingStoneID).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("glowingstoneBlock");
		blockFlowStone = new BlockFlowStoneBlock(ConfigSettings.blockFlowStoneID).setUnlocalizedName("FlowStoneBlock");
		blockDoorDark = new BlockDarkDoor(ConfigSettings.blockDoorDarkID).setUnlocalizedName("DarkDoor");
		blockGlowstoneInfuser = new BlockGlowstoneInfuser(ConfigSettings.blockGlowstoneInfuserID, false).setUnlocalizedName("GlowstoneInfuser");
		blockGlowstoneInfuserActive = new BlockGlowstoneInfuser(ConfigSettings.blockGlowstoneInfuserActiveID, true).setUnlocalizedName("GlowstoneInfuserActive");
		oreBlueGlass = new BlockBlueGlassOre(ConfigSettings.oreBlueGlassID).setHardness(1.0F).setResistance(3.0F).setLightValue(0.15F).setUnlocalizedName("BlueGlassOre");
		blockGlowFarm = new BlockGlowFarmland(ConfigSettings.blockGlowFarmID).setHardness(0.6F).setUnlocalizedName("GlowFarmBlock");
		
		GameRegistry.registerBlock(blockGlowIron, "ZL123_glowironBlock");
		GameRegistry.registerBlock(blockRedIron, "ZL123_redironBlock");
		GameRegistry.registerBlock(blockGlowSand, "ZL123_glowsandBlock");
		GameRegistry.registerBlock(oreCandentinium, "ZL123_candentiniumOre");
		GameRegistry.registerBlock(oreCandentiniumGlowing, "candentiniumOreGlowing");
		GameRegistry.registerBlock(blockGlowGlass, "ZL123_glowglassBlock");
		GameRegistry.registerBlock(blockGlowSandstone, "ZL123_glowsandstoneBlock");
		GameRegistry.registerBlock(blockCandentinium, "ZL123_candentiniumBlock");
		GameRegistry.registerBlock(blockGlowGrass, "ZL123_glowgrassBlock");
		GameRegistry.registerBlock(blockGlowDirt, "ZL123_glowdirtBlock");
		GameRegistry.registerBlock(blockGlowCobble, "ZL123_glowcobbleBlock");
		GameRegistry.registerBlock(blockGlowingStone, "ZL123_glowingstoneBlock");
		GameRegistry.registerBlock(blockFlowStone, "ZL123_flowstoneBlock");
		GameRegistry.registerBlock(blockDoorDark, "ZL123_darkdoor");
		GameRegistry.registerBlock(blockGlowstoneInfuser, "ZL123_glowstoneInfuser");
		GameRegistry.registerBlock(blockGlowstoneInfuserActive, "ZL123_glowstoneInfuserActive");
		GameRegistry.registerBlock(oreBlueGlass, "ZL123_blueglassOre");
		GameRegistry.registerBlock(blockGlowFarm, "ZL123_glowFarmland");
		
		MinecraftForge.setBlockHarvestLevel(blockGlowIron, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockRedIron, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreCandentinium, "pickaxe", 2);	
		MinecraftForge.setBlockHarvestLevel(oreCandentiniumGlowing, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockGlowSandstone, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(blockCandentinium, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockGlowCobble, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(blockGlowingStone, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(blockFlowStone, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockDoorDark, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockGlowstoneInfuser, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockGlowstoneInfuserActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreBlueGlass, "pickaxe", 1);
		
	}
	
	
}