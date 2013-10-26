/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.lib;

import glowTools.GlowTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class Reference {
	
	public static final String MODID = "GlowTools by ZL123";
	public static final String MODNAME = "GlowTools";
	public static final String VERSION = "0.4";
	public static final String CHANNELNAME = MODID;
	public static final String SERVERPROXY = "glowTools.proxy.CommonProxyGT";
	public static final String CLIENTPROXY = "glowTools.proxy.ClientProxyGT";
	public static final String PACKETCHANNEL_GT = "GTPacket";
	public static final String DEPENDENCIES = "required-after:Forge@[9.10.1.849,)";
	
	public static final int ENTITYID_SKIDGLOW = 5;
	public static final int FUELAMOUNT_GLOWMOLT = 8;
	public static final int FUELAMOUNT_BLAZEMOLT = 30;
	public static final int FUELAMOUNT_TORCH = 1;
	public static final int GSINFUSER_GLOWFUEL_CAPACITY = 360;
	
	public static final CreativeTabs CREATIVETAB = GlowTools.tabGlowTools;
	
	public static final ResourceLocation GSINFUSERGUI_LOC = new ResourceLocation("/assets/glowTools/textures/gui/gui.gsInfuser.png");
	public static final ResourceLocation SKIDGLOW_SKIN_LOC = new ResourceLocation("/assets/glowTools/textures/models/Skidglow.png");
}
