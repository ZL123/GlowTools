/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.items;

import glowTools.GlowTools;
import glowTools.config.ConfigSettings;
import glowTools.lib.Reference;

import java.util.logging.Level;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import api.EnumTag;
import api.ObjectTags;
import api.ThaumcraftApi;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GTItems {
	
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
	
	//Armor
	public static Item GlironHelm;
	public static Item GlironChest;
	public static Item GlironLegs;
	public static Item GlironBoots;
	public static Item CloakInvis;	
	
	
	
	public static void init(){
		//Items
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Items...", "");
		glowironItem = new GlowItem(ConfigSettings.glowironItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowironItem");
		glowmoltItem = new GlowItem(ConfigSettings.glowmoltItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowmoltItem");
		redmoltItem = new GlowItem(ConfigSettings.redmoltItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redmoltItem");
		glowredItem = new GlowItem(ConfigSettings.glowredItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowredItem");
		redironItem = new GlowItem(ConfigSettings.redironItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redironItem");
		SceptertipItem = new GlowItem(ConfigSettings.SceptertipItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("SceptertipItem");
		RedironhandleItem = new GlowItem(ConfigSettings.RedironhandleItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("RedironhandleItem");
		PorkappleItem = new GlowFood(ConfigSettings.PorkappleItemID, 10, 0.9F, true).setPotionEffect(Potion.resistance.id, 5, 0, 0.5F).setUnlocalizedName("PorkappleItem");
		CandentiniumGem = new GlowItem(ConfigSettings.CandentiniumGemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("CandentiniumGem");
		glowironNugget = new GlowItem(ConfigSettings.glowironNuggetID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowironNugget");
		redironNugget = new GlowItem(ConfigSettings.redironNuggetID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redironNugget");
		pureCalciteItem = new GlowItem(ConfigSettings.pureCalciteItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("pureCalciteItem");
		cloakCore = new GlowItem(ConfigSettings.cloakCoreID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("cloakCore");
		ReflectorItem = new GlowItem(ConfigSettings.ReflectorItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("ReflectorItem");
		DarkDoorItem = new DarkDoorItem(ConfigSettings.DarkDoorItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("darkDoorItem");
		InfernalCoalItem = new GlowItem(ConfigSettings.InfernalCoalItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("InfernalCoalItem");
		BlueGlassShard = new GlowItem(ConfigSettings.BlueGlassShardID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("blueglassShard");
		BlueFertilizerItem = new GlowItem(ConfigSettings.BlueFertilizerItemID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("bluefertilizerItem");
				
		//Glow Iron Tools
		EnumToolMaterial EnumToolMaterialGlowiron = EnumHelper.addToolMaterial("Glowiron", 2, 650, 10.0F, 3, 18);
		glironswordItem = new glironswordItem(ConfigSettings.glironswordItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironswordItem");
		glironpickItem = new glironpickItem(ConfigSettings.glironpickItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironpickItem");
		glironshovelItem = new glironshovelItem(ConfigSettings.glironshovelItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironshovelItem");
		glironaxeItem = new glironaxeItem(ConfigSettings.glironaxeItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironaxeItem");
		glironhoeItem = new glironhoeItem(ConfigSettings.glironhoeItemID, EnumToolMaterialGlowiron).setUnlocalizedName("glironhoeItem");
		
		//Red Iron Tools
		EnumToolMaterial EnumToolMaterialRediron = EnumHelper.addToolMaterial("Rediron", 2, 300, 5.0F, 5, 25);
		redironswordItem = new redironswordItem(ConfigSettings.redironswordItemID, EnumToolMaterialRediron).setUnlocalizedName("redironswordItem");
		redironpickItem = new redironpickItem(ConfigSettings.redironpickItemID, EnumToolMaterialRediron).setUnlocalizedName("redironpickItem");
		redironshovelItem = new redironshovelItem(ConfigSettings.redironshovelItemID, EnumToolMaterialRediron).setUnlocalizedName("redironshovelItem");
		redironaxeItem = new redironaxeItem(ConfigSettings.redironaxeItemID, EnumToolMaterialRediron).setUnlocalizedName("redironaxeItem");
		redironhoeItem = new redironhoeItem(ConfigSettings.redironhoeItemID, EnumToolMaterialRediron).setUnlocalizedName("redironhoeItem");
				
		//Scepters
		EnumToolMaterial EnumToolMaterialScepter = EnumHelper.addToolMaterial("Scepter", -1, -1, 0F, 0, -1);
		LightscepterItem = new LightscepterItem(ConfigSettings.LightscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("LightscepterItem");
		RegenscepterItem = new GlowScepter(ConfigSettings.RegenscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("RegenscepterItem");
		Regenscepter2Item = new GlowScepter(ConfigSettings.Regenscepter2ItemID, EnumToolMaterialScepter).setUnlocalizedName("Regenscepter2Item");
		OmniscepterItem = new GlowScepter(ConfigSettings.OmniscepterItemID, EnumToolMaterialScepter).setUnlocalizedName("OmniscepterItem");
		
		/** Armor Section (Max Damage before it breaks, Damage Reduction, Enchantability) */
		
		//Glow Iron Armor
		EnumArmorMaterial EnumArmorMaterialGlowiron = EnumHelper.addArmorMaterial("Glowiron", 25, new int[] {2, 7, 6, 2}, 18);
		GlironHelm = new GlironArmor(ConfigSettings.GlironHelmID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 0).setUnlocalizedName("GlironHelm");
		GlironChest = new GlironArmor(ConfigSettings.GlironChestID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 1).setUnlocalizedName("GlironChest");
		GlironLegs = new GlironArmor(ConfigSettings.GlironLegsID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 2).setUnlocalizedName("GlironLegs");
		GlironBoots = new GlironArmor(ConfigSettings.GlironBootsID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 3).setUnlocalizedName("GlironBoots");
		
		//Cloaks
		EnumArmorMaterial EnumArmorMaterialCloak = EnumHelper.addArmorMaterial("Cloak", -1, new int[] {0, 2, 0, 0}, -1);
		CloakInvis = new CloakInvis(ConfigSettings.CloakInvisID, EnumArmorMaterialCloak, GlowTools.proxy.addArmor("Cloak"), 1).setUnlocalizedName("CloakInvis");
		GameRegistry.addRecipe(new ItemStack(CloakInvis), new Object[]{"XXX", "XYX", "XXX", 'X', ReflectorItem, 'Y', cloakCore});
		
	}
	
	public static void postInit(){
		
		/**
		 * Thaumcraft Aspects
		 */
		
		
		ThaumcraftApi.registerObjectTag(glowmoltItem.itemID, -1, (new ObjectTags()).add(EnumTag.LIGHT, 3).add(EnumTag.VISION, 1).add(EnumTag.FIRE, 1));
		ThaumcraftApi.registerObjectTag(redmoltItem.itemID, -1, (new ObjectTags()).add(EnumTag.MECHANISM, 2).add(EnumTag.POWER, 2).add(EnumTag.FIRE, 1));
		
	}
	
}