package glowTools;

import glowTools.blocks.BlockBlueGlassOre;
import glowTools.blocks.BlockCandentiniumOre;
import glowTools.blocks.BlockDarkDoor;
import glowTools.blocks.BlockFlowStoneBlock;
import glowTools.blocks.BlockGlowCobbleBlock;
import glowTools.blocks.BlockGlowDirtBlock;
import glowTools.blocks.BlockGlowFarmland;
import glowTools.blocks.BlockGlowGrassBlock;
import glowTools.blocks.BlockGlowSandStoneBlock;
import glowTools.blocks.BlockGlowglassBlock;
import glowTools.blocks.BlockGlowingStoneBlock;
import glowTools.blocks.BlockGlowironBlock;
import glowTools.blocks.BlockGlowsandBlock;
import glowTools.blocks.BlockGlowstoneInfuser;
import glowTools.blocks.BlockRedironBlock;
import glowTools.items.CloakInvis;
import glowTools.items.DarkDoorItem;
import glowTools.items.GlironArmor;
import glowTools.items.GlowFood;
import glowTools.items.GlowItem;
import glowTools.items.GlowScepter;
import glowTools.items.LightscepterItem;
import glowTools.items.glironaxeItem;
import glowTools.items.glironhoeItem;
import glowTools.items.glironpickItem;
import glowTools.items.glironshovelItem;
import glowTools.items.glironswordItem;
import glowTools.items.redironaxeItem;
import glowTools.items.redironhoeItem;
import glowTools.items.redironpickItem;
import glowTools.items.redironshovelItem;
import glowTools.items.redironswordItem;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAnvilBlock;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemLeaves;
import net.minecraft.item.ItemLilyPad;
import net.minecraft.item.ItemMultiTextureTile;
import net.minecraft.item.ItemPiston;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = GlowTools.modid, name = "GlowTools", version = "0.3a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class GlowTools
{
	/** Declaration */
	@Instance("ZL123_GlowTools")
	public static GlowTools instance;
	
	public static final String modid = "ZL123_GlowTools";
	
	@SidedProxy(clientSide = "glowTools.ClientProxyGlowTools", serverSide = "glowTools.CommonProxyGlowTools")
	public static CommonProxyGlowTools proxy;
	
	static int startEntityId = 300;
    private static List<GlowFuelHandler> glowHandlers = Lists.newArrayList();
	
    public static CreativeTabs tabGlowTools = new CreativeTabGlowtools("glowTools");
    
	//Block IDs
	public static int glowironBlockID;
	public static int redironBlockID;
	public static int glowsandBlockID;
	public static int CandentiniumOreID;
	public static int CandentiniumOreGlowingID;
	public static int GlowglassBlockID;
	public static int GlowSandStoneBlockID;
	public static int CandentiniumBlockID;
	public static int GlowGrassBlockID;
	public static int GlowDirtBlockID;
	public static int GlowCobbleBlockID;
	public static int GlowingStoneBlockID;
	public static int FlowStoneBlockID;
	public static int DarkDoorID;
	public static int GlowstoneInfuserID;
	public static int GlowstoneInfuserActiveID;
	public static int BlueGlassOreID;
	public static int GlowFarmlandID;
	
	//Blocks
	public static Block glowironBlock;
	public static Block redironBlock;
	public static Block glowsandBlock;
	public static Block CandentiniumOre;
	public static Block CandentiniumOreGlowing;
	public static Block GlowglassBlock;
	public static Block GlowSandStoneBlock;
	public static Block CandentiniumBlock;
	public static Block GlowGrassBlock;
	public static Block GlowDirtBlock;
	public static Block GlowCobbleBlock;
	public static Block GlowingStoneBlock;
	public static Block FlowStoneBlock;
	public static Block DarkDoor;
	public static Block GlowstoneInfuser;
	public static Block GlowstoneInfuserActive;
	public static Block BlueGlassOre;
	public static Block GlowFarmland;
	
	//Item IDs
	public static int glowironItemID;
	public static int glowmoltItemID;
	public static int redmoltItemID;
	public static int glowredItemID;
	public static int redironItemID;
	public static int SceptertipItemID;
	public static int RedironhandleItemID;
	public static int PorkappleItemID;
	public static int CandentiniumGemID;
	public static int glowironNuggetID;
	public static int redironNuggetID;
	public static int pureCalciteItemID;
	public static int cloakCoreID;
	public static int ReflectorItemID;
	public static int DarkDoorItemID;
	public static int InfernalCoalItemID;
	public static int BlueGlassShardID;
	public static int BlueFertilizerItemID;
	
	//Items
	public static Item glowironItem;
	public static Item glowmoltItem;
	public static Item redmoltItem;
	public static Item glowredItem;
	public static Item redironItem;
	public static Item SceptertipItem;
	public static Item RedironhandleItem;
	public static Item PorkappleItem;
	public static Item CandentiniumGem;
	public static Item glowironNugget;
	public static Item redironNugget;
	public static Item pureCalciteItem;
	public static Item cloakCore;
	public static Item ReflectorItem;
	public static Item DarkDoorItem;
	public static Item InfernalCoalItem;
	public static Item BlueGlassShard;
	public static Item BlueFertilizerItem;
	
	//Tool IDs
	public static int glironswordItemID;
	public static int glironpickItemID;
	public static int glironshovelItemID;
	public static int glironaxeItemID;
	public static int glironhoeItemID;
	public static int redironswordItemID;
	public static int redironpickItemID;
	public static int redironshovelItemID;
	public static int redironaxeItemID;
	public static int redironhoeItemID;
	public static int LightscepterItemID;
	public static int RegenscepterItemID;
	public static int Regenscepter2ItemID;
	public static int OmniscepterItemID;
	
	//Tools
	public static Item glironswordItem;
	public static Item glironpickItem;
	public static Item glironshovelItem;
	public static Item glironaxeItem;
	public static Item glironhoeItem;
	public static Item redironswordItem;
	public static Item redironpickItem;
	public static Item redironshovelItem;
	public static Item redironaxeItem;
	public static Item redironhoeItem;
	public static Item LightscepterItem;
	public static Item RegenscepterItem;
	public static Item Regenscepter2Item;
	public static Item OmniscepterItem;
	
	//Armor IDs
	public static int GlironHelmID;
	public static int GlironChestID;
	public static int GlironLegsID;
	public static int GlironBootsID;
	public static int CloakInvisID;
	
	//Armor
	public static Item GlironHelm;
	public static Item GlironChest;
	public static Item GlironLegs;
	public static Item GlironBoots;
	public static Item CloakInvis;
	
	//Hard Mode
	public static boolean OmniscepterHardMode;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Pre-initializing...", "");
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Loading Config...", "");
		ConfigLoader.loadConfig(event);
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Omniscepter Hard Mode is set to %b.", this.OmniscepterHardMode);
		instance = this;
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Initializing! :D", "");
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		
		//Blocks
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Loading Blocks...", "");
		glowironBlock = new BlockGlowironBlock(glowironBlockID).setUnlocalizedName("glowironBlock");
		redironBlock = new BlockRedironBlock(redironBlockID).setUnlocalizedName("redironBlock");
		glowsandBlock = new BlockGlowsandBlock(glowsandBlockID).setUnlocalizedName("glowsandBlock");
		CandentiniumOre = new BlockCandentiniumOre(CandentiniumOreID, false).setUnlocalizedName("CandentiniumOre").setCreativeTab(tabGlowTools);
		CandentiniumOreGlowing = new BlockCandentiniumOre(CandentiniumOreGlowingID, true).setLightValue(0.625F).setUnlocalizedName("CandentiniumOre");
		GlowglassBlock = new BlockGlowglassBlock(GlowglassBlockID, Material.glass, false).setHardness(0.3F).setUnlocalizedName("glowglassBlock");
		GlowSandStoneBlock = new BlockGlowSandStoneBlock(GlowSandStoneBlockID).setHardness(0.8F).setUnlocalizedName("glowsandstoneBlock");
		CandentiniumBlock = new BlockOreStorage(CandentiniumBlockID).setLightValue(0.625F).setUnlocalizedName("glowTools:tile.CandentiniumBlock").setCreativeTab(tabGlowTools);
		GlowGrassBlock = new BlockGlowGrassBlock(GlowGrassBlockID).setUnlocalizedName("glowgrassBlock");
		GlowDirtBlock = new BlockGlowDirtBlock(GlowDirtBlockID).setUnlocalizedName("glowdirtBlock");
		GlowCobbleBlock = new BlockGlowCobbleBlock(GlowCobbleBlockID).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("glowcobbleBlock");
		GlowingStoneBlock = new BlockGlowingStoneBlock(GlowingStoneBlockID).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("glowingstoneBlock");
		FlowStoneBlock = new BlockFlowStoneBlock(FlowStoneBlockID).setUnlocalizedName("FlowStoneBlock");
		DarkDoor = new BlockDarkDoor(DarkDoorID).setUnlocalizedName("DarkDoor");
		GlowstoneInfuser = new BlockGlowstoneInfuser(GlowstoneInfuserID, false).setUnlocalizedName("GlowstoneInfuser");
		GlowstoneInfuserActive = new BlockGlowstoneInfuser(GlowstoneInfuserActiveID, true).setUnlocalizedName("GlowstoneInfuserActive");
		BlueGlassOre = new BlockBlueGlassOre(BlueGlassOreID).setHardness(1.0F).setResistance(3.0F).setUnlocalizedName("BlueGlassOre");
		GlowFarmland = new BlockGlowFarmland(GlowFarmlandID).setHardness(0.6F).setUnlocalizedName("GlowFarmBlock");
		
		//Block Registry
		GameRegistry.registerBlock(glowironBlock, "ZL123_glowironBlock");
		GameRegistry.registerBlock(redironBlock, "ZL123_redironBlock");
		GameRegistry.registerBlock(glowsandBlock, "ZL123_glowsandBlock");
		GameRegistry.registerBlock(CandentiniumOre, "ZL123_candentiniumOre");
		GameRegistry.registerBlock(CandentiniumOreGlowing, "candentiniumOreGlowing");
		GameRegistry.registerBlock(GlowglassBlock, "ZL123_glowglassBlock");
		GameRegistry.registerBlock(GlowSandStoneBlock, "ZL123_glowsandstoneBlock");
		GameRegistry.registerBlock(CandentiniumBlock, "ZL123_candentiniumBlock");
		GameRegistry.registerBlock(GlowGrassBlock, "ZL123_glowgrassBlock");
		GameRegistry.registerBlock(GlowDirtBlock, "ZL123_glowdirtBlock");
		GameRegistry.registerBlock(GlowCobbleBlock, "ZL123_glowcobbleBlock");
		GameRegistry.registerBlock(GlowingStoneBlock, "ZL123_glowingstoneBlock");
		GameRegistry.registerBlock(FlowStoneBlock, "ZL123_flowstoneBlock");
		GameRegistry.registerBlock(DarkDoor, "ZL123_darkdoor");
		GameRegistry.registerBlock(GlowstoneInfuser, "ZL123_glowstoneInfuser");
		GameRegistry.registerBlock(GlowstoneInfuserActive, "ZL123_glowstoneInfuserActive");
		GameRegistry.registerBlock(BlueGlassOre, "ZL123_blueglassOre");
		GameRegistry.registerBlock(GlowFarmland, "ZL123_glowFarmland");
		
		//Block Harvest Levels
		MinecraftForge.setBlockHarvestLevel(glowironBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(redironBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(CandentiniumOre, "pickaxe", 2);	
		MinecraftForge.setBlockHarvestLevel(CandentiniumOreGlowing, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(GlowSandStoneBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(CandentiniumBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(GlowCobbleBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(GlowingStoneBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(FlowStoneBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(DarkDoor, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(GlowstoneInfuser, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(GlowstoneInfuserActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BlueGlassOre, "pickaxe", 1);
		
		//Block Language Registry
		LanguageRegistry.addName(glowironBlock, "Block of Glowing Iron");
		LanguageRegistry.addName(redironBlock, "Block of Red Iron");
		LanguageRegistry.addName(glowsandBlock, "Glowing Sand");
		LanguageRegistry.addName(CandentiniumOre, "Candentinium Ore");
		LanguageRegistry.addName(GlowglassBlock, "Glowing Glass");
		LanguageRegistry.addName(GlowSandStoneBlock, "Glowing Sandstone");
		LanguageRegistry.addName(CandentiniumBlock, "Block of Candentinium");
		LanguageRegistry.addName(GlowGrassBlock, "Glowing Grass Block");
		LanguageRegistry.addName(GlowDirtBlock, "Glowing Dirt Block");
		LanguageRegistry.addName(GlowCobbleBlock, "Glowing Cobblestone");
		LanguageRegistry.addName(GlowingStoneBlock, "Glowing Stone");
		LanguageRegistry.addName(FlowStoneBlock, "Calcite");
		LanguageRegistry.addName(DarkDoor, "Dark Door");
		LanguageRegistry.addName(GlowstoneInfuser, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(GlowstoneInfuserActive, "Glowstone Infuser (WIP)");
		LanguageRegistry.addName(BlueGlassOre, "Glassy Blue Ore");
		
		//Items
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Loading Items...", "");
		glowironItem = new GlowItem(glowironItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("glowironItem");
		glowmoltItem = new GlowItem(glowmoltItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("glowmoltItem");
		redmoltItem = new GlowItem(redmoltItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("redmoltItem");
		glowredItem = new GlowItem(glowredItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("glowredItem");
		redironItem = new GlowItem(redironItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("redironItem");
		SceptertipItem = new GlowItem(SceptertipItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("SceptertipItem");
		RedironhandleItem = new GlowItem(RedironhandleItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("RedironhandleItem");
		PorkappleItem = new GlowFood(PorkappleItemID, 10, 0.9F, true).setPotionEffect(Potion.resistance.id, 5, 0, 0.5F).setUnlocalizedName("PorkappleItem");
		CandentiniumGem = new GlowItem(CandentiniumGemID).setCreativeTab(tabGlowTools).setUnlocalizedName("CandentiniumGem");
		glowironNugget = new GlowItem(glowironNuggetID).setCreativeTab(tabGlowTools).setUnlocalizedName("glowironNugget");
		redironNugget = new GlowItem(redironNuggetID).setCreativeTab(tabGlowTools).setUnlocalizedName("redironNugget");
		pureCalciteItem = new GlowItem(pureCalciteItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("pureCalciteItem");
		cloakCore = new GlowItem(cloakCoreID).setCreativeTab(tabGlowTools).setUnlocalizedName("cloakCore");
		ReflectorItem = new GlowItem(ReflectorItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("ReflectorItem");
		DarkDoorItem = new DarkDoorItem(DarkDoorItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("darkDoorItem");
		InfernalCoalItem = new GlowItem(InfernalCoalItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("InfernalCoalItem");
		BlueGlassShard = new GlowItem(BlueGlassShardID).setCreativeTab(tabGlowTools).setUnlocalizedName("blueglassShard");
		BlueFertilizerItem = new GlowItem(BlueFertilizerItemID).setCreativeTab(tabGlowTools).setUnlocalizedName("bluefertilizerItem");
		
		//Item Language Registry
		LanguageRegistry.addName(glowironItem, "Glowing Iron Ingot");
		LanguageRegistry.addName(glowmoltItem, "Melted Glowstone");
		LanguageRegistry.addName(redmoltItem, "Melted Redstone");
		LanguageRegistry.addName(glowredItem, "Blazing Blend");
		LanguageRegistry.addName(redironItem, "Red Iron Ingot");
		LanguageRegistry.addName(SceptertipItem, "Scepter Tip");
		LanguageRegistry.addName(RedironhandleItem, "Red-Iron-Tool Handle");
		LanguageRegistry.addName(PorkappleItem, "Porkchop with Applesauce");
		LanguageRegistry.addName(CandentiniumGem, "Candentinium Shard");
		LanguageRegistry.addName(glowironNugget, "Glowing Iron Nugget");
		LanguageRegistry.addName(redironNugget, "Red Iron Nugget");
		LanguageRegistry.addName(pureCalciteItem, "Purified Calcite");
		LanguageRegistry.addName(cloakCore, "Cloak Core");
		LanguageRegistry.addName(ReflectorItem, "Light Reflector");
		LanguageRegistry.addName(DarkDoorItem, "Dark Door");
		LanguageRegistry.addName(InfernalCoalItem, "Infernal Coal");
		LanguageRegistry.addName(BlueGlassShard, "Glassy Blue Shard");
		LanguageRegistry.addName(BlueFertilizerItem, "Blue Fertilizer");
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityGsInfuser.class, "tile.TileEntityGsInfuser");
		
		//Entities
		EntityRegistry.registerModEntity(EntitySkidglow.class, "Skidding Glow", 1, this, 80, 3, true);
		EntityRegistry.addSpawn(EntitySkidglow.class, 8, 2, 6, EnumCreatureType.monster, BiomeGenBase.hell, BiomeGenBase.sky, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.swampland);
		registerEntityEgg(EntitySkidglow.class, 0x111111, 0x091156);
		EntityRegistry.registerGlobalEntityID(EntityFallglowsand.class, "glowsand", 31);
		LanguageRegistry.instance().addStringLocalization("entity.ZL123_GlowTools.Skidding Glow.name", "Skidding Glow");
		
		
		/** Tools Section (What tool can harvest, Durability, Efficiency/Strength on proper material, Damage versus entities, Enchantability) */
		
		//Glow Iron Tools
		EnumToolMaterial EnumToolMaterialGlowiron = EnumHelper.addToolMaterial("Glowiron", 2, 650, 10.0F, 3, 18);
		glironswordItem = new glironswordItem(glironswordItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironswordItem");
		glironpickItem = new glironpickItem(glironpickItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironpickItem");
		glironshovelItem = new glironshovelItem(glironshovelItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironshovelItem");
		glironaxeItem = new glironaxeItem(glironaxeItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironaxeItem");
		glironhoeItem = new glironhoeItem(glironhoeItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironhoeItem");
		LanguageRegistry.addName(glironswordItem, "Glowing Iron Sword");
		LanguageRegistry.addName(glironpickItem, "Glowing Iron Pickaxe");
		LanguageRegistry.addName(glironshovelItem, "Glowing Iron Shovel");
		LanguageRegistry.addName(glironaxeItem, "Glowing Iron Axe");
		LanguageRegistry.addName(glironhoeItem, "Glowing Iron Hoe");
		
		//Red Iron Tools
		EnumToolMaterial EnumToolMaterialRediron = EnumHelper.addToolMaterial("Rediron", 2, 300, 5.0F, 5, 25);
		redironswordItem = new redironswordItem(redironswordItemID, EnumToolMaterialRediron).setUnlocalizedName("redironswordItem");
		redironpickItem = new redironpickItem(redironpickItemID, EnumToolMaterialRediron).setUnlocalizedName("redironpickItem");
		redironshovelItem = new redironshovelItem(redironshovelItemID, EnumToolMaterialRediron).setUnlocalizedName("redironshovelItem");
		redironaxeItem = new redironaxeItem(redironaxeItemID, EnumToolMaterialRediron).setUnlocalizedName("redironaxeItem");
		redironhoeItem = new redironhoeItem(redironhoeItemID, EnumToolMaterialRediron).setUnlocalizedName("redironhoeItem");
		LanguageRegistry.addName(redironswordItem, "Red Iron Sword");
		LanguageRegistry.addName(redironpickItem, "Red Iron Pickaxe");
		LanguageRegistry.addName(redironshovelItem, "Red Iron Shovel");
		LanguageRegistry.addName(redironaxeItem, "Red Iron Axe");
		LanguageRegistry.addName(redironhoeItem, "Red Iron Hoe");
		
		//Scepters
		EnumToolMaterial EnumToolMaterialScepter = EnumHelper.addToolMaterial("Scepter", -1, -1, 0F, 0, -1);
		LightscepterItem = new LightscepterItem(LightscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("LightscepterItem");
		LanguageRegistry.addName(LightscepterItem, "Scepter of Light");
		RegenscepterItem = new GlowScepter(RegenscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("RegenscepterItem");
		LanguageRegistry.addName(RegenscepterItem, "Scepter of Regeneration");
		Regenscepter2Item = new GlowScepter(Regenscepter2ItemID, EnumToolMaterialScepter).setUnlocalizedName("Regenscepter2Item");
		LanguageRegistry.addName(Regenscepter2Item, "Scepter of Regeneration Mk. II");
		OmniscepterItem = new GlowScepter(OmniscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("OmniscepterItem");
		LanguageRegistry.addName(OmniscepterItem, "Omni-Scepter");
		
		/** Armor Section (Max Damage before it breaks, Damage Reduction, Enchantability) */
		
		//Glow Iron Armor
		EnumArmorMaterial EnumArmorMaterialGlowiron = EnumHelper.addArmorMaterial("Glowiron", 25, new int[] {2, 7, 6, 2}, 18);
		GlironHelm = new GlironArmor(GlironHelmID, EnumArmorMaterialGlowiron, proxy.addArmor("Gliron"), 0).setUnlocalizedName("GlironHelm");
		GlironChest = new GlironArmor(GlironChestID, EnumArmorMaterialGlowiron, proxy.addArmor("Gliron"), 1).setUnlocalizedName("GlironChest");
		GlironLegs = new GlironArmor(GlironLegsID, EnumArmorMaterialGlowiron, proxy.addArmor("Gliron"), 2).setUnlocalizedName("GlironLegs");
		GlironBoots = new GlironArmor(GlironBootsID, EnumArmorMaterialGlowiron, proxy.addArmor("Gliron"), 3).setUnlocalizedName("GlironBoots");
		LanguageRegistry.addName(GlironHelm, "Stripey Glowing Iron Helmet");
		LanguageRegistry.addName(GlironChest, "Stripey Glowing Iron Chestplate");
		LanguageRegistry.addName(GlironLegs, "Stripey Glowing Iron Leggings");
		LanguageRegistry.addName(GlironBoots, "Stripey Glowing Iron Boots");
		
		//Cloaks
		EnumArmorMaterial EnumArmorMaterialCloak = EnumHelper.addArmorMaterial("Cloak", -1, new int[] {0, 2, 0, 0}, -1);
		CloakInvis = new CloakInvis(CloakInvisID, EnumArmorMaterialCloak, proxy.addArmor("Cloak"), 1).setUnlocalizedName("CloakInvis");
		LanguageRegistry.addName(CloakInvis, "Cloak of Invisibility");
		GameRegistry.addRecipe(new ItemStack(CloakInvis), new Object[]{"XXX", "XYX", "XXX", 'X', ReflectorItem, 'Y', cloakCore});
		
		/** Random Necessities Section */
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Loading Random Necessities...", "");
		
		//World Generators
		GameRegistry.registerWorldGenerator(new WorldGenGlowOres());
		GameRegistry.registerWorldGenerator(new WorldGenGlowGrass());
		
		//GUIs
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
        //Language Instances
        LanguageRegistry.instance().addStringLocalization("itemGroup.glowTools", "en_US", "GlowTools");
        LanguageRegistry.instance().addStringLocalization("item.glironshovelItem.name", "en_GB", "Glowing Iron Spade");
        LanguageRegistry.instance().addStringLocalization("item.redironshovelItem.name", "en_GB", "Red Iron Spade");
        
		/** Recipes */
		
        FMLLog.log("ZL123_GlowTools", Level.INFO, "Loading Recipes...", "");
		//General Items/Blocks
		GameRegistry.addRecipe(new ItemStack(glowironBlock, 2), new Object[]{"XXX", "XXX", "XXX", 'X', glowironItem});
		GameRegistry.addRecipe(new ItemStack(glowironItem, 4), new Object[]{"X", 'X', glowironBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(glowironItem), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(glowmoltItem)});
		GameRegistry.addSmelting(Item.lightStoneDust.itemID, new ItemStack(glowmoltItem, 1), 0.4F);
		GameRegistry.addSmelting(Item.redstone.itemID, new ItemStack(redmoltItem, 1), 0.4F);
		GameRegistry.addRecipe(new ItemStack(Item.expBottle, 3), new Object[]{"XZY", "XZY", "XZY", 'X', glowmoltItem, 'Y', redmoltItem, 'Z', new ItemStack(Item.glassBottle)});
		GameRegistry.addSmelting(Item.expBottle.itemID, new ItemStack(Item.expBottle, 1), 0.7F);	
		GameRegistry.addRecipe(new ItemStack(redironBlock, 2), new Object[]{"XXX", "XXX", "XXX", 'X', redironItem});
		GameRegistry.addShapelessRecipe(new ItemStack(glowredItem, 3), new Object[]{new ItemStack(glowmoltItem), new ItemStack(redmoltItem), new ItemStack(Item.blazePowder)});
		GameRegistry.addShapelessRecipe(new ItemStack(redironItem), new Object[]{new ItemStack(Item.ingotIron), new ItemStack(redmoltItem)});
		GameRegistry.addRecipe(new ItemStack(redironItem, 4), new Object[]{"X", 'X', redironBlock});
		GameRegistry.addRecipe(new ItemStack(SceptertipItem), new Object[]{" X ", "XYX", " X ", 'X', new ItemStack(Item.diamond), 'Y', new ItemStack(CandentiniumGem)});
		GameRegistry.addShapelessRecipe(new ItemStack(RedironhandleItem), new Object[]{new ItemStack(glowredItem), new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(PorkappleItem, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Item.porkCooked), 'Y', new ItemStack(Item.appleRed)});
		GameRegistry.addRecipe(new ItemStack(glowsandBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sand), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(CandentiniumOre.blockID, new ItemStack(CandentiniumGem), 0.7F);
		GameRegistry.addRecipe(new ItemStack(GlowglassBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.glass), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(glowsandBlock.blockID, new ItemStack(GlowglassBlock), 0.4F);
		GameRegistry.addRecipe(new ItemStack(GlowSandStoneBlock), new Object[]{"XX", "XX", 'X', glowsandBlock});
		GameRegistry.addRecipe(new ItemStack(GlowSandStoneBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.sandStone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", 'X', new ItemStack(GlowSandStoneBlock)});
		GameRegistry.addRecipe(new ItemStack(CandentiniumBlock), new Object[]{"XXX", "XXX", "XXX", 'X', CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GlowDirtBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.dirt), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GlowCobbleBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.cobblestone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addRecipe(new ItemStack(GlowingStoneBlock, 8), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.stone), 'Y', new ItemStack(Block.glowStone)});
		GameRegistry.addSmelting(GlowCobbleBlock.blockID, new ItemStack(GlowingStoneBlock), 0.2F);
		GameRegistry.addRecipe(new ItemStack(glowironItem), new Object[]{"XXX", "XXX", "XXX", 'X', glowironNugget});
		GameRegistry.addRecipe(new ItemStack(redironItem), new Object[]{"XXX", "XXX", "XXX", 'X', redironNugget});
		GameRegistry.addRecipe(new ItemStack(glowironNugget, 9), new Object[]{"X", 'X', glowironItem});
		GameRegistry.addRecipe(new ItemStack(redironNugget, 9), new Object[]{"X", 'X', redironItem});
		GameRegistry.addSmelting(FlowStoneBlock.blockID, new ItemStack(pureCalciteItem), 0.4F);
		GameRegistry.addRecipe(new ItemStack(cloakCore), new Object[]{"XYX", "YZY", "XYX", 'X', new ItemStack(Block.cloth), 'Y', new ItemStack(Item.diamond), 'Z', CandentiniumBlock});
		GameRegistry.addRecipe(new ItemStack(ReflectorItem), new Object[]{"XYX", "XZX", "XYX", 'X', pureCalciteItem, 'Y', CandentiniumGem, 'Z', new ItemStack(Item.diamond)});
		GameRegistry.addSmelting(CandentiniumBlock.blockID, new ItemStack(CandentiniumGem, 9), 0.7F);
		GameRegistry.addRecipe(new ItemStack(DarkDoorItem), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(Block.obsidian), 'Y', new ItemStack(Item.doorSteel)});
		GameRegistry.addShapelessRecipe(new ItemStack(InfernalCoalItem, 4), new Object[]{new ItemStack(glowredItem), new ItemStack(Item.coal)});
		GameRegistry.addShapelessRecipe(new ItemStack(InfernalCoalItem, 4), new Object[]{new ItemStack(glowmoltItem), new ItemStack(redmoltItem), new ItemStack(Item.blazePowder), new ItemStack(Item.coal)});
		GameRegistry.addRecipe(new ItemStack(Block.blockSteel), new Object[]{"X", 'X', glowironBlock});
		GameRegistry.addRecipe(new ItemStack(Block.blockSteel), new Object[]{"X", 'X', redironBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(BlueFertilizerItem, 2), new Object[]{new ItemStack(BlueGlassShard), new ItemStack(Item.bucketWater)});
		
		//Armor
		GameRegistry.addRecipe(new ItemStack(GlironHelm), new Object[]{"XYX", "X X", 'X', glowironItem, 'Y', CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GlironChest), new Object[]{"X X", "YXY", "XXX", 'X', glowironItem, 'Y', CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GlironLegs), new Object[]{"XXX", "Y Y", "X X", 'X', glowironItem, 'Y', CandentiniumGem});
		GameRegistry.addRecipe(new ItemStack(GlironBoots), new Object[]{"X X", "X X", 'X', glowironItem});
		GameRegistry.addSmelting(GlironHelm.itemID, new ItemStack(glowironItem, 2), 0.2F);
		GameRegistry.addSmelting(GlironChest.itemID, new ItemStack(glowironItem, 4), 0.7F);
		GameRegistry.addSmelting(GlironLegs.itemID, new ItemStack(glowironItem, 3), 0.6F);
		GameRegistry.addSmelting(GlironBoots.itemID, new ItemStack(glowironItem, 2), 0.2F);
		
		//Scepters
		GameRegistry.addRecipe(new ItemStack(LightscepterItem, 1), new Object[]{"TPT", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.goldenCarrot), 'S', new ItemStack(glowredItem), 'P', new ItemStack(SceptertipItem), 'T', new ItemStack(glowmoltItem)});
		GameRegistry.addRecipe(new ItemStack(RegenscepterItem, 1), new Object[]{"TPU", "RQR", "SQS", 'Q', new ItemStack(Item.blazeRod), 'R',
			new ItemStack(Item.ghastTear), 'S', new ItemStack(glowredItem), 'P', new ItemStack(SceptertipItem), 'T', new ItemStack(Item.plateDiamond),
			'U', new ItemStack(Item.appleGold, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Regenscepter2Item), new Object[]{"PQP", "RSR", "PQP", 'P', new ItemStack(Item.diamond), 'Q',
			new ItemStack(CandentiniumGem), 'R', new ItemStack(Block.blockGold), 'S', new ItemStack(RegenscepterItem)});
		GameRegistry.addRecipe(new ItemStack(OmniscepterItem), new Object[]{getOmniScepterLine(1), getOmniScepterLine(2), getOmniScepterLine(3), 'A', new ItemStack(Block.blockDiamond), 'B',
			new ItemStack(Block.blockEmerald), 'C', new ItemStack(LightscepterItem), 'D', new ItemStack(CloakInvis), 'E', new ItemStack(Regenscepter2Item), 'F', new ItemStack(Item.diamond),
			'G', new ItemStack(Item.emerald), 'H', new ItemStack(GlowTools.CandentiniumGem)});
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(redironswordItem), new Object[]{" X ", " X ", " Y ", 'X', redironItem, 'Y', RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(redironpickItem), new Object[]{"XXX", " Y ", " Y ", 'X', redironItem, 'Y', RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(redironshovelItem), new Object[]{" X ", " Y ", " Y ", 'X', redironItem, 'Y', RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(redironaxeItem), new Object[]{"XX ", "XY ", " Y ", 'X', redironItem, 'Y', RedironhandleItem});
		GameRegistry.addRecipe(new ItemStack(redironhoeItem), new Object[]{"XX ", " Y ", " Y ", 'X', redironItem, 'Y', RedironhandleItem});
		GameRegistry.addSmelting(redironswordItem.itemID, new ItemStack(redironNugget), 0.7F);
		GameRegistry.addSmelting(redironpickItem.itemID, new ItemStack(redironNugget), 0.7F);
		GameRegistry.addSmelting(redironshovelItem.itemID, new ItemStack(redironNugget), 0.7F);
		GameRegistry.addSmelting(redironaxeItem.itemID, new ItemStack(redironNugget), 0.7F);
		GameRegistry.addSmelting(redironhoeItem.itemID, new ItemStack(redironNugget), 0.7F);
		GameRegistry.addRecipe(new ItemStack(glironswordItem), new Object[]{" X ", " X ", " Y ", 'X', glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(glironpickItem), new Object[]{"XXX", " Y ", " Y ", 'X', glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(glironshovelItem), new Object[]{" X ", " Y ", " Y ", 'X', glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(glironaxeItem), new Object[]{"XX ", "XY ", " Y ", 'X', glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addRecipe(new ItemStack(glironhoeItem), new Object[]{"XX ", " Y ", " Y ", 'X', glowironItem, 'Y', new ItemStack(Item.blazeRod)});
		GameRegistry.addSmelting(glironswordItem.itemID, new ItemStack(glowironNugget), 0.7F);
		GameRegistry.addSmelting(glironpickItem.itemID, new ItemStack(glowironNugget), 0.7F);
		GameRegistry.addSmelting(glironshovelItem.itemID, new ItemStack(glowironNugget), 0.7F);
		GameRegistry.addSmelting(glironaxeItem.itemID, new ItemStack(glowironNugget), 0.7F);
		GameRegistry.addSmelting(glironhoeItem.itemID, new ItemStack(glowironNugget), 0.7F);
		
		/** Loot */
		
		//Dungeons
		DungeonHooks.addDungeonMob("Skidding Glow", 50);
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.CandentiniumGem), 1, 7, 75));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.CloakInvis), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.InfernalCoalItem), 2, 6, 100));
		
		//Blacksmiths
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.GlironBoots), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.GlironChest), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.GlironHelm), 1, 1, 80));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.InfernalCoalItem), 2, 6, 100));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.glowironItem), 1, 5, 95));		
		
		//Mineshafts
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.CandentiniumGem), 1, 7, 90));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.CloakInvis), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.redironpickItem), 1, 1, 75));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.LightscepterItem), 1, 1, 30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.glironpickItem), 1, 1, 65));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.RedironhandleItem), 2, 15, 50));
		
		//Desert Pyramids
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.Regenscepter2Item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.CandentiniumBlock), 2, 12, 60));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.OmniscepterItem), 1, 1, 1));
		
		//Jungle Pyramids
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.pureCalciteItem), 17, 31, 90));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.cloakCore), 1, 2, 14));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.DarkDoor), 1, 2, 20));
		
		//Strongholds
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.GlironLegs), 1, 1, 60));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.DarkDoorItem), 1, 2, 20));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BlueGlassShard), 3, 7, 80));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.glironswordItem), 1, 1, 77));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.GlironLegs), 1, 1, 60));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.DarkDoorItem), 1, 2, 20));
		
		//Bonus Chest
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.glironhoeItem), 1, 1, 50));
		
		
		FMLLog.log("ZL123_GlowTools", Level.INFO, "Finished Loading!", "");
	}

	public static boolean isOmniScepterHardMode(){
		return OmniscepterHardMode;
	}
	
	public static String getOmniScepterLine(int ln){
		switch (ln) {
		case 1:
			return isOmniScepterHardMode() ? "AAA" : "FHF";
		case 2:
			return isOmniScepterHardMode() ? "CDE" : "CDE";
		case 3:
			return isOmniScepterHardMode() ? "BBB" : "GHG";
		default:
			return null;
		}
	}
	
	public static int getUniqueEntityId()
	{
		do
		{startEntityId++;}
		while(EntityList.getStringFromID(startEntityId) != null);
			
		return startEntityId;	
	}
	
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
    public static void registerGlowHandler(GlowFuelHandler handler)
    {
        glowHandlers.add(handler);
    }
        
    public static int getGlowValue(ItemStack itemStack)
    {
        int glowValue = 0;
        for (GlowFuelHandler handler : glowHandlers)
        {
            glowValue = Math.max(glowValue, handler.getGlowAmount(itemStack));
        }
        return glowValue;
    }
}
