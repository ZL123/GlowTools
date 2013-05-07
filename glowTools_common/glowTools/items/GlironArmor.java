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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlironArmor extends ItemArmor
{
	public GlironArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if(stack.itemID == GTItems.itemGlironHelm.itemID ||stack.itemID == GTItems.itemGlironChest.itemID ||stack.itemID == GTItems.itemGlironBoots.itemID)
		{return "/mods/glowTools/textures/models/glowiron_1.png";}
		if(stack.itemID == GTItems.itemGlironLegs.itemID)
		{return "/mods/glowTools/textures/models/glowiron_2.png";}
		else return "/glowTools/textures/models/glowiron_2.png";
	}
}