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

public class ItemBlockGlowingWood extends ItemBlock {
	
	private final static String[] subNames = {"plankOak", "logOak", "plankSpruce",
		"logSpruce", "plankBirch", "logBirch",  "plankJungle", "logJungle"};
	
	public ItemBlockGlowingWood(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "." + subNames[stack.getItemDamage()];
	}
	
	public int getMetadata(int par1) {
		return par1;
	}
}
