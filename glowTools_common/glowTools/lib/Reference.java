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

public class Reference {
	
	public static final String MODID = "ZL123_GlowTools";
	public static final String MODNAME = "GlowTools";
	public static final String VERSION = "0.3a";
	public static final String CHANNELNAME = MODID;
	public static final String SERVERPROXY = "glowTools.proxy.CommonProxyGT";
	public static final String CLIENTPROXY = "glowTools.proxy.ClientProxyGT";
	public static final String GSINFUSERGUI = "/mods/glowTools/textures/gui/gui.gsInfuser.png";
	
	public static final int ENTITYID_SKIDGLOW = 5;
	public static final int FUELAMOUNT_GLOWMOLT = 8;
	public static final int FUELAMOUNT_BLAZEMOLT = 30;
	public static final int FUELAMOUNT_TORCH = 1;
	public static final int GSINFUSER_GLOWFUEL_CAPACITY = 360;
	
	public static final CreativeTabs CREATIVETAB = GlowTools.tabGlowTools;
	
}
