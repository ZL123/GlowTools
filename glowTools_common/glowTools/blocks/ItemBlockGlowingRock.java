/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGlowingRock extends ItemBlock {
	
	private final static String[] subNames = {"sandstone", "cobblestone", "stone"};
	
	public ItemBlockGlowingRock(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		String name = "";
		switch(stack.getItemDamage())
		{
			case 0:
			{
				name = "sandstone";
				break;
			}
			case 1:
			{
				name = "cobblestone";
				break;
			}
			case 2:
			{
				name = "stone";
				break;
			}
			default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1) {
		return par1;
	}
}
