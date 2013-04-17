package glowTools;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{	private void onPlayerTick(EntityPlayer player) {
		if(player.getCurrentItemOrArmor(0) != null)
		{ItemStack hand = player.getCurrentItemOrArmor(0);
		if(hand.getItem() == GlowTools.LightscepterItem)
		{player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0));}
	}
		if(player.getCurrentItemOrArmor(0) != null)
		{ItemStack hand = player.getCurrentItemOrArmor(0);
		if(hand.getItem() == GlowTools.RegenscepterItem)
		{player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 2));}
	}
		if(player.getCurrentItemOrArmor(0) != null)
		{ItemStack hand = player.getCurrentItemOrArmor(0);
		if(hand.getItem() == GlowTools.Regenscepter2Item)
		{player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 4));}
	}
		if(player.getCurrentItemOrArmor(3) != null)
		{ItemStack chest = player.getCurrentItemOrArmor(3);
		if(chest.getItem() == GlowTools.CloakInvis)
		{player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 30, 0));}
	}
		if(player.getCurrentItemOrArmor(0) != null)
		{ItemStack hand = player.getCurrentItemOrArmor(0);
		if(hand.getItem() == GlowTools.OmniscepterItem)
		{player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 5));
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200, 1));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200, 1));}
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
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return null;
	}
}
