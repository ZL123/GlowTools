package glowTools.blocks;

import glowTools.GlowTools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGlowironBlock extends Block
{
	public BlockGlowironBlock(int par1)
	{
		super(par1, Material.iron);
		this.setCreativeTab(GlowTools.tabGlowTools);
		this.setLightValue(4);
		this.setHardness(5F);
		this.setStepSound(soundMetalFootstep);
		this.setResistance(32F);
	}
	
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}
