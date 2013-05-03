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

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockGlowSandStoneBlock extends BlockSandStone
{
    public BlockGlowSandStoneBlock(int par1)
    {
        super(par1);
        this.setCreativeTab(GlowTools.tabGlowTools);
        this.setStepSound(soundStoneFootstep);
        this.setLightValue(1.0F);
    }
}
