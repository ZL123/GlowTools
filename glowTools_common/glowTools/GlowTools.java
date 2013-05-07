/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools;

import glowTools.blocks.GTBlocks;
import glowTools.config.ConfigLoader;
import glowTools.config.ConfigSettings;
import glowTools.entity.EntitySkidglow;
import glowTools.entity.GTEntities;
import glowTools.gui.GuiHandler;
import glowTools.inventory.CreativeTabGlowtools;
import glowTools.items.GTItems;
import glowTools.lang.Names;
import glowTools.lib.Reference;
import glowTools.proxy.CommonProxyGT;
import glowTools.recipe.GTRecipes;
import glowTools.recipe.GlowFuelHandler;
import glowTools.tileentity.TileEntityGsInfuser;
import glowTools.worldgen.GTChestLoot;
import glowTools.worldgen.GTGen;

import java.util.List;
import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class GlowTools
{
	/** Declaration */
	@Instance(Reference.MODID)
	public static GlowTools instance;
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.SERVERPROXY)
	public static CommonProxyGT proxy;
	
	static int startEntityId = 300;
    private static List<GlowFuelHandler> glowHandlers = Lists.newArrayList();
	
    public static CreativeTabs tabGlowTools = new CreativeTabGlowtools("glowTools");
    
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "GlowTools v%s is running.", Reference.VERSION);
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
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();

		
		/** Random Necessities Section */
		
		//Initialize World Generators
		GTGen.generate();
		
		//Loot
		GTChestLoot.populate();
		
		//Register Entities
		GTEntities.registerEntities();
		
		//GUIs
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
        //Language Instances
        Names.load();
        
		//Recipes
		GTRecipes.recipes();
		
		//Eggs
		registerEntityEgg(EntitySkidglow.class, 0x160E4A, 0x0B28E3);
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityGsInfuser.class, "Glowstone Infuser");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		GTItems.postInit();
		
		
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Finished Loading!", "");
	}
	
	
	public static boolean isOmniScepterHardMode(){
		return ConfigSettings.OmniscepterHardMode;
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
