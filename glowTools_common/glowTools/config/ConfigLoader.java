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
		
		/**
		 * Block IDs
		 */
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
		ConfigSettings.blockGlowingWoodID = config.getBlock("Glowing Wood Blocks", 3010).getInt();
		//ConfigSettings.y = config.getBlock("ID", 3011).getInt();
		ConfigSettings.blockFlowStoneID = config.getBlock("Calcite ID", 3012).getInt();
		ConfigSettings.blockDoorDarkID = config.getBlock("Dark Door Block ID", 3013).getInt();
		ConfigSettings.blockGlowstoneInfuserID = config.getBlock("Glowstone Infuser ID", 3014).getInt();
		ConfigSettings.blockGlowstoneInfuserActiveID = config.getBlock("Active Glowstone Infuser ID", 3015).getInt();
		ConfigSettings.oreBlueGlassID = config.getBlock("Glassy Blue Ore ID", 3016).getInt();
		ConfigSettings.blockGlowFarmID = config.getBlock("Enriched Farmland ID", 3017).getInt();
		
		
		/**
		 * Item IDs
		 */
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
		ConfigSettings.craftingItemsID = config.getItem("Generic Crafting Items' ID", 4216).getInt();
		//ConfigSettings.b = config.getItem("ID", 4217).getInt();
		ConfigSettings.itemPorkAppleID = config.getItem("Porkchop with Applesauce ID", 4218).getInt();
		ConfigSettings.itemScepterRegenID = config.getItem("Scepter of Regeneration ID", 4219).getInt();
		//ConfigSettings.c = config.getItem("ID", 4220).getInt();
		ConfigSettings.itemGlironHelmID = config.getItem("Stripey Glowing Iron Helmet ID", 4221).getInt();
		ConfigSettings.itemGlironChestID = config.getItem("Stripey Glowing Iron Chestplate ID", 4222).getInt();
		ConfigSettings.itemGlironLegsID = config.getItem("Stripey Glowing Iron Leggings ID", 4223).getInt();
		ConfigSettings.itemGlironBootsID = config.getItem("Stripey Glowing Iron Boots ID", 4224).getInt();
		ConfigSettings.itemScepterRegen2ID = config.getItem("Scepter of Regeneration Mk. II ID", 4225).getInt();
		//ConfigSettings.d = config.getItem("ID", 4226).getInt();
		//ConfigSettings.e = config.getItem("ID", 4227).getInt();
		//ConfigSettings.f = config.getItem("ID", 4228).getInt();
		//ConfigSettings.g = config.getItem("ID", 4229).getInt();
		ConfigSettings.itemCloakInvisID = config.getItem("Cloak of Invisibility ID", 4230).getInt();
		//ConfigSettings.h = config.getItem("ID", 4231).getInt();
		ConfigSettings.itemScepterOmniID = config.getItem("Omni-Scepter ID", 4232).getInt();
		ConfigSettings.itemDarkDoorID = config.getItem("Dark Door ID", 4233).getInt();
		//ConfigSettings.i = config.getItem("ID", 4234).getInt();
		//ConfigSettings.j = config.getItem("ID", 4235).getInt();
		ConfigSettings.itemBlueFertilizerID = config.getItem("Blue Fertilizer ID", 4236).getInt();
		ConfigSettings.itemScepterInfuseID = config.getItem("Scepter of Infusion ID", 4237).getInt();
		
		
		/**
		 * Achievement IDs
		 */
		ConfigSettings.achievementScepterTipID = config.get("Achievement", "Scepter Tip Achievement ID", 1372).getInt();
		ConfigSettings.achievementLightScepterID = config.get("Achievement", "Light Scepter Achievement ID", 1373).getInt();
		ConfigSettings.achievementRegenScepterID = config.get("Achievement", "Regen Scepter Achievement ID", 1374).getInt();
		ConfigSettings.achievementRegen2ScepterID = config.get("Achievement", "Regen Scepter 2 Achievement ID", 1375).getInt();
		ConfigSettings.achievementOmniScepterID = config.get("Achievement", "Omni-scepter Achievement ID", 1376).getInt();
		ConfigSettings.achievementCloakCoreID = config.get("Achievement", "Cloak Core Achievement ID", 1377).getInt();
		ConfigSettings.achievementCloakInvisID = config.get("Achievement", "Cloak of Invisibility Achievement", 1378).getInt();
		
		
		/**
		 * Hard Mode
		 */
		ConfigSettings.OmniscepterHardMode = config.get("Hard Mode", "Omniscepter Hard Mode", true).getBoolean(true);
		
		
		/**
		 * Durability
		 */
		
		ConfigSettings.itemScepterInfuseDurability = config.get("Durability", "Scepter of Infusion", 32).getInt();
		
		config.save();
	}
}
