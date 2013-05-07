/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import java.util.Random;

import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowFarmland extends BlockFarmland
{
    @SideOnly(Side.CLIENT)
    private Icon field_94441_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94440_b;
	
	public BlockGlowFarmland(int par1) {
		super(par1);
	}
	
    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 6; l <= par2 + 6; ++l)
        {
            for (int i1 = par3 - 1; i1 <= par3 + 1; ++i1)
            {
                for (int j1 = par4 - 6; j1 <= par4 + 6; ++j1)
                {
                    if (par1World.getBlockMaterial(l, i1, j1) == Material.water)
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GTBlocks.blockGlowDirt.idDropped(0, par2Random, par3);
    }
    
    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return GTBlocks.blockGlowDirt.blockID;
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94441_a = par1IconRegister.registerIcon("glowTools:GlowFarmland");
        this.field_94440_b = par1IconRegister.registerIcon("glowTools:GlowFarmland_wet");
    }
}
