/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.recipe;

import java.util.logging.Level;

import glowTools.GlowTools;
import glowTools.blocks.GTBlocks;
import glowTools.items.GTItems;
import glowTools.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTRecipes {
	
	public static void recipes(){
		
        FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Recipes...", "");
        
		//General Items/Blocks
		GameRegistry.addRecipe(new ItemStack(GTBlocks.glowironBlock, 2), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.glowironItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.glowironItem, 4), new Object[]{"X", 'X', GTBlocks.glowironBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.glowironItem), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.glowmoltItem)});
		GameRegistry.addSmelting(Item.lightStoneDust.itemID, new ItemStack(GTItems.glowmoltItem, 1), 0.4F);
		GameRegistry.addSmelting(Item.redstone.itemID, new ItemStack(GTItems.redmoltItem, 1), 0.4F);
		GameRegistry.addRecipe(new ItemStack(Item.expBottle, 3), new Object[]{"XZY", "XZY", "XZY", 'X', GTItems.glowmoltItem, 'Y', GTItems.redmoltItem, 'Z', new ItemStack(Item.glassBottle)});
		GameRegistry.addSmelting(Item.expBottle.itemID, new ItemStack(Item.expBottle, 1), 0.7F);	
		GameRegistry.addRecipe(new ItemStack(GTBlocks.redironBlock, 2), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.redironItem});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.glowredItem, 3), new Object[]{new ItemStack(GTItems.glowmoltItem), new ItemStack(GTItems.redmoltItem), new ItemStack(Item.blazePowder)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.redironItem), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.redmoltItem)});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironItem, 4), new Object[]{"X", 'X', GTBlocks.redironBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.RedironhandleItem), new Object[]{new ItemStack(GTItems.glowredItem), new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(GTItems.PorkappleItem, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Item.porkCooked), 'Y', new ItemStack(Item.appleRed)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.glowsandBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sand), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.CandentiniumOre.blockID, new ItemStack(GTItems.CandentiniumGem), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowglassBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.glass), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.glowsandBlock.blockID, new ItemStack(GTBlocks.GlowglassBlock), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowSandStoneBlock), new Object[]{"XX", "XX", 'X', GTBlocks.glowsandBlock});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowSandStoneBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sandStone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", 'X', new ItemStack(GTBlocks.GlowSandStoneBlock)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.CandentiniumBlock), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowDirtBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.dirt), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowCobbleBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.cobblestone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.GlowingStoneBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.stone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.GlowCobbleBlock.blockID, new ItemStack(GTBlocks.GlowingStoneBlock), 0.2F);
		GameRegistry.addRecipe(new ItemStack(GTItems.glowironItem), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.glowironNugget});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironItem), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.redironNugget});
		GameRegistry.addRecipe(new ItemStack(GTItems.glowironNugget, 9), new Object[]{"X", 'X', GTItems.glowironItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironNugget, 9), new Object[]{"X", 'X', GTItems.redironItem});
		GameRegistry.addSmelting(GTBlocks.FlowStoneBlock.blockID, new ItemStack(GTItems.pureCalciteItem), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GTItems.cloakCore), new Object[]{"XYX", "YZY", "XYX", 'X', new ItemStack(Block.cloth), 'Y', new ItemStack(Item.diamond), 'Z', GTBlocks.CandentiniumBlock});
		GameRegistry.addRecipe(new ItemStack(GTItems.ReflectorItem), new Object[]{"XYX", "XZX", "XYX", 'X', GTItems.pureCalciteItem, 'Y', GTItems.CandentiniumGem, 'Z', new ItemStack(Item.diamond)});
		GameRegistry.addSmelting(GTBlocks.CandentiniumBlock.blockID, new ItemStack(GTItems.CandentiniumGem, 9), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.DarkDoorItem), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.obsidian), 'Y', new ItemStack(Item.doorIron)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.InfernalCoalItem, 4), new Object[]{new ItemStack(GTItems.glowredItem), new ItemStack(Item.coal)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.InfernalCoalItem, 4), new Object[]{new ItemStack(GTItems.glowmoltItem), new ItemStack(GTItems.redmoltItem), new ItemStack(Item.blazePowder), new ItemStack(Item.coal)});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.glowironBlock});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.redironBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.BlueFertilizerItem, 2), new Object[]{new ItemStack(GTItems.BlueGlassShard), new ItemStack(Item.bucketWater)});
		
		//Armor
		GameRegistry.addRecipe(new ItemStack(GTItems.GlironHelm), new Object[]{"XYX", "X X", 'X', GTItems.glowironItem, 'Y', GTItems.CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GTItems.GlironChest), new Object[]{"X X", "YXY", "XXX", 'X', GTItems.glowironItem, 'Y', GTItems.CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GTItems.GlironLegs), new Object[]{"XXX", "Y Y", "X X", 'X', GTItems.glowironItem, 'Y', GTItems.CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GTItems.GlironBoots), new Object[]{"X X", "X X", 'X', GTItems.glowironItem});
		GameRegistry.addSmelting(GTItems.GlironHelm.itemID, new ItemStack(GTItems.glowironItem, 2), 0.2F);
		GameRegistry.addSmelting(GTItems.GlironChest.itemID, new ItemStack(GTItems.glowironItem, 4), 0.7F);
		GameRegistry.addSmelting(GTItems.GlironLegs.itemID, new ItemStack(GTItems.glowironItem, 3), 0.6F);
		GameRegistry.addSmelting(GTItems.GlironBoots.itemID, new ItemStack(GTItems.glowironItem, 2), 0.2F);
		
		//Scepters
		GameRegistry.addRecipe(new ItemStack(GTItems.LightscepterItem, 1), new Object[]{"TPT", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.goldenCarrot), 'S', new ItemStack(GTItems.glowredItem), 'P', new ItemStack(GTItems.SceptertipItem), 'T', new ItemStack(GTItems.glowmoltItem)});
		GameRegistry.addRecipe(new ItemStack(GTItems.RegenscepterItem, 1), new Object[]{"TPU", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.ghastTear), 'S', new ItemStack(GTItems.glowredItem), 'P', new ItemStack(GTItems.SceptertipItem), 'T', new ItemStack(Item.plateDiamond),
			'U', new ItemStack(Item.appleGold, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(GTItems.Regenscepter2Item), new Object[]{"PQP", "RSR", "PQP", 'P', new ItemStack(Item.diamond), 'Q',
			new ItemStack(GTItems.CandentiniumGem), 'R', new ItemStack(Block.blockGold), 'S', new ItemStack(GTItems.RegenscepterItem)});
		GameRegistry.addRecipe(new ItemStack(GTItems.OmniscepterItem), new Object[]{getOmniScepterLine(1), getOmniScepterLine(2), getOmniScepterLine(3), 'A', new ItemStack(Block.blockDiamond), 'B',
			new ItemStack(Block.blockEmerald), 'C', new ItemStack(GTItems.LightscepterItem), 'D', new ItemStack(GTItems.CloakInvis), 'E', new ItemStack(GTItems.Regenscepter2Item), 'F', new ItemStack(Item.diamond),
			'G', new ItemStack(Item.emerald), 'H', new ItemStack(GTItems.CandentiniumGem)});
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(GTItems.redironswordItem), new Object[]{" X ", " X ", " Y ", 'X', GTItems.redironItem, 'Y', GTItems.RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironpickItem), new Object[]{"XXX", " Y ", " Y ", 'X', GTItems.redironItem, 'Y', GTItems.RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironshovelItem), new Object[]{" X ", " Y ", " Y ", 'X', GTItems.redironItem, 'Y', GTItems.RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironaxeItem), new Object[]{"XX ", "XY ", " Y ", 'X', GTItems.redironItem, 'Y', GTItems.RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(GTItems.redironhoeItem), new Object[]{"XX ", " Y ", " Y ", 'X', GTItems.redironItem, 'Y', GTItems.RedironhandleItem});
		GameRegistry.addSmelting(GTItems.redironswordItem.itemID, new ItemStack(GTItems.redironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.redironpickItem.itemID, new ItemStack(GTItems.redironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.redironshovelItem.itemID, new ItemStack(GTItems.redironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.redironaxeItem.itemID, new ItemStack(GTItems.redironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.redironhoeItem.itemID, new ItemStack(GTItems.redironNugget), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.glironswordItem), new Object[]{" X ", " X ", " Y ", 'X', GTItems.glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.glironpickItem), new Object[]{"XXX", " Y ", " Y ", 'X', GTItems.glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.glironshovelItem), new Object[]{" X ", " Y ", " Y ", 'X', GTItems.glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.glironaxeItem), new Object[]{"XX ", "XY ", " Y ", 'X', GTItems.glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.glironhoeItem), new Object[]{"XX ", " Y ", " Y ", 'X', GTItems.glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addSmelting(GTItems.glironswordItem.itemID, new ItemStack(GTItems.glowironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.glironpickItem.itemID, new ItemStack(GTItems.glowironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.glironshovelItem.itemID, new ItemStack(GTItems.glowironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.glironaxeItem.itemID, new ItemStack(GTItems.glowironNugget), 0.7F);
		GameRegistry.addSmelting(GTItems.glironhoeItem.itemID, new ItemStack(GTItems.glowironNugget), 0.7F);
		
	}
	
	public static String getOmniScepterLine(int ln){
		switch (ln) {
		case 1:
			return GlowTools.isOmniScepterHardMode() ? "AAA" : "FHF";
		case 2:
			return GlowTools.isOmniScepterHardMode() ? "CDE" : "CDE";
		case 3:
			return GlowTools.isOmniScepterHardMode() ? "BBB" : "GHG";
		default:
			return null;
		}
	}
}
