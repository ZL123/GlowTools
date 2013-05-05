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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockFlowStoneBlock extends Block
{
	public BlockFlowStoneBlock(int par1) {
		super(par1,Material.rock);
		this.slipperiness = 0.9F;
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}