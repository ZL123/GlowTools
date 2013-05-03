/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public abstract class Player extends EntityPlayer
{
	public Player(World par1World)
	{
		super(par1World);
	}
    public void displayGUIInfuser(IInventory par1IInventory) {}
}
