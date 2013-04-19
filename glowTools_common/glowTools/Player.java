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
