/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlowItem extends Item
{
	public GlowItem(int par1)
	{
		super(par1);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if (this.itemID == GTItems.shardBlueGlass.itemID)
    	{
    		this.itemIcon = par1IconRegister.registerIcon("glowTools:item.NetherBlueShard");
    	}
    	else
    	{
    		this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    	}
    }
}
