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
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class GTChestLoot {
	
	public static void populate(){
		
		//Dungeons
		DungeonHooks.addDungeonMob("Skidding Glow", 50);
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), 1, 7, 75));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemCloakInvis), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.infernalCoalMetaNumber), 2, 6, 100));
		
		//Blacksmiths
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironBoots), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironChest), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironHelm), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.infernalCoalMetaNumber), 2, 6, 100));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), 1, 5, 95));		
		
		//Mineshafts
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), 1, 7, 90));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemCloakInvis), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemRedironPick), 1, 1, 75));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemScepterLight), 1, 1, 30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironPick), 1, 1, 65));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber), 2, 15, 50));
		
		//Desert Pyramids
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemScepterRegen2), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTBlocks.blockCandentinium), 2, 12, 60));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemScepterOmni), 1, 1, 1));
		
		//Jungle Pyramids
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.pureCalciteMetaNumber), 17, 31, 90));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.cloakCoreMetaNumber), 1, 2, 14));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemDarkDoor), 1, 2, 20));
		
		//Strongholds
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironLegs), 1, 1, 60));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemDarkDoor), 1, 2, 20));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.craftingItems, 1, CraftingItems.blueGlassShardMetaNumber), 3, 7, 80));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironSword), 1, 1, 77));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironLegs), 1, 1, 60));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemDarkDoor), 1, 2, 20));
		
		//Bonus Chest
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(GTItems.itemGlironHoe), 1, 1, 50));
			
	}
	
}
