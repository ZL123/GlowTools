package glowTools;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		GlowTools.glowironBlockID = config.getBlock("Block of Glowing Iron ID", 3000).getInt();
		GlowTools.redironBlockID = config.getBlock("Block of Red Iron ID", 3001).getInt();
		GlowTools.glowsandBlockID = config.getBlock("Glowing Sand ID", 3002).getInt();
		GlowTools.CandentiniumOreID = config.getBlock("Candentinium Ore ID", 3003).getInt();
		GlowTools.CandentiniumOreGlowingID = config.getBlock("Glowing Candentinium Ore ID", 3004).getInt();
		GlowTools.GlowglassBlockID = config.getBlock("Glowing Glass ID", 3005).getInt();
		GlowTools.GlowSandStoneBlockID = config.getBlock("Glowing Sandstone ID", 3006).getInt();
		GlowTools.CandentiniumBlockID = config.getBlock("Block of Candentinium ID", 3007).getInt();
		GlowTools.GlowGrassBlockID = config.getBlock("Glowing Grass ID", 3008).getInt();
		GlowTools.GlowDirtBlockID = config.getBlock("Glowing Dirt ID", 3009).getInt();
		GlowTools.GlowCobbleBlockID = config.getBlock("Glowing Cobblestone ID", 3010).getInt();
		GlowTools.GlowingStoneBlockID = config.getBlock("Glowing Stone ID", 3011).getInt();
		GlowTools.FlowStoneBlockID = config.getBlock("Calcite ID", 3012).getInt();
		GlowTools.DarkDoorID = config.getBlock("Dark Door Block ID", 3013).getInt();
		GlowTools.GlowstoneInfuserID = config.getBlock("Glowstone Infuser ID", 3014).getInt();
		GlowTools.GlowstoneInfuserActiveID = config.getBlock("Active Glowstone Infuser ID", 3015).getInt();
		GlowTools.BlueGlassOreID = config.getBlock("Glassy Blue Ore ID", 3016).getInt();
		GlowTools.GlowFarmlandID = config.getBlock("Enriched Farmland ID", 3017).getInt();
		
		GlowTools.glowironItemID = config.getItem("Glowing Iron Ingot ID", 4200).getInt();
		GlowTools.glowmoltItemID = config.getItem("Melted Glowstone ID", 4201).getInt();
		GlowTools.redmoltItemID = config.getItem("Melted Redstone ID", 4202).getInt();
		GlowTools.glowredItemID = config.getItem("Blazing Blend ID", 4203).getInt();
		GlowTools.redironItemID = config.getItem("Red Iron Ingot ID", 4204).getInt();
		GlowTools.glironswordItemID = config.getItem("Glowing Iron Sword ID", 4205).getInt();
		GlowTools.glironpickItemID = config.getItem("Glowing Iron Pickaxe ID", 4206).getInt();
		GlowTools.glironshovelItemID = config.getItem("Glowing Iron Shovel ID", 4207).getInt();
		GlowTools.glironaxeItemID = config.getItem("Glowing Iron Axe ID", 4208).getInt();
		GlowTools.glironhoeItemID = config.getItem("Glowing Iron Hoe ID", 4209).getInt();
		GlowTools.redironswordItemID = config.getItem("Red Iron Sword ID", 4210).getInt();
		GlowTools.redironpickItemID = config.getItem("Red Iron Pickaxe ID", 4211).getInt();
		GlowTools.redironshovelItemID = config.getItem("Red Iron Shovel ID", 4212).getInt();
		GlowTools.redironaxeItemID = config.getItem("Red Iron Axe ID", 4213).getInt();
		GlowTools.redironhoeItemID = config.getItem("Red Iron Hoe ID", 4214).getInt();
		GlowTools.LightscepterItemID = config.getItem("Scepter of Light ID", 4215).getInt();
		GlowTools.SceptertipItemID = config.getItem("Scepter Tip ID", 4216).getInt();
		GlowTools.RedironhandleItemID = config.getItem("Red-Iron-Tool Handle ID", 4217).getInt();
		GlowTools.PorkappleItemID = config.getItem("Porkchop with Applesauce ID", 4218).getInt();
		GlowTools.RegenscepterItemID = config.getItem("Scepter of Regeneration ID", 4219).getInt();
		GlowTools.CandentiniumGemID = config.getItem("Candentinium Shard ID", 4220).getInt();
		GlowTools.GlironHelmID = config.getItem("Stripey Glowing Iron Helmet ID", 4221).getInt();
		GlowTools.GlironChestID = config.getItem("Stripey Glowing Iron Chestplate ID", 4222).getInt();
		GlowTools.GlironLegsID = config.getItem("Stripey Glowing Iron Leggings ID", 4223).getInt();
		GlowTools.GlironBootsID = config.getItem("Stripey Glowing Iron Boots ID", 4224).getInt();
		GlowTools.Regenscepter2ItemID = config.getItem("Scepter of Regeneration Mk. II ID", 4225).getInt();
		GlowTools.glowironNuggetID = config.getItem("Glowing Iron Nugget ID", 4226).getInt();
		GlowTools.redironNuggetID = config.getItem("Red Iron Nugget ID", 4227).getInt();
		GlowTools.pureCalciteItemID = config.getItem("Purified Calcite ID", 4228).getInt();
		GlowTools.cloakCoreID = config.getItem("Cloak Core ID", 4229).getInt();
		GlowTools.CloakInvisID = config.getItem("Cloak of Invisibility ID", 4230).getInt();
		GlowTools.ReflectorItemID = config.getItem("Light Reflector ID", 4231).getInt();
		GlowTools.OmniscepterItemID = config.getItem("Omni-Scepter ID", 4232).getInt();
		GlowTools.DarkDoorItemID = config.getItem("Dark Door ID", 4233).getInt();
		GlowTools.InfernalCoalItemID = config.getItem("Infernal Coal ID", 4234).getInt();
		GlowTools.BlueGlassShardID = config.getItem("Glassy Blue Shard ID", 4235).getInt();
		GlowTools.BlueFertilizerItemID = config.getItem("Blue Fertilizer ID", 4236).getInt();
		
		GlowTools.OmniscepterHardMode = config.get("Hard Mode", "Omniscepter Hard Mode", true).getBoolean(true);
		
		config.save();
	}
}
