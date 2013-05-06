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
import net.minecraft.block.BlockSandStone;

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
