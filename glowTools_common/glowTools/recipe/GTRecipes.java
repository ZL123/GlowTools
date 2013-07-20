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
import glowTools.blocks.BlockGlowingRock;
import glowTools.blocks.GTBlocks;
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;
import glowTools.lib.Reference;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTRecipes {
	
	public static void recipes(){
		
        FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Recipes...", "");
        
		//General Items/Blocks
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowIron, 2), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 4, CraftingItems.glowingIronMetaNumber), new Object[]{"X", 'X', GTBlocks.blockGlowIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber)});
		GameRegistry.addSmelting(Item.lightStoneDust.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), 0.4F);
		GameRegistry.addSmelting(Item.redstone.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), 0.4F);
		GameRegistry.addRecipe(new ItemStack(Item.expBottle, 3), new Object[]{"XZY", "XZY", "XZY", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), 'Z', new ItemStack(Item.glassBottle)});
		GameRegistry.addSmelting(Item.expBottle.itemID, new ItemStack(Item.expBottle, 1), 0.7F);	
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockRedIron, 2), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 3, CraftingItems.blazeMoltMetaNumber), new Object[]{new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), new ItemStack(Item.blazePowder)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 4, CraftingItems.redIronMetaNumber), new Object[]{"X", 'X', GTBlocks.blockRedIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber), new Object[]{new ItemStack(GTItems.craftingItems, 1, CraftingItems.blazeMoltMetaNumber), new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemPorkApple, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Item.porkCooked), 'Y', new ItemStack(Item.appleRed)});
		GameRegistry.addSmelting(GTBlocks.oreCandentinium.blockID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", 'X', new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.sandStoneMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockCandentinium), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 9, CraftingItems.nuggetGlowIronMetaNumber), new Object[]{"X", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 9, CraftingItems.nuggetRedIronMetaNumber), new Object[]{"X", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber)});
		GameRegistry.addSmelting(GTBlocks.blockFlowStone.blockID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.pureCalciteMetaNumber), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.cloakCoreMetaNumber), new Object[]{"XYX", "YZY", "XYX", 'X', new ItemStack(Block.cloth), 'Y', new ItemStack(Item.diamond), 'Z', GTBlocks.blockCandentinium});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.lightReflectorMetaNumber), new Object[]{"XYX", "XZX", "XYX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.pureCalciteMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), 'Z', new ItemStack(Item.diamond)});
		GameRegistry.addSmelting(GTBlocks.blockCandentinium.blockID, new ItemStack(GTItems.craftingItems, 9, CraftingItems.candentiniumMetaNumber), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemDarkDoor), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.obsidian), 'Y', new ItemStack(Item.doorIron)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 4, CraftingItems.infernalCoalMetaNumber), new Object[]{new ItemStack(GTItems.craftingItems, 1, CraftingItems.blazeMoltMetaNumber), new ItemStack(Item.coal)});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.craftingItems, 4, CraftingItems.infernalCoalMetaNumber), new Object[]{new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), new ItemStack(Item.blazePowder), new ItemStack(Item.coal)});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.blockGlowIron});
		GameRegistry.addRecipe(new ItemStack(Block.blockIron), new Object[]{"X", 'X', GTBlocks.blockRedIron});
		GameRegistry.addShapelessRecipe(new ItemStack(GTItems.itemBlueFertilizer, 2), new Object[]{new ItemStack(GTItems.craftingItems, 1, CraftingItems.blueGlassShardMetaNumber), new ItemStack(Item.bucketWater)});
		GameRegistry.addRecipe(new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber), new Object[]{" X ", "XYX", " X ", 'X', Item.diamond, 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.slowSand, 4), new Object[]{new ItemStack(Block.sand), new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), new ItemStack(Item.bucketLava)});
		GameRegistry.addRecipe(new ItemStack(GTBlocks.blockGlowstoneInfuser), new Object[]{"XXX", "YZY", "XXX", Character.valueOf('X'), Block.glowStone, Character.valueOf('Y'), new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), Character.valueOf('Z'), new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber)});
		
		//Armor
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironHelm), new Object[]{"XYX", "X X", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironChest), new Object[]{"X X", "YXY", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironLegs), new Object[]{"XXX", "Y Y", "X X", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironBoots), new Object[]{"X X", "X X", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber)});
		GameRegistry.addSmelting(GTItems.itemGlironHelm.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 0.2F);
		GameRegistry.addSmelting(GTItems.itemGlironChest.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironLegs.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 0.6F);
		GameRegistry.addSmelting(GTItems.itemGlironBoots.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 0.2F);
		
		//Scepters
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterLight, 1), new Object[]{"TPT", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.goldenCarrot), 'S', new ItemStack(GTItems.craftingItems, 1, CraftingItems.blazeMoltMetaNumber), 'P', new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber), 'T', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterRegen, 1), new Object[]{"TPU", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.ghastTear), 'S', new ItemStack(GTItems.craftingItems, 1, CraftingItems.blazeMoltMetaNumber), 'P', new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber), 'T', new ItemStack(Item.plateDiamond),
			'U', new ItemStack(Item.appleGold, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterRegen2), new Object[]{"PQP", "RSR", "PQP", 'P', new ItemStack(Item.diamond), 'Q',
			new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), 'R', new ItemStack(Block.blockGold), 'S', new ItemStack(GTItems.itemScepterRegen)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterOmni), new Object[]{getOmniScepterLine(1), getOmniScepterLine(2), getOmniScepterLine(3), 'A', new ItemStack(Block.blockDiamond), 'B',
			new ItemStack(Block.blockEmerald), 'C', new ItemStack(GTItems.itemScepterLight), 'D', new ItemStack(GTItems.itemCloakInvis), 'E', new ItemStack(GTItems.itemScepterRegen2), 'F', new ItemStack(Item.diamond),
			'G', new ItemStack(Item.emerald), 'H', new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemScepterInfuse), new Object[]{" T ", " R ", "BIB", Character.valueOf('T'), new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber), Character.valueOf('R'), Item.blazeRod, Character.valueOf('B'),
			new ItemStack(GTItems.craftingItems.itemID, 1, CraftingItems.blazeMoltMetaNumber), Character.valueOf('I'), GTBlocks.blockGlowstoneInfuser});
		
		//Cloaks
		GameRegistry.addRecipe(new ItemStack(GTItems.itemCloakInvis), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.lightReflectorMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.cloakCoreMetaNumber)});
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironSword), new Object[]{" X ", " X ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironPick), new Object[]{"XXX", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironShovel), new Object[]{" X ", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironAxe), new Object[]{"XX ", "XY ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemRedironHoe), new Object[]{"XX ", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), 'Y', new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber)});
		GameRegistry.addSmelting(GTItems.itemRedironSword.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironPick.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironShovel.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironAxe.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemRedironHoe.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironSword), new Object[]{" X ", " X ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironPick), new Object[]{"XXX", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironShovel), new Object[]{" X ", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironAxe), new Object[]{"XX ", "XY ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(GTItems.itemGlironHoe), new Object[]{"XX ", " Y ", " Y ", 'X', new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addSmelting(GTItems.itemGlironSword.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironPick.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironShovel.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironAxe.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), 0.7F);
		GameRegistry.addSmelting(GTItems.itemGlironHoe.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), 0.7F);
		
	}
	
	/**
	 * Gets a line from the Omniscepter crafting recipe.
	 */
	
	/* 'A' = Block of Diamond
	 * 'B' = Block of Emerald
	 * 'C' = Scepter of Light
	 * 'D' = Cloak of Invisibility
	 * 'E' = Scepter of Regeneration Mk. II
	 * 'F' = Diamond
	 * 'G' = Emerald
	 * 'H' = Candentinium Shard
	 */
	public static String getOmniScepterLine(int ln) {
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
