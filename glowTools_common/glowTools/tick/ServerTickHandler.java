/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.tick;

import glowTools.items.GTItems;
import glowTools.lib.Reference;
import glowTools.tileentity.TileEntityGsInfuser;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{
	private void onPlayerTick(EntityPlayer player) {
		ItemStack hand = player.getCurrentItemOrArmor(0);
		ItemStack boots = player.getCurrentItemOrArmor(1);
		ItemStack legs = player.getCurrentItemOrArmor(2);
		ItemStack chest = player.getCurrentItemOrArmor(3);
		ItemStack helm = player.getCurrentItemOrArmor(4);
		
		if(player.getCurrentItemOrArmor(0) != null) {
			
			if(hand.getItem() == GTItems.itemScepterLight) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 304, 0));
			}
			
			if(hand.getItem() == GTItems.itemScepterRegen) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 304, 2));
			}
			
			if(hand.getItem() == GTItems.itemScepterRegen2) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1204, 4));
			}
			
			if(hand.getItem() == GTItems.itemScepterOmni) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1204, 5));
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1204, 1));
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1204, 1));
			}
			
			
		}
		
		if(player.getCurrentItemOrArmor(3) != null) {
			if(chest.getItem() == GTItems.itemCloakInvis) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 34, 0));
			}
			
		}
		
		
		
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER)))
		{
			onPlayerTick((EntityPlayer) tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return Reference.MODID + ": " + getClass().getSimpleName();
	}
}
