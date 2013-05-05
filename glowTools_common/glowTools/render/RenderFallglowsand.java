/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.render;

import glowTools.entity.EntityFallglowsand;
import net.minecraft.client.renderer.entity.RenderFallingSand;

public class RenderFallglowsand extends RenderFallingSand
{
	public void doRender(EntityFallglowsand var1, double var2, double var4, double var6,
			float var8, float var9) {
		this.doRenderFallingSand(var1, var2, var4, var6, var8, var9);
	}
}

