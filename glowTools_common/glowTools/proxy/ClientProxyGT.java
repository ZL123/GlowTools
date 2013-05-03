/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import glowTools.ClientTickHandler;
import glowTools.ModelSkidglow;
import glowTools.RenderFallglowsand;
import glowTools.RenderSkidglow;
import glowTools.entity.EntityFallglowsand;
import glowTools.entity.EntitySkidglow;
import glowTools.proxy.CommonProxyGT;

public class ClientProxyGT extends CommonProxyGT
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
