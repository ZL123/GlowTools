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
	public static Item itemGlowIron;
	public static Item itemGlowMolt;
	public static Item itemRedMolt;
	public static Item itemGlowRed;
	public static Item itemRedIron;
	public static Item itemScepterTip;
	public static Item itemRedIronHandle;
	public static Item itemPorkApple;
	public static Item gemCandentinium;
	public static Item nuggetGlowIron;
	public static Item nuggetRedIron;
	public static Item itemCalcitePure;
	public static Item itemCloakCore;
	public static Item itemLightReflector;
	public static Item itemDarkDoor;
	public static Item itemInfernalCoal;
	public static Item shardBlueGlass;
	public static Item itemBlueFertilizer;
	
	//Tools
	public static Item itemGlironSword;
	public static Item itemGlironPick;
	public static Item itemGlironShovel;
	public static Item itemGlironAxe;
	public static Item itemGlironHoe;
	public static Item itemRedironSword;
	public static Item itemRedironPick;
	public static Item itemRedironShovel;
	public static Item itemRedironAxe;
	public static Item itemRedironHoe;
	public static Item itemScepterLight;
	public static Item itemScepterRegen;
	public static Item itemScepterRegen2;
	public static Item itemScepterOmni;
	
	//Armor
	public static Item itemGlironHelm;
	public static Item itemGlironChest;
	public static Item itemGlironLegs;
	public static Item itemGlironBoots;
	public static Item itemCloakInvis;	
	
	
	public static void init(){
		//Items
		FMLLog.log(Reference.CHANNELNAME, Level.INFO, "Loading Items...", "");
		itemGlowIron = new GlowItem(ConfigSettings.itemGlowIronID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowironItem");
		itemGlowMolt = new GlowItem(ConfigSettings.itemGlowMoltID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowmoltItem");
		itemRedMolt = new GlowItem(ConfigSettings.itemRedMoltID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redmoltItem");
		itemGlowRed = new GlowItem(ConfigSettings.itemGlowRedID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowredItem");
		itemRedIron = new GlowItem(ConfigSettings.itemRedIronID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redironItem");
		itemScepterTip = new GlowItem(ConfigSettings.itemScepterTipID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("SceptertipItem");
		itemRedIronHandle = new GlowItem(ConfigSettings.itemRedIronHandleID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("RedironhandleItem");
		itemPorkApple = new GlowFood(ConfigSettings.itemPorkAppleID, 10, 0.9F, true).setPotionEffect(Potion.resistance.id, 5, 0, 0.5F).setUnlocalizedName("PorkappleItem");
		gemCandentinium = new GlowItem(ConfigSettings.gemCandentiniumID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("CandentiniumGem");
		nuggetGlowIron = new GlowItem(ConfigSettings.nuggetGlowIronID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("glowironNugget");
		nuggetRedIron = new GlowItem(ConfigSettings.nuggetRedIronID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("redironNugget");
		itemCalcitePure = new GlowItem(ConfigSettings.itemCalcitePureID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("pureCalciteItem");
		itemCloakCore = new GlowItem(ConfigSettings.itemCloakCoreID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("cloakCore");
		itemLightReflector = new GlowItem(ConfigSettings.itemLightReflectorID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("ReflectorItem");
		itemDarkDoor = new ItemDarkDoor(ConfigSettings.itemDarkDoorID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("darkDoorItem");
		itemInfernalCoal = new GlowItem(ConfigSettings.itemInfernalCoalID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("InfernalCoalItem");
		shardBlueGlass = new GlowItem(ConfigSettings.shardBlueGlassID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("blueglassShard");
		itemBlueFertilizer = new GlowItem(ConfigSettings.itemBlueFertilizerID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("bluefertilizerItem");
				
		//Glow Iron Tools
		EnumToolMaterial EnumToolMaterialGlowiron = EnumHelper.addToolMaterial("Glowiron", 2, 650, 10.0F, 3, 18);
		itemGlironSword = new ItemGlironSword(ConfigSettings.itemGlironSwordID, EnumToolMaterialGlowiron).setUnlocalizedName("glironswordItem");
		itemGlironPick = new ItemGlironPick(ConfigSettings.itemGlironPickID, EnumToolMaterialGlowiron).setUnlocalizedName("glironpickItem");
		itemGlironShovel = new ItemGlironShovel(ConfigSettings.itemGlironShovelID, EnumToolMaterialGlowiron).setUnlocalizedName("glironshovelItem");
		itemGlironAxe = new ItemGlironAxe(ConfigSettings.itemGlironAxeID, EnumToolMaterialGlowiron).setUnlocalizedName("glironaxeItem");
		itemGlironHoe = new ItemGlironHoe(ConfigSettings.itemGlironHoeID, EnumToolMaterialGlowiron).setUnlocalizedName("glironhoeItem");
		
		//Red Iron Tools
		EnumToolMaterial EnumToolMaterialRediron = EnumHelper.addToolMaterial("Rediron", 2, 300, 5.0F, 5, 25);
		itemRedironSword = new ItemRedironSword(ConfigSettings.itemRedironSwordID, EnumToolMaterialRediron).setUnlocalizedName("redironswordItem");
		itemRedironPick = new ItemRedironPick(ConfigSettings.itemRedironPickID, EnumToolMaterialRediron).setUnlocalizedName("redironpickItem");
		itemRedironShovel = new ItemRedironShovel(ConfigSettings.itemRedironShovelID, EnumToolMaterialRediron).setUnlocalizedName("redironshovelItem");
		itemRedironAxe = new ItemRedironAxe(ConfigSettings.itemRedironAxeID, EnumToolMaterialRediron).setUnlocalizedName("redironaxeItem");
		itemRedironHoe = new ItemRedironHoe(ConfigSettings.itemRedironHoeID, EnumToolMaterialRediron).setUnlocalizedName("redironhoeItem");
				
		//Scepters
		EnumToolMaterial EnumToolMaterialScepter = EnumHelper.addToolMaterial("Scepter", -1, -1, 0F, 0, -1);
		itemScepterLight = new GlowScepter(ConfigSettings.itemScepterLightID, EnumToolMaterialScepter).setUnlocalizedName("LightscepterItem");
		itemScepterRegen = new GlowScepter(ConfigSettings.itemScepterRegenID, EnumToolMaterialScepter).setUnlocalizedName("RegenscepterItem");
		itemScepterRegen2 = new GlowScepter(ConfigSettings.itemScepterRegen2ID, EnumToolMaterialScepter).setUnlocalizedName("Regenscepter2Item");
		itemScepterOmni = new GlowScepter(ConfigSettings.itemScepterOmniID, EnumToolMaterialScepter).setUnlocalizedName("OmniscepterItem");
		
		/** Armor Section (Max Damage before it breaks, Damage Reduction, Enchantability) */
		
		//Glow Iron Armor
		EnumArmorMaterial EnumArmorMaterialGlowiron = EnumHelper.addArmorMaterial("Glowiron", 25, new int[] {2, 7, 6, 2}, 18);
		itemGlironHelm = new GlironArmor(ConfigSettings.itemGlironHelmID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 0).setUnlocalizedName("GlironHelm");
		itemGlironChest = new GlironArmor(ConfigSettings.itemGlironChestID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 1).setUnlocalizedName("GlironChest");
		itemGlironLegs = new GlironArmor(ConfigSettings.itemGlironLegsID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 2).setUnlocalizedName("GlironLegs");
		itemGlironBoots = new GlironArmor(ConfigSettings.itemGlironBootsID, EnumArmorMaterialGlowiron, GlowTools.proxy.addArmor("Gliron"), 3).setUnlocalizedName("GlironBoots");
		
		//Cloaks
		EnumArmorMaterial EnumArmorMaterialCloak = EnumHelper.addArmorMaterial("Cloak", -1, new int[] {0, 2, 0, 0}, -1);
		itemCloakInvis = new ItemCloakInvis(ConfigSettings.itemCloakInvisID, EnumArmorMaterialCloak, GlowTools.proxy.addArmor("Cloak"), 1).setUnlocalizedName("CloakInvis");
		GameRegistry.addRecipe(new ItemStack(itemCloakInvis), new Object[]{"XXX", "XYX", "XXX", 'X', itemLightReflector, 'Y', itemCloakCore});
		
	}
	
	public static void postInit(){
		
		/**
		 * Thaumcraft Aspects
		 */
		
		
		ThaumcraftApi.registerObjectTag(itemGlowMolt.itemID, -1, (new ObjectTags()).add(EnumTag.LIGHT, 3).add(EnumTag.VISION, 1).add(EnumTag.FIRE, 1));
		ThaumcraftApi.registerObjectTag(itemRedMolt.itemID, -1, (new ObjectTags()).add(EnumTag.MECHANISM, 2).add(EnumTag.POWER, 2).add(EnumTag.FIRE, 1));
		
	}
	
}