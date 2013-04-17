package glowTools.blocks;

import glowTools.GlowTools;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowGrassBlock extends BlockGrass
{
	public BlockGlowGrassBlock(int par1) {
		super(par1);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.6F);
		this.setLightValue(0.9F);
		this.setTickRandomly(true);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = par2 + par5Random.nextInt(3) - 1;
                    int var8 = par3 + par5Random.nextInt(5) - 3;
                    int var9 = par4 + par5Random.nextInt(3) - 1;
                    int var10 = par1World.getBlockId(var7, var8 + 1, var9);

                    if (par1World.getBlockId(var7, var8, var9) == GlowTools.GlowDirtBlock.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
                    {
                        par1World.setBlock(var7, var8, var9, GlowTools.GlowGrassBlock.blockID);
                    }
                }
            }
        }
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GlowTools.GlowDirtBlock.idDropped(0, par2Random, par3);
    }
    
}