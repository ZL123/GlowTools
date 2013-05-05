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
import net.minecraft.block.BlockOreStorage;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockCandentiniumBlock extends BlockOreStorage {

	public BlockCandentiniumBlock(int par1) {
		super(par1);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
	
}
