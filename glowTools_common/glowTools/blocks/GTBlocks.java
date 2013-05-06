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
	public static Block glowironBlock;
	public static Block redironBlock;
	public static Block glowsandBlock;
	public static Block CandentiniumOre;
	public static Block CandentiniumOreGlowing;
	public static Block GlowglassBlock;
	public static Block GlowSandStoneBlock;
	public static Block CandentiniumBlock;
	public static Block GlowGrassBlock;
	public static Block GlowDirtBlock;
	public static Block GlowCobbleBlock;
	public static Block GlowingStoneBlock;
	public static Block FlowStoneBlock;
	public static Block DarkDoor;
	public static Block GlowstoneInfuser;
	public static Block GlowstoneInfuserActive;
	public static Block BlueGlassOre;
	public static Block GlowFarmland;
	
	
	
	public static void init(){
		
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Blocks...", "");
		glowironBlock = new BlockGlowironBlock(ConfigSettings.glowironBlockID).setUnlocalizedName("glowironBlock");
		redironBlock = new BlockRedironBlock(ConfigSettings.redironBlockID).setUnlocalizedName("redironBlock");
		glowsandBlock = new BlockGlowsandBlock(ConfigSettings.glowsandBlockID).setUnlocalizedName("glowsandBlock");
		CandentiniumOre = new BlockCandentiniumOre(ConfigSettings.CandentiniumOreID, false).setUnlocalizedName("CandentiniumOre").setCreativeTab(GlowTools.tabGlowTools);
		CandentiniumOreGlowing = new BlockCandentiniumOre(ConfigSettings.CandentiniumOreGlowingID, true).setLightValue(0.625F).setUnlocalizedName("CandentiniumOre");
		GlowglassBlock = new BlockGlowglassBlock(ConfigSettings.GlowglassBlockID, Material.glass, false).setHardness(0.3F).setUnlocalizedName("glowglassBlock");
		GlowSandStoneBlock = new BlockGlowSandStoneBlock(ConfigSettings.GlowSandStoneBlockID).setHardness(0.8F).setUnlocalizedName("glowsandstoneBlock");
		CandentiniumBlock = new BlockCandentiniumBlock(ConfigSettings.CandentiniumBlockID).setHardness(4F).setResistance(10F).setLightValue(0.625F).setUnlocalizedName("CandentiniumBlock");
		GlowGrassBlock = new BlockGlowGrassBlock(ConfigSettings.GlowGrassBlockID).setUnlocalizedName("glowgrassBlock");
		GlowDirtBlock = new BlockGlowDirtBlock(ConfigSettings.GlowDirtBlockID).setUnlocalizedName("glowdirtBlock");
		GlowCobbleBlock = new BlockGlowCobbleBlock(ConfigSettings.GlowCobbleBlockID).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("glowcobbleBlock");
		GlowingStoneBlock = new BlockGlowingStoneBlock(ConfigSettings.GlowingStoneBlockID).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("glowingstoneBlock");
		FlowStoneBlock = new BlockFlowStoneBlock(ConfigSettings.FlowStoneBlockID).setUnlocalizedName("FlowStoneBlock");
		DarkDoor = new BlockDarkDoor(ConfigSettings.DarkDoorID).setUnlocalizedName("DarkDoor");
		GlowstoneInfuser = new BlockGlowstoneInfuser(ConfigSettings.GlowstoneInfuserID, false).setUnlocalizedName("GlowstoneInfuser");
		GlowstoneInfuserActive = new BlockGlowstoneInfuser(ConfigSettings.GlowstoneInfuserActiveID, true).setUnlocalizedName("GlowstoneInfuserActive");
		BlueGlassOre = new BlockBlueGlassOre(ConfigSettings.BlueGlassOreID).setHardness(1.0F).setResistance(3.0F).setLightValue(0.15F).setUnlocalizedName("BlueGlassOre");
		GlowFarmland = new BlockGlowFarmland(ConfigSettings.GlowFarmlandID).setHardness(0.6F).setUnlocalizedName("GlowFarmBlock");
		
		GameRegistry.registerBlock(glowironBlock, "ZL123_glowironBlock");
		GameRegistry.registerBlock(redironBlock, "ZL123_redironBlock");
		GameRegistry.registerBlock(glowsandBlock, "ZL123_glowsandBlock");
		GameRegistry.registerBlock(CandentiniumOre, "ZL123_candentiniumOre");
		GameRegistry.registerBlock(CandentiniumOreGlowing, "candentiniumOreGlowing");
		GameRegistry.registerBlock(GlowglassBlock, "ZL123_glowglassBlock");
		GameRegistry.registerBlock(GlowSandStoneBlock, "ZL123_glowsandstoneBlock");
		GameRegistry.registerBlock(CandentiniumBlock, "ZL123_candentiniumBlock");
		GameRegistry.registerBlock(GlowGrassBlock, "ZL123_glowgrassBlock");
		GameRegistry.registerBlock(GlowDirtBlock, "ZL123_glowdirtBlock");
		GameRegistry.registerBlock(GlowCobbleBlock, "ZL123_glowcobbleBlock");
		GameRegistry.registerBlock(GlowingStoneBlock, "ZL123_glowingstoneBlock");
		GameRegistry.registerBlock(FlowStoneBlock, "ZL123_flowstoneBlock");
		GameRegistry.registerBlock(DarkDoor, "ZL123_darkdoor");
		GameRegistry.registerBlock(GlowstoneInfuser, "ZL123_glowstoneInfuser");
		GameRegistry.registerBlock(GlowstoneInfuserActive, "ZL123_glowstoneInfuserActive");
		GameRegistry.registerBlock(BlueGlassOre, "ZL123_blueglassOre");
		GameRegistry.registerBlock(GlowFarmland, "ZL123_glowFarmland");
		
		MinecraftForge.setBlockHarvestLevel(glowironBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(redironBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(CandentiniumOre, "pickaxe", 2);	
		MinecraftForge.setBlockHarvestLevel(CandentiniumOreGlowing, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(GlowSandStoneBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(CandentiniumBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(GlowCobbleBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(GlowingStoneBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(FlowStoneBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(DarkDoor, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(GlowstoneInfuser, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(GlowstoneInfuserActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BlueGlassOre, "pickaxe", 1);
		
	}
	
	
}