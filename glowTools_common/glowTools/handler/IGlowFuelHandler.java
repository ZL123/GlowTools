/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.handler;

import net.minecraft.item.ItemStack;

public interface IGlowFuelHandler {
	int getBurnTime(ItemStack fuel);
}
