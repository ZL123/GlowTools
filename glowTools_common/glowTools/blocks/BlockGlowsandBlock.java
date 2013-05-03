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
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.world.World;

public class BlockGlowsandBlock extends BlockSand
{
    public static boolean fallInstantly = false;
	
	public BlockGlowsandBlock(int par1)
	{
		super(par1, Material.sand);
		this.setCreativeTab(GlowTools.tabGlowTools);
		this.setLightValue(1.0F);
		this.setHardness(0.5F);
		this.setStepSound(soundSandFootstep);
		this.setResistance(3F);
	}
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("sand");
    }
}
