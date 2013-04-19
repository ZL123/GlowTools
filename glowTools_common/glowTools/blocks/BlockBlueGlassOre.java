package glowTools.blocks;

import glowTools.GlowTools;
import glowTools.items.GTItems;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBlueGlassOre extends BlockOre
{
	public BlockBlueGlassOre(int par1) {
		super(par1);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	public int idDropped(int par1, Random rand, int par3)
	{
		return GTItems.BlueGlassShard.itemID;
	}
	
	public int quantityDropped(Random rand)
	{
		return 2 + rand.nextInt(3);
	}
	
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int j1 = 0;
            j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 4);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("glowTools:tile.NetherBlueOre");
    }
}
