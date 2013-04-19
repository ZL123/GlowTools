package glowTools.items;

import glowTools.GlowTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class redironshovelItem extends ItemSpade
{
	public redironshovelItem(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}