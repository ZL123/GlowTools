package glowTools.items;

import glowTools.GlowTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class GlowFood extends ItemFood
{
    public GlowFood(int par1, int par2, float par3, boolean par4)
	{
		super(par1, par2, par3, par4);
        this.setCreativeTab(GlowTools.tabGlowTools);
	}
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}
