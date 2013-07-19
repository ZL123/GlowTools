/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.lang;

import glowTools.blocks.BlockGlowingRock;
import glowTools.blocks.BlockGlowingWood;
import glowTools.blocks.GTBlocks;
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;
import glowTools.lib.Reference;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Register {
	
	public static void load() {
		
		//Blocks
		LanguageRegistry.addName(GTBlocks.blockGlowIron, "Block of Glowing Iron");
		LanguageRegistry.addName(GTBlocks.blockRedIron, "Block of Red Iron");
		LanguageRegistry.addName(GTBlocks.blockGlowSand, "Glowing Sand");
		LanguageRegistry.addName(GTBlocks.oreCandentinium, "Candentinium Ore");
		LanguageRegistry.addName(GTBlocks.blockGlowGlass, "Glowing Glass");
		LanguageRegistry.addName(GTBlocks.blockCandentinium, "Block of Candentinium");
		LanguageRegistry.addName(GTBlocks.blockGlowGrass, "Glowing Grass Block");
		LanguageRegistry.addName(GTBlocks.blockGlowDirt, "Glowing Dirt Block");
		LanguageRegistry.addName(GTBlocks.blockFlowStone, "Calcite");
		LanguageRegistry.addName(GTBlocks.blockDoorDark, "Dark Door");
		LanguageRegistry.addName(GTBlocks.blockGlowstoneInfuser, "Glowstone Infuser");
		LanguageRegistry.addName(GTBlocks.blockGlowstoneInfuserActive, "Glowstone Infuser");
		LanguageRegistry.addName(GTBlocks.oreBlueGlass, "Glassy Blue Ore");
		
		
		//Metadata Blocks
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.sandStoneMetaNumber), BlockGlowingRock.BLOCK_NAMES[BlockGlowingRock.sandStoneMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.cobbleMetaNumber), BlockGlowingRock.BLOCK_NAMES[BlockGlowingRock.cobbleMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.stoneMetaNumber), BlockGlowingRock.BLOCK_NAMES[BlockGlowingRock.stoneMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankOakMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.plankOakMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankBirchMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.plankBirchMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankSpruceMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.plankSpruceMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankJungleMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.plankJungleMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logOakMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.logOakMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logBirchMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.logBirchMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logSpruceMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.logSpruceMetaNumber]);
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logJungleMetaNumber), BlockGlowingWood.BLOCK_NAMES[BlockGlowingWood.logJungleMetaNumber]);
		
		
		//Items
		LanguageRegistry.addName(GTItems.itemPorkApple, "Porkchop with Applesauce");
		LanguageRegistry.addName(GTItems.itemDarkDoor, "Dark Door");
		LanguageRegistry.addName(GTItems.itemBlueFertilizer, "Glassy Blue Shard");
		
		
		//Metadata Items
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), "Glowing Iron Ingot");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronMetaNumber), "Red Iron Ingot");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowMoltMetaNumber), "Melted Glowstone");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redMoltMetaNumber), "Melted Redstone");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.blazeMoltMetaNumber), "Blazing Blend");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber), "Scepter Tip");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.redIronHandleMetaNumber), "Red-Iron-Tool Handle");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.candentiniumMetaNumber), "Shard of Candentinium");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetGlowIronMetaNumber), "Glowing Iron Nugget");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.nuggetRedIronMetaNumber), "Red Iron Nugget");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.pureCalciteMetaNumber), "Purified Calcite");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.cloakCoreMetaNumber), "Cloak Core");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.lightReflectorMetaNumber), "Light Reflector");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.infernalCoalMetaNumber), "Infernal Coal");
		LanguageRegistry.addName(new ItemStack(GTItems.craftingItems, 1, CraftingItems.blueGlassShardMetaNumber), "Glassy Blue Shard");
		
		
		//Tools
		LanguageRegistry.addName(GTItems.itemGlironSword, "Glowing Iron Sword");
		LanguageRegistry.addName(GTItems.itemGlironPick, "Glowing Iron Pickaxe");
		LanguageRegistry.addName(GTItems.itemGlironShovel, "Glowing Iron Shovel");
		LanguageRegistry.addName(GTItems.itemGlironAxe, "Glowing Iron Axe");
		LanguageRegistry.addName(GTItems.itemGlironHoe, "Glowing Iron Hoe");
		
		LanguageRegistry.addName(GTItems.itemRedironSword, "Red Iron Sword");
		LanguageRegistry.addName(GTItems.itemRedironPick, "Red Iron Pickaxe");
		LanguageRegistry.addName(GTItems.itemRedironShovel, "Red Iron Shovel");
		LanguageRegistry.addName(GTItems.itemRedironAxe, "Red Iron Axe");
		LanguageRegistry.addName(GTItems.itemRedironHoe, "Red Iron Hoe");
		
		
		//Scepters
		LanguageRegistry.addName(GTItems.itemScepterLight, "Scepter of Light");
		LanguageRegistry.addName(GTItems.itemScepterRegen, "Scepter of Regeneration");
		LanguageRegistry.addName(GTItems.itemScepterRegen2, "Scepter of Regeneration Mk. II");
		LanguageRegistry.addName(GTItems.itemScepterOmni, "Omni-Scepter");
		LanguageRegistry.addName(GTItems.itemScepterInfuse, "Scepter of Infusion");
		
		
		//Armor
		LanguageRegistry.addName(GTItems.itemGlironHelm, "Stripey Glowing Iron Helmet");
		LanguageRegistry.addName(GTItems.itemGlironChest, "Stripey Glowing Iron Chestplate");
		LanguageRegistry.addName(GTItems.itemGlironLegs, "Stripey Glowing Iron Leggings");
		LanguageRegistry.addName(GTItems.itemGlironBoots, "Stripey Glowing Iron Boots");
		
		
		//Cloaks
		LanguageRegistry.addName(GTItems.itemCloakInvis, "Cloak of Invisibility");
		
		
		//Other
		LanguageRegistry.instance().addStringLocalization("entity." + Reference.MODID + ".Skidglow.name", "Skidding Glow");
        LanguageRegistry.instance().addStringLocalization("itemGroup.glowTools", "GlowTools");
        LanguageRegistry.instance().addStringLocalization("item.glironshovelItem.name", "en_GB", "Glowing Iron Spade");
        LanguageRegistry.instance().addStringLocalization("item.redironshovelItem.name", "en_GB", "Red Iron Spade");
        LanguageRegistry.instance().addStringLocalization("item.LightscepterItem.name", "en_GB", "Sceptre of Light");
        LanguageRegistry.instance().addStringLocalization("item.RegenscepterItem.name", "en_GB", "Sceptre of Regeneration");       
        LanguageRegistry.instance().addStringLocalization("item.Regenscepter2Item.name", "en_GB", "Sceptre of Regeneration Mk. II");
        LanguageRegistry.instance().addStringLocalization("item.OmniscepterItem.name", "en_GB", "Omni-Sceptre");
        
	}
}
