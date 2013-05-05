package glowTools.lang;

import glowTools.blocks.GTBlocks;
import glowTools.items.GTItems;
import glowTools.lib.Reference;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Names {
	public static void load(){
		
		//Blocks
		LanguageRegistry.addName(GTBlocks.glowironBlock, "Block of Glowing Iron");
		LanguageRegistry.addName(GTBlocks.redironBlock, "Block of Red Iron");
		LanguageRegistry.addName(GTBlocks.glowsandBlock, "Glowing Sand");
		LanguageRegistry.addName(GTBlocks.CandentiniumOre, "Candentinium Ore");
		LanguageRegistry.addName(GTBlocks.GlowglassBlock, "Glowing Glass");
		LanguageRegistry.addName(GTBlocks.GlowSandStoneBlock, "Glowing Sandstone");
		LanguageRegistry.addName(GTBlocks.CandentiniumBlock, "Block of Candentinium");
		LanguageRegistry.addName(GTBlocks.GlowGrassBlock, "Glowing Grass Block");
		LanguageRegistry.addName(GTBlocks.GlowDirtBlock, "Glowing Dirt Block");
		LanguageRegistry.addName(GTBlocks.GlowCobbleBlock, "Glowing Cobblestone");
		LanguageRegistry.addName(GTBlocks.GlowingStoneBlock, "Glowing Stone");
		LanguageRegistry.addName(GTBlocks.FlowStoneBlock, "Calcite");
		LanguageRegistry.addName(GTBlocks.DarkDoor, "Dark Door");
		LanguageRegistry.addName(GTBlocks.GlowstoneInfuser, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(GTBlocks.GlowstoneInfuserActive, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(GTBlocks.BlueGlassOre, "Glassy Blue Ore");
		
		
		//Items
		LanguageRegistry.addName(GTItems.glowironItem, "Glowing Iron Ingot");
		LanguageRegistry.addName(GTItems.glowmoltItem, "Melted Glowstone");
		LanguageRegistry.addName(GTItems.redmoltItem, "Melted Redstone");
		LanguageRegistry.addName(GTItems.glowredItem, "Blazing Blend");
		LanguageRegistry.addName(GTItems.redironItem, "Red Iron Ingot");
		LanguageRegistry.addName(GTItems.SceptertipItem, "Scepter Tip");
		LanguageRegistry.addName(GTItems.RedironhandleItem, "Red-Iron-Tool Handle");
		LanguageRegistry.addName(GTItems.PorkappleItem, "Porkchop with Applesauce");
		LanguageRegistry.addName(GTItems.CandentiniumGem, "Candentinium Shard");
		LanguageRegistry.addName(GTItems.glowironNugget, "Glowing Iron Nugget");
		LanguageRegistry.addName(GTItems.redironNugget, "Red Iron Nugget");
		LanguageRegistry.addName(GTItems.pureCalciteItem, "Purified Calcite");
		LanguageRegistry.addName(GTItems.cloakCore, "Cloak Core");
		LanguageRegistry.addName(GTItems.ReflectorItem, "Light Reflector");
		LanguageRegistry.addName(GTItems.DarkDoorItem, "Dark Door");
		LanguageRegistry.addName(GTItems.InfernalCoalItem, "Infernal Coal");
		LanguageRegistry.addName(GTItems.BlueGlassShard, "Glassy Blue Shard");
		LanguageRegistry.addName(GTItems.BlueFertilizerItem, "Blue Fertilizer");
		
		
		//Tools
		LanguageRegistry.addName(GTItems.glironswordItem, "Glowing Iron Sword");
		LanguageRegistry.addName(GTItems.glironpickItem, "Glowing Iron Pickaxe");
		LanguageRegistry.addName(GTItems.glironshovelItem, "Glowing Iron Shovel");
		LanguageRegistry.addName(GTItems.glironaxeItem, "Glowing Iron Axe");
		LanguageRegistry.addName(GTItems.glironhoeItem, "Glowing Iron Hoe");
		
		LanguageRegistry.addName(GTItems.redironswordItem, "Red Iron Sword");
		LanguageRegistry.addName(GTItems.redironpickItem, "Red Iron Pickaxe");
		LanguageRegistry.addName(GTItems.redironshovelItem, "Red Iron Shovel");
		LanguageRegistry.addName(GTItems.redironaxeItem, "Red Iron Axe");
		LanguageRegistry.addName(GTItems.redironhoeItem, "Red Iron Hoe");
		
		
		//Scepters
		LanguageRegistry.addName(GTItems.LightscepterItem, "Scepter of Light");
		LanguageRegistry.addName(GTItems.RegenscepterItem, "Scepter of Regeneration");
		LanguageRegistry.addName(GTItems.Regenscepter2Item, "Scepter of Regeneration Mk. II");
		LanguageRegistry.addName(GTItems.OmniscepterItem, "Omni-Scepter");
		
		
		//Armor
		LanguageRegistry.addName(GTItems.GlironHelm, "Stripey Glowing Iron Helmet");
		LanguageRegistry.addName(GTItems.GlironChest, "Stripey Glowing Iron Chestplate");
		LanguageRegistry.addName(GTItems.GlironLegs, "Stripey Glowing Iron Leggings");
		LanguageRegistry.addName(GTItems.GlironBoots, "Stripey Glowing Iron Boots");
		
		
		//Cloaks
		LanguageRegistry.addName(GTItems.CloakInvis, "Cloak of Invisibility");
		
		
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
