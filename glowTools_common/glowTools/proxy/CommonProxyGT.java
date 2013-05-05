/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.proxy;

import glowTools.tick.ServerTickHandler;
import glowTools.tileentity.TileEntityGsInfuser;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxyGT
{	
	public void registerRenderThings(){}
	public void registerServerTickHandler()
	{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	public void registerTiles()
	{
		GameRegistry.registerTileEntity(TileEntityGsInfuser.class, "TileEntity_GlowstoneInfuser");
	}
	public int addArmor(String Armor)
	{return 0;}
}
