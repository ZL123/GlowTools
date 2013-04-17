package glowTools.items;

import glowTools.GlowTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GlowItem extends Item
{
	public GlowItem(int par1)
	{
		super(par1);
	}
	
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	if (this.itemID == GlowTools.BlueGlassShard.itemID)
    	{
    		this.iconIndex = par1IconRegister.registerIcon("glowTools:item.NetherBlueShard");
    	}
    	else
    	{
    		this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    	}
    }
}
