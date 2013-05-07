/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.recipe;

import glowTools.GlowTools;
import glowTools.blocks.GTBlocks;
import glowTools.items.GTItems;
import glowTools.lib.Reference;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTRecipes {
	
	public static void recipes(){
		
        FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Recipes...", "");
        
		//General Items/Blocks
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowIron, 2), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.itemGlowIron});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlowIron, 4), new Object[]{"X", 'X', GTBlocks.blockGlowIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemGlowIron), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.itemGlowMolt)});
		GameRegistry.addSmelting(Item.lightStoneDust.itemID, new ItemStack(GTItems.itemGlowMolt, 1), 0.4F);
		GameRegistry.addSmelting(Item.redstone.itemID, new ItemStack(GTItems.itemRedMolt, 1), 0.4F);
		GameRegistry.addRecipe(new ItemStack(Item.expBottle, 3), new Object[]{"XZY", "XZY", "XZY", 'X', GTItems.itemGlowMolt, 'Y', GTItems.itemRedMolt, 'Z', new ItemStack(Item.glassBottle)});
		GameRegistry.addSmelting(Item.expBottle.itemID, new ItemStack(Item.expBottle, 1), 0.7F);	
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockRedIron, 2), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.itemRedIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemGlowRed, 3), new Object[]{new ItemStack(GTItems.itemGlowMolt), new ItemStack(GTItems.itemRedMolt), new ItemStack(Item.blazePowder)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemRedIron), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.itemRedMolt)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedIron, 4), new Object[]{"X", 'X', GTBlocks.blockRedIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemRedIronHandle), new Object[]{new ItemStack(GTItems.itemGlowRed), new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemPorkApple, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Item.porkCooked), 'Y', new ItemStack(Item.appleRed)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowSand, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sand), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.oreCandentinium.blockID, new ItemStack(GTItems.gemCandentinium), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowGlass, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.glass), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.blockGlowSand.blockID, new ItemStack(GTBlocks.blockGlowGlass), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowSandstone), new Object[]{"XX", "XX", 'X', GTBlocks.blockGlowSand});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowSandstone, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sandStone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", 'X', new ItemStack(GTBlocks.blockGlowSandstone)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockCandentinium), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.gemCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowDirt, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.dirt), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowCobble, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.cobblestone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowingStone, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.stone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GTBlocks.blockGlowCobble.blockID, new ItemStack(GTBlocks.blockGlowingStone), 0.2F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlowIron), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.nuggetGlowIron});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedIron), new Object[]{"XXX", "XXX", "XXX", 'X', GTItems.nuggetRedIron});
		GameRegistry.addRecipe(new ItemStack(GTItems.nuggetGlowIron, 9), new Object[]{"X", 'X', GTItems.itemGlowIron});
		GameRegistry.addRecipe(new ItemStack(GTItems.nuggetRedIron, 9), new Object[]{"X", 'X', GTItems.itemRedIron});
		GameRegistry.addSmelting(GTBlocks.blockFlowStone.blockID, new ItemStack(GTItems.itemCalcitePure), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemCloakCore), new Object[]{"XYX", "YZY", "XYX", 'X', new ItemStack(Block.cloth), 'Y', new ItemStack(Item.diamond), 'Z', GTBlocks.blockCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemLightReflector), new Object[]{"XYX", "XZX", "XYX", 'X', GTItems.itemCalcitePure, 'Y', GTItems.gemCandentinium, 'Z', new ItemStack(Item.diamond)});
		GameRegistry.addSmelting(GTBlocks.blockCandentinium.blockID, new ItemStack(GTItems.gemCandentinium, 9), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemDarkDoor), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.obsidian), 'Y', new ItemStack(Item.doorIron)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemInfernalCoal, 4), new Object[]{new ItemStack(GTItems.itemGlowRed), new ItemStack(Item.coal)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemInfernalCoal, 4), new Object[]{new ItemStack(GTItems.itemGlowMolt), new ItemStack(GTItems.itemRedMolt), new ItemStack(Item.blazePowder), new ItemStack(Item.coal)});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.blockGlowIron});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.blockRedIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemBlueFertilizer, 2), new Object[]{new ItemStack(GTItems.shardBlueGlass), new ItemStack(Item.bucketWater)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterTip), new Object[]{" X ", "XYX", " X ", 'X', Item.diamond, 'Y', new ItemStack(Item.dyePowder, 1, 4)});
		
		//Armor
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironHelm), new Object[]{"XYX", "X X", 'X', GTItems.itemGlowIron, 'Y', GTItems.gemCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironChest), new Object[]{"X X", "YXY", "XXX", 'X', GTItems.itemGlowIron, 'Y', GTItems.gemCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironLegs), new Object[]{"XXX", "Y Y", "X X", 'X', GTItems.itemGlowIron, 'Y', GTItems.gemCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironBoots), new Object[]{"X X", "X X", 'X', GTItems.itemGlowIron});
		GameRegistry.addSmelting(GTItems.itemGlironHelm.itemID, new ItemStack(GTItems.itemGlowIron, 2), 0.2F);
		GameRegistry.addSmelting(GTItems.itemGlironChest.itemID, new ItemStack(GTItems.itemGlowIron, 4), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironLegs.itemID, new ItemStack(GTItems.itemGlowIron, 3), 0.6F);
		GameRegistry.addSmelting(GTItems.itemGlironBoots.itemID, new ItemStack(GTItems.itemGlowIron, 2), 0.2F);
		
		//Scepters
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterLight, 1), new Object[]{"TPT", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.goldenCarrot), 'S', new ItemStack(GTItems.itemGlowRed), 'P', new ItemStack(GTItems.itemScepterTip), 'T', new ItemStack(GTItems.itemGlowMolt)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterRegen, 1), new Object[]{"TPU", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.ghastTear), 'S', new ItemStack(GTItems.itemGlowRed), 'P', new ItemStack(GTItems.itemScepterTip), 'T', new ItemStack(Item.plateDiamond),
			'U', new ItemStack(Item.appleGold, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterRegen2), new Object[]{"PQP", "RSR", "PQP", 'P', new ItemStack(Item.diamond), 'Q',
			new ItemStack(GTItems.gemCandentinium), 'R', new ItemStack(Block.blockGold), 'S', new ItemStack(GTItems.itemScepterRegen)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterOmni), new Object[]{getOmniScepterLine(1), getOmniScepterLine(2), getOmniScepterLine(3), 'A', new ItemStack(Block.blockDiamond), 'B',
			new ItemStack(Block.blockEmerald), 'C', new ItemStack(GTItems.itemScepterLight), 'D', new ItemStack(GTItems.itemCloakInvis), 'E', new ItemStack(GTItems.itemScepterRegen2), 'F', new ItemStack(Item.diamond),
			'G', new ItemStack(Item.emerald), 'H', new ItemStack(GTItems.gemCandentinium)});
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironSword), new Object[]{" X ", " X ", " Y ", 'X', GTItems.itemRedIron, 'Y', GTItems.itemRedIronHandle});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironPick), new Object[]{"XXX", " Y ", " Y ", 'X', GTItems.itemRedIron, 'Y', GTItems.itemRedIronHandle});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironShovel), new Object[]{" X ", " Y ", " Y ", 'X', GTItems.itemRedIron, 'Y', GTItems.itemRedIronHandle});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironAxe), new Object[]{"XX ", "XY ", " Y ", 'X', GTItems.itemRedIron, 'Y', GTItems.itemRedIronHandle});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironHoe), new Object[]{"XX ", " Y ", " Y ", 'X', GTItems.itemRedIron, 'Y', GTItems.itemRedIronHandle});
		GameRegistry.addSmelting(GTItems.itemRedironSword.itemID, new ItemStack(GTItems.nuggetRedIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironPick.itemID, new ItemStack(GTItems.nuggetRedIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironShovel.itemID, new ItemStack(GTItems.nuggetRedIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironAxe.itemID, new ItemStack(GTItems.nuggetRedIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironHoe.itemID, new ItemStack(GTItems.nuggetRedIron), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironSword), new Object[]{" X ", " X ", " Y ", 'X', GTItems.itemGlowIron, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironPick), new Object[]{"XXX", " Y ", " Y ", 'X', GTItems.itemGlowIron, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironShovel), new Object[]{" X ", " Y ", " Y ", 'X', GTItems.itemGlowIron, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironAxe), new Object[]{"XX ", "XY ", " Y ", 'X', GTItems.itemGlowIron, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironHoe), new Object[]{"XX ", " Y ", " Y ", 'X', GTItems.itemGlowIron, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addSmelting(GTItems.itemGlironSword.itemID, new ItemStack(GTItems.nuggetGlowIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironPick.itemID, new ItemStack(GTItems.nuggetGlowIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironShovel.itemID, new ItemStack(GTItems.nuggetGlowIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironAxe.itemID, new ItemStack(GTItems.nuggetGlowIron), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironHoe.itemID, new ItemStack(GTItems.nuggetGlowIron), 0.7F);
		
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
