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
import net.minecraft.block.BlockDirt;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockGlowDirtBlock extends BlockDirt
{
	public BlockGlowDirtBlock(int par1) {
		super(par1);
		this.setStepSound(soundGravelFootstep);
		this.setHardness(0.6F);
		this.setLightValue(0.9F);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("dirt");
    }
}
