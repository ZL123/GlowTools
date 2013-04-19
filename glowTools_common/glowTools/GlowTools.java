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
import glowTools.blocks.GTBlocks;
import glowTools.config.ConfigLoader;
import glowTools.config.ConfigSettings;
import glowTools.items.CloakInvis;
import glowTools.items.DarkDoorItem;
import glowTools.items.GTItems;
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
import glowTools.lib.Reference;
import glowTools.recipe.GTRecipes;
import glowTools.worldgen.GTChestLoot;
import glowTools.worldgen.GTGen;
import glowTools.worldgen.WorldGenGlowGrass;
import glowTools.worldgen.WorldGenGlowOres;

import java.util.List;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class GlowTools
{
	/** Declaration */
	@Instance("ZL123_GlowTools")
	public static GlowTools instance;
	
	@SidedProxy(clientSide = "glowTools.ClientProxyGlowTools", serverSide = "glowTools.CommonProxyGlowTools")
	public static CommonProxyGlowTools proxy;
	
	static int startEntityId = 300;
    private static List<GlowFuelHandler> glowHandlers = Lists.newArrayList();
	
    public static CreativeTabs tabGlowTools = new CreativeTabGlowtools("glowTools");
    
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Pre-initializing...", "");
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Config...", "");
		ConfigLoader.loadConfig(event);
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Omniscepter Hard Mode is set to %b.", ConfigSettings.OmniscepterHardMode);
		instance = this;
		
		//Initialize Blocks' Stuff
		GTBlocks.init();
		//Initialize Items' Stuff
		GTItems.init();
		
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Initializing! :D", "");
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();

		
		/** Random Necessities Section */
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Random Necessities...", "");
		
		//Initialize World Generators
		GTGen.gen();
		//Loot
		GTChestLoot.pop();
		
		//GUIs
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
        //Language Instances
        LanguageRegistry.instance().addStringLocalization("itemGroup.glowTools", "en_US", "GlowTools");
        LanguageRegistry.instance().addStringLocalization("item.glironshovelItem.name", "en_GB", "Glowing Iron Spade");
        LanguageRegistry.instance().addStringLocalization("item.redironshovelItem.name", "en_GB", "Red Iron Spade");
        
		//Recipes
		GTRecipes.recipes();
		
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Finished Loading!", "");
	}

	public static boolean isOmniScepterHardMode(){
		return ConfigSettings.OmniscepterHardMode;
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
