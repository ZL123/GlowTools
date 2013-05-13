/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.achievement;

import glowTools.config.ConfigSettings;
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GTAchievements {
	
	public static Achievement buildScepterTip = new Achievement(ConfigSettings.achievementScepterTipID,
			"buildScepterTip", 0, -2, new ItemStack(GTItems.craftingItems, 1, CraftingItems.scepterTipMetaNumber),
			AchievementList.diamonds).setIndependent().registerAchievement();
	public static Achievement buildLightScepter = new Achievement(ConfigSettings.achievementLightScepterID,
			"buildLightScepter", -2, -4, GTItems.itemScepterLight, buildScepterTip).registerAchievement().setSpecial();
	public static Achievement buildRegenScepter = new Achievement(ConfigSettings.achievementRegenScepterID,
			"buildRegenScepter", -2, -3, GTItems.itemScepterRegen, buildScepterTip).registerAchievement().setSpecial();
	public static Achievement buildRegen2Scepter = new Achievement(ConfigSettings.achievementRegen2ScepterID,
			"buildRegen2Scepter", -4, -3, GTItems.itemScepterRegen2, buildRegenScepter).registerAchievement().setSpecial();
	public static Achievement buildOmniScepter = new Achievement(ConfigSettings.achievementOmniScepterID,
			"buildOmniScepter", -5, -4, GTItems.itemScepterOmni, buildRegen2Scepter).registerAchievement().setSpecial();
	public static Achievement buildCloakCore = new Achievement(ConfigSettings.achievementCloakCoreID,
			"buildCloakCore", 4, -2, new ItemStack(GTItems.craftingItems, 1, CraftingItems.cloakCoreMetaNumber),
			AchievementList.diamonds).setIndependent().registerAchievement();
	
	
	public static AchievementPage pageGlowTools = new AchievementPage("GlowTools", buildScepterTip, buildLightScepter,
			buildRegenScepter, buildRegen2Scepter, buildOmniScepter, buildCloakCore);
	
    public void addAchievementLocalizations() {
    	addAchievementName("buildScepterTip", "Scepter Tipper");
    	addAchievementDesc("buildScepterTip", "Sacrifice your Diamonds and Candentinium");
    	
    	addAchievementName("buildLightScepter", "Delightful");
    	addAchievementDesc("buildLightScepter", "Create a Scepter of Light");
    	
    	addAchievementName("buildRegenScepter", "Good for your health");
    	addAchievementDesc("buildRegenScepter", "Craft a Scepter of Regeneration");
    	
    	addAchievementName("buildRegen2Scepter", "Quite generous!");
    	addAchievementDesc("buildRegen2Scepter", "Construct a better Regeneration Scepter");
    	
    	addAchievementName("buildOmniScepter", "All-powerful");
    	addAchievementDesc("buildOmniScepter", "Put together the Ultimate Scepter!");
    	
    	addAchievementName("buildCloakCore", "Hard Core");
    	addAchievementDesc("buildCloakCore", "Use some Wool, Candentinium and Diamonds");
    }

	protected void addAchievementName(String name, String localization) {
		LanguageRegistry.instance().addStringLocalization("achievement." + name, localization);
	}
	
	protected void addAchievementDesc(String name, String description) {
		LanguageRegistry.instance().addStringLocalization("achievement." + name + ".desc", description);
	}
}
