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
import glowTools.entity.EntityFallglowsand;
import glowTools.entity.EntitySkidglow;
import glowTools.model.ModelSkidglow;
import glowTools.proxy.CommonProxyGT;
import glowTools.render.RenderFallglowsand;
import glowTools.render.RenderSkidglow;
import glowTools.tick.ClientTickHandler;

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
