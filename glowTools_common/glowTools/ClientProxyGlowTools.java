package glowTools;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import glowTools.CommonProxyGlowTools;

public class ClientProxyGlowTools extends CommonProxyGlowTools
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySkidglow.class, new RenderSkidglow(new ModelSkidglow(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFallglowsand.class, new RenderFallglowsand());
	}
	public void registerClientTickHandler()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	
	public int addArmor(String Armor)
	{return RenderingRegistry.addNewArmourRendererPrefix(Armor);}
}
