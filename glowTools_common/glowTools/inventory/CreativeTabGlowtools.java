/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.inventory;

import glowTools.items.GTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabGlowtools extends CreativeTabs {

	public CreativeTabGlowtools(String label) {
		super(label);
	}
	
	public ItemStack getIconItemStack()
	{
		return new ItemStack(GTItems.itemScepterLight);
	}

}
