package glowTools;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxyGlowTools
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
