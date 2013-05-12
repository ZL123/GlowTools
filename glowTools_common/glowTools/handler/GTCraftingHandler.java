/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.handler;

import glowTools.achievement.GTAchievements;
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class GTCraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix) {
		
		if(stack.itemID == GTItems.craftingItems.itemID && stack.getItemDamage() == CraftingItems.scepterTipMetaNumber) {

			player.addStat(GTAchievements.buildScepterTip, 1);
		}
		else if(stack.itemID == GTItems.itemScepterLight.itemID) {
			player.addStat(GTAchievements.buildLightScepter, 1);
		}
		else if(stack.itemID == GTItems.itemScepterRegen.itemID) {
			player.addStat(GTAchievements.buildRegenScepter, 1);
		}
		else if(stack.itemID == GTItems.itemScepterRegen2.itemID) {
			player.addStat(GTAchievements.buildRegen2Scepter, 1);
		}
		else if(stack.itemID == GTItems.itemScepterOmni.itemID) {
			player.addStat(GTAchievements.buildOmniScepter, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}

}
