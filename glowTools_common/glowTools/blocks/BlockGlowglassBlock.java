/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import glowTools.GlowTools;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGlowglassBlock extends BlockGlass
{

	public BlockGlowglassBlock(int par1, Material par2Material, boolean par3)
	{
		super(par1, par2Material, par3);
		this.setLightValue(1.0F);
		this.setStepSound(soundGlassFootstep);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("glass");
    }
}
