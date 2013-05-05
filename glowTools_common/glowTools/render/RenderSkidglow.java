/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.render;

import glowTools.entity.EntitySkidglow;
import glowTools.model.ModelSkidglow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderSkidglow extends RenderLiving
{
	protected ModelSkidglow model;
	
	public RenderSkidglow(ModelSkidglow par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelSkidglow)mainModel);
	}
	
    public void renderSkidglow(EntitySkidglow par1EntitySkidglow, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySkidglow, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSkidglow((EntitySkidglow)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSkidglow((EntitySkidglow)par1Entity, par2, par4, par6, par8, par9);
    }
}
