/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.config;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		ConfigSettings.blockGlowIronID = config.getBlock("Block of Glowing Iron ID", 3000).getInt();
		ConfigSettings.blockRedIronID = config.getBlock("Block of Red Iron ID", 3001).getInt();
		ConfigSettings.blockGlowSandID = config.getBlock("Glowing Sand ID", 3002).getInt();
		ConfigSettings.oreCandentiniumID = config.getBlock("Candentinium Ore ID", 3003).getInt();
		ConfigSettings.oreCandentiniumGlowingID = config.getBlock("Glowing Candentinium Ore ID", 3004).getInt();
		ConfigSettings.blockGlowGlassID = config.getBlock("Glowing Glass ID", 3005).getInt();
		ConfigSettings.blockGlowingRockID = config.getBlock("Glowing Sandstone/Cobblestone/Stone ID", 3006).getInt();
		ConfigSettings.blockCandentiniumID = config.getBlock("Block of Candentinium ID", 3007).getInt();
		ConfigSettings.blockGlowGrassID = config.getBlock("Glowing Grass ID", 3008).getInt();
		ConfigSettings.blockGlowDirtID = config.getBlock("Glowing Dirt ID", 3009).getInt();
		//ConfigSettings.x = config.getBlock("ID", 3010).getInt();
		//ConfigSettings.x = config.getBlock("ID", 3011).getInt();
		ConfigSettings.blockFlowStoneID = config.getBlock("Calcite ID", 3012).getInt();
		ConfigSettings.blockDoorDarkID = config.getBlock("Dark Door Block ID", 3013).getInt();
		ConfigSettings.blockGlowstoneInfuserID = config.getBlock("Glowstone Infuser ID", 3014).getInt();
		ConfigSettings.blockGlowstoneInfuserActiveID = config.getBlock("Active Glowstone Infuser ID", 3015).getInt();
		ConfigSettings.oreBlueGlassID = config.getBlock("Glassy Blue Ore ID", 3016).getInt();
		ConfigSettings.blockGlowFarmID = config.getBlock("Enriched Farmland ID", 3017).getInt();
		
		ConfigSettings.itemGlowIronID = config.getItem("Glowing Iron Ingot ID", 4200).getInt();
		ConfigSettings.itemGlowMoltID = config.getItem("Melted Glowstone ID", 4201).getInt();
		ConfigSettings.itemRedMoltID = config.getItem("Melted Redstone ID", 4202).getInt();
		ConfigSettings.itemGlowRedID = config.getItem("Blazing Blend ID", 4203).getInt();
		ConfigSettings.itemRedIronID = config.getItem("Red Iron Ingot ID", 4204).getInt();
		ConfigSettings.itemGlironSwordID = config.getItem("Glowing Iron Sword ID", 4205).getInt();
		ConfigSettings.itemGlironPickID = config.getItem("Glowing Iron Pickaxe ID", 4206).getInt();
		ConfigSettings.itemGlironShovelID = config.getItem("Glowing Iron Shovel ID", 4207).getInt();
		ConfigSettings.itemGlironAxeID = config.getItem("Glowing Iron Axe ID", 4208).getInt();
		ConfigSettings.itemGlironHoeID = config.getItem("Glowing Iron Hoe ID", 4209).getInt();
		ConfigSettings.itemRedironSwordID = config.getItem("Red Iron Sword ID", 4210).getInt();
		ConfigSettings.itemRedironPickID = config.getItem("Red Iron Pickaxe ID", 4211).getInt();
		ConfigSettings.itemRedironShovelID = config.getItem("Red Iron Shovel ID", 4212).getInt();
		ConfigSettings.itemRedironAxeID = config.getItem("Red Iron Axe ID", 4213).getInt();
		ConfigSettings.itemRedironHoeID = config.getItem("Red Iron Hoe ID", 4214).getInt();
		ConfigSettings.itemScepterLightID = config.getItem("Scepter of Light ID", 4215).getInt();
		ConfigSettings.itemScepterTipID = config.getItem("Scepter Tip ID", 4216).getInt();
		ConfigSettings.itemRedIronHandleID = config.getItem("Red-Iron-Tool Handle ID", 4217).getInt();
		ConfigSettings.itemPorkAppleID = config.getItem("Porkchop with Applesauce ID", 4218).getInt();
		ConfigSettings.itemScepterRegenID = config.getItem("Scepter of Regeneration ID", 4219).getInt();
		ConfigSettings.gemCandentiniumID = config.getItem("Candentinium Shard ID", 4220).getInt();
		ConfigSettings.itemGlironHelmID = config.getItem("Stripey Glowing Iron Helmet ID", 4221).getInt();
		ConfigSettings.itemGlironChestID = config.getItem("Stripey Glowing Iron Chestplate ID", 4222).getInt();
		ConfigSettings.itemGlironLegsID = config.getItem("Stripey Glowing Iron Leggings ID", 4223).getInt();
		ConfigSettings.itemGlironBootsID = config.getItem("Stripey Glowing Iron Boots ID", 4224).getInt();
		ConfigSettings.itemScepterRegen2ID = config.getItem("Scepter of Regeneration Mk. II ID", 4225).getInt();
		ConfigSettings.nuggetGlowIronID = config.getItem("Glowing Iron Nugget ID", 4226).getInt();
		ConfigSettings.nuggetRedIronID = config.getItem("Red Iron Nugget ID", 4227).getInt();
		ConfigSettings.itemCalcitePureID = config.getItem("Purified Calcite ID", 4228).getInt();
		ConfigSettings.itemCloakCoreID = config.getItem("Cloak Core ID", 4229).getInt();
		ConfigSettings.itemCloakInvisID = config.getItem("Cloak of Invisibility ID", 4230).getInt();
		ConfigSettings.itemLightReflectorID = config.getItem("Light Reflector ID", 4231).getInt();
		ConfigSettings.itemScepterOmniID = config.getItem("Omni-Scepter ID", 4232).getInt();
		ConfigSettings.itemDarkDoorID = config.getItem("Dark Door ID", 4233).getInt();
		ConfigSettings.itemInfernalCoalID = config.getItem("Infernal Coal ID", 4234).getInt();
		ConfigSettings.shardBlueGlassID = config.getItem("Glassy Blue Shard ID", 4235).getInt();
		ConfigSettings.itemBlueFertilizerID = config.getItem("Blue Fertilizer ID", 4236).getInt();
		
		ConfigSettings.OmniscepterHardMode = config.get("Hard Mode", "Omniscepter Hard Mode", true).getBoolean(true);
		
		config.save();
	}
}
