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
import glowTools.blocks.GTBlocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlowScepter extends ItemTool
{
	public static final Block[] effectiveAgainst = new Block[] {};
	public static final int dmgVsEntity = 0;
	
	public GlowScepter(int i, EnumToolMaterial par2EnumToolMaterial)
	{
		super(i, dmgVsEntity, par2EnumToolMaterial, effectiveAgainst);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if(this.itemID == GTItems.itemScepterOmni.itemID)
        {
        	par3List.add("May you use thine precious");
        	par3List.add("staff bequeathen to thee");
        	par3List.add("as thine righteous guardian");
        	par3List.add("and protector to the fullness");
        	par3List.add("of all thine Kingdom.");
        }
        else if(this.itemID == GTItems.itemScepterRegen.itemID)
        {
        	par3List.add("Assists thee in thine");
        	par3List.add("beast-slaying duties.");
        }
        else if(this.itemID == GTItems.itemScepterRegen2.itemID)
        {
        	par3List.add("Relieves thee of thine");
        	par3List.add("wounds of mortality.");
        }
        else if(this.itemID == GTItems.itemScepterLight.itemID)
        {
        	par3List.add("Brings forth the light");
            par3List.add("so it shall shine upon thee.");
        }
    }
	
	@Override
    public String getItemDisplayName(ItemStack stack) {
		if (this.itemID == GTItems.itemScepterLight.itemID)
		{
			return EnumChatFormatting.GOLD + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.itemScepterRegen.itemID)
		{
			return EnumChatFormatting.RED + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.itemScepterRegen2.itemID)
		{
			return EnumChatFormatting.DARK_PURPLE + super.getItemDisplayName(stack);
		}
		else if (this.itemID == GTItems.itemScepterOmni.itemID)
		{
			return EnumChatFormatting.GREEN + super.getItemDisplayName(stack);
		}
		else return super.getItemDisplayName(stack);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if (this.itemID == GTItems.itemScepterLight.itemID)
		{
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	        {
	            return false;
	        }
	        else
	        {
	            int var11 = par3World.getBlockId(par4, par5, par6);
	            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

	            if (par7 == 0 || var12 != 0 || var11 != GTBlocks.blockCandentinium.blockID)
	            {
	                return false;
	            }
	            else
	            {
	                GlowTools.giveItemToPlayer(par2EntityPlayer, new ItemStack(GTItems.itemScepterLight));
	                par3World.setBlockToAir(par4, par5, par6);
	                return true;
	            }
	        }
		}
		else return false;
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}
