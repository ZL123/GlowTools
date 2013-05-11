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
	public static Item itemPorkApple;
	public static Item itemDarkDoor;
	public static Item itemBlueFertilizer;
	public static Item craftingItems;
	
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
		itemPorkApple = new GlowFood(ConfigSettings.itemPorkAppleID, 10, 0.9F, true).setPotionEffect(Potion.resistance.id, 5, 0, 0.5F).setUnlocalizedName("PorkappleItem");
		itemDarkDoor = new ItemDarkDoor(ConfigSettings.itemDarkDoorID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("darkDoorItem");
		itemBlueFertilizer = new GlowItem(ConfigSettings.itemBlueFertilizerID).setCreativeTab(Reference.CREATIVETAB).setUnlocalizedName("bluefertilizerItem");
		craftingItems = new CraftingItems(ConfigSettings.craftingItemsID).setCreativeTab(Reference.CREATIVETAB);
		
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
		
	}
	
	public static void postInit(){
		
		/**
		 * Thaumcraft Aspects
		 */
		
		
		ThaumcraftApi.registerObjectTag(craftingItems.itemID, 2, (new ObjectTags()).add(EnumTag.LIGHT, 3).add(EnumTag.VISION, 1).add(EnumTag.FIRE, 1));
		ThaumcraftApi.registerObjectTag(craftingItems.itemID, 3, (new ObjectTags()).add(EnumTag.MECHANISM, 2).add(EnumTag.POWER, 2).add(EnumTag.FIRE, 1));
		
	}
	
}