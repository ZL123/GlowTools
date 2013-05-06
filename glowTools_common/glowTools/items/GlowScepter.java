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

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlowScepter extends ItemSword
{
	public GlowScepter(int i, EnumToolMaterial par2EnumToolMaterial)
	{
		super(i, par2EnumToolMaterial);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if(this.itemID == GTItems.OmniscepterItem.itemID)
        {
        	par3List.add("May you use thine precious");
        	par3List.add("staff bequeathen to thee");
        	par3List.add("as thine righteous guardian");
        	par3List.add("and protector to the fullness");
        	par3List.add("of all thine kingdom.");
        }
        else if(this.itemID == GTItems.RegenscepterItem.itemID)
        {
        	par3List.add("Assists thee in thine");
        	par3List.add("beast-slaying duties.");
        }
        else if(this.itemID == GTItems.Regenscepter2Item.itemID)
        {
        	par3List.add("Relieves thee of thine");
        	par3List.add("wounds of mortality.");
        }
    }
	
	@Override
    public String getItemDisplayName(ItemStack stack) {
		if (this.itemID == GTItems.LightscepterItem.itemID)
		{
			return EnumChatFormatting.GOLD + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.RegenscepterItem.itemID)
		{
			return EnumChatFormatting.RED + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.Regenscepter2Item.itemID)
		{
			return EnumChatFormatting.DARK_PURPLE + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.OmniscepterItem.itemID)
		{
			return EnumChatFormatting.GREEN + super.getItemDisplayName(stack);
		}
		else return null;
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}
