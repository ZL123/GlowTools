package glowTools.lang;

import glowTools.blocks.BlockGlowingRock;
import glowTools.blocks.GTBlocks;
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
		LanguageRegistry.addName(GTBlocks.blockGlowstoneInfuser, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(GTBlocks.blockGlowstoneInfuserActive, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(GTBlocks.oreBlueGlass, "Glassy Blue Ore");
		
		
		//Metadata Blocks
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.sandStoneMetaNumber), "Glowing Sandstone");
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.cobbleMetaNumber), "Glowing Cobblestone");
		LanguageRegistry.addName(new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.stoneMetaNumber), "Glowing Stone");
		
		
		//Items
		LanguageRegistry.addName(GTItems.itemGlowIron, "Glowing Iron Ingot");
		LanguageRegistry.addName(GTItems.itemGlowMolt, "Melted Glowstone");
		LanguageRegistry.addName(GTItems.itemRedMolt, "Melted Redstone");
		LanguageRegistry.addName(GTItems.itemGlowRed, "Blazing Blend");
		LanguageRegistry.addName(GTItems.itemRedIron, "Red Iron Ingot");
		LanguageRegistry.addName(GTItems.itemScepterTip, "Scepter Tip");
		LanguageRegistry.addName(GTItems.itemRedIronHandle, "Red-Iron-Tool Handle");
		LanguageRegistry.addName(GTItems.itemPorkApple, "Porkchop with Applesauce");
		LanguageRegistry.addName(GTItems.gemCandentinium, "Candentinium Shard");
		LanguageRegistry.addName(GTItems.nuggetGlowIron, "Glowing Iron Nugget");
		LanguageRegistry.addName(GTItems.nuggetRedIron, "Red Iron Nugget");
		LanguageRegistry.addName(GTItems.itemCalcitePure, "Purified Calcite");
		LanguageRegistry.addName(GTItems.itemCloakCore, "Cloak Core");
		LanguageRegistry.addName(GTItems.itemLightReflector, "Light Reflector");
		LanguageRegistry.addName(GTItems.itemDarkDoor, "Dark Door");
		LanguageRegistry.addName(GTItems.itemInfernalCoal, "Infernal Coal");
		LanguageRegistry.addName(GTItems.shardBlueGlass, "Glassy Blue Shard");
		LanguageRegistry.addName(GTItems.itemBlueFertilizer, "Blue Fertilizer");
		
		
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
