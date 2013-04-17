package glowTools;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFallingSand;
import net.minecraft.entity.Entity;

public class RenderFallglowsand extends RenderFallingSand
{
	public void doRender(EntityFallglowsand var1, double var2, double var4, double var6,
			float var8, float var9) {
		this.doRenderFallingSand(var1, var2, var4, var6, var8, var9);
	}
}

