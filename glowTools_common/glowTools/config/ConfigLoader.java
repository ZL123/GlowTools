package glowTools.config;

import glowTools.GlowTools;
import glowTools.blocks.GTBlocks;
import glowTools.items.GTItems;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		ConfigSettings.glowironBlockID = config.getBlock("Block of Glowing Iron ID", 3000).getInt();
		ConfigSettings.redironBlockID = config.getBlock("Block of Red Iron ID", 3001).getInt();
		ConfigSettings.glowsandBlockID = config.getBlock("Glowing Sand ID", 3002).getInt();
		ConfigSettings.CandentiniumOreID = config.getBlock("Candentinium Ore ID", 3003).getInt();
		ConfigSettings.CandentiniumOreGlowingID = config.getBlock("Glowing Candentinium Ore ID", 3004).getInt();
		ConfigSettings.GlowglassBlockID = config.getBlock("Glowing Glass ID", 3005).getInt();
		ConfigSettings.GlowSandStoneBlockID = config.getBlock("Glowing Sandstone ID", 3006).getInt();
		ConfigSettings.CandentiniumBlockID = config.getBlock("Block of Candentinium ID", 3007).getInt();
		ConfigSettings.GlowGrassBlockID = config.getBlock("Glowing Grass ID", 3008).getInt();
		ConfigSettings.GlowDirtBlockID = config.getBlock("Glowing Dirt ID", 3009).getInt();
		ConfigSettings.GlowCobbleBlockID = config.getBlock("Glowing Cobblestone ID", 3010).getInt();
		ConfigSettings.GlowingStoneBlockID = config.getBlock("Glowing Stone ID", 3011).getInt();
		ConfigSettings.FlowStoneBlockID = config.getBlock("Calcite ID", 3012).getInt();
		ConfigSettings.DarkDoorID = config.getBlock("Dark Door Block ID", 3013).getInt();
		ConfigSettings.GlowstoneInfuserID = config.getBlock("Glowstone Infuser ID", 3014).getInt();
		ConfigSettings.GlowstoneInfuserActiveID = config.getBlock("Active Glowstone Infuser ID", 3015).getInt();
		ConfigSettings.BlueGlassOreID = config.getBlock("Glassy Blue Ore ID", 3016).getInt();
		ConfigSettings.GlowFarmlandID = config.getBlock("Enriched Farmland ID", 3017).getInt();
		
		ConfigSettings.glowironItemID = config.getItem("Glowing Iron Ingot ID", 4200).getInt();
		ConfigSettings.glowmoltItemID = config.getItem("Melted Glowstone ID", 4201).getInt();
		ConfigSettings.redmoltItemID = config.getItem("Melted Redstone ID", 4202).getInt();
		ConfigSettings.glowredItemID = config.getItem("Blazing Blend ID", 4203).getInt();
		ConfigSettings.redironItemID = config.getItem("Red Iron Ingot ID", 4204).getInt();
		ConfigSettings.glironswordItemID = config.getItem("Glowing Iron Sword ID", 4205).getInt();
		ConfigSettings.glironpickItemID = config.getItem("Glowing Iron Pickaxe ID", 4206).getInt();
		ConfigSettings.glironshovelItemID = config.getItem("Glowing Iron Shovel ID", 4207).getInt();
		ConfigSettings.glironaxeItemID = config.getItem("Glowing Iron Axe ID", 4208).getInt();
		ConfigSettings.glironhoeItemID = config.getItem("Glowing Iron Hoe ID", 4209).getInt();
		ConfigSettings.redironswordItemID = config.getItem("Red Iron Sword ID", 4210).getInt();
		ConfigSettings.redironpickItemID = config.getItem("Red Iron Pickaxe ID", 4211).getInt();
		ConfigSettings.redironshovelItemID = config.getItem("Red Iron Shovel ID", 4212).getInt();
		ConfigSettings.redironaxeItemID = config.getItem("Red Iron Axe ID", 4213).getInt();
		ConfigSettings.redironhoeItemID = config.getItem("Red Iron Hoe ID", 4214).getInt();
		ConfigSettings.LightscepterItemID = config.getItem("Scepter of Light ID", 4215).getInt();
		ConfigSettings.SceptertipItemID = config.getItem("Scepter Tip ID", 4216).getInt();
		ConfigSettings.RedironhandleItemID = config.getItem("Red-Iron-Tool Handle ID", 4217).getInt();
		ConfigSettings.PorkappleItemID = config.getItem("Porkchop with Applesauce ID", 4218).getInt();
		ConfigSettings.RegenscepterItemID = config.getItem("Scepter of Regeneration ID", 4219).getInt();
		ConfigSettings.CandentiniumGemID = config.getItem("Candentinium Shard ID", 4220).getInt();
		ConfigSettings.GlironHelmID = config.getItem("Stripey Glowing Iron Helmet ID", 4221).getInt();
		ConfigSettings.GlironChestID = config.getItem("Stripey Glowing Iron Chestplate ID", 4222).getInt();
		ConfigSettings.GlironLegsID = config.getItem("Stripey Glowing Iron Leggings ID", 4223).getInt();
		ConfigSettings.GlironBootsID = config.getItem("Stripey Glowing Iron Boots ID", 4224).getInt();
		ConfigSettings.Regenscepter2ItemID = config.getItem("Scepter of Regeneration Mk. II ID", 4225).getInt();
		ConfigSettings.glowironNuggetID = config.getItem("Glowing Iron Nugget ID", 4226).getInt();
		ConfigSettings.redironNuggetID = config.getItem("Red Iron Nugget ID", 4227).getInt();
		ConfigSettings.pureCalciteItemID = config.getItem("Purified Calcite ID", 4228).getInt();
		ConfigSettings.cloakCoreID = config.getItem("Cloak Core ID", 4229).getInt();
		ConfigSettings.CloakInvisID = config.getItem("Cloak of Invisibility ID", 4230).getInt();
		ConfigSettings.ReflectorItemID = config.getItem("Light Reflector ID", 4231).getInt();
		ConfigSettings.OmniscepterItemID = config.getItem("Omni-Scepter ID", 4232).getInt();
		ConfigSettings.DarkDoorItemID = config.getItem("Dark Door ID", 4233).getInt();
		ConfigSettings.InfernalCoalItemID = config.getItem("Infernal Coal ID", 4234).getInt();
		ConfigSettings.BlueGlassShardID = config.getItem("Glassy Blue Shard ID", 4235).getInt();
		ConfigSettings.BlueFertilizerItemID = config.getItem("Blue Fertilizer ID", 4236).getInt();
		
		ConfigSettings.OmniscepterHardMode = config.get("Hard Mode", "Omniscepter Hard Mode", true).getBoolean(true);
		
		config.save();
	}
}
