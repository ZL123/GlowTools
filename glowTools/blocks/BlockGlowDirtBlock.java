package glowTools.blocks;

import glowTools.GlowTools;
import net.minecraft.block.BlockDirt;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

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
