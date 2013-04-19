package glowTools;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSkidglow extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
    ModelRenderer Leg7;
    ModelRenderer Leg8;
    ModelRenderer Leg9;
    ModelRenderer Leg10;
    ModelRenderer Leg11;
    ModelRenderer Leg12;
    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer End;
  
  public ModelSkidglow()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Leg1 = new ModelRenderer(this, 2, 8);
      Leg1.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg1.setRotationPoint(1.5F, 21F, -3.2F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = false;
      setRotation(Leg1, 0F, -2.472378F, -0.3717861F);
      Leg2 = new ModelRenderer(this, 2, 11);
      Leg2.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg2.setRotationPoint(1.5F, 21F, -1.8F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = false;
      setRotation(Leg2, 0F, -2.806985F, -0.3717861F);
      Leg3 = new ModelRenderer(this, 0, 16);
      Leg3.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg3.setRotationPoint(2.4F, 21F, -0.4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = false;
      setRotation(Leg3, 0F, -3.141593F, -0.3717861F);
      Leg4 = new ModelRenderer(this, 0, 20);
      Leg4.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg4.setRotationPoint(2F, 21F, 1F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = false;
      setRotation(Leg4, 0F, 2.825574F, -0.3717861F);
      Leg5 = new ModelRenderer(this, 0, 24);
      Leg5.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg5.setRotationPoint(1.2F, 21F, 2.1F);
      Leg5.setTextureSize(64, 32);
      Leg5.mirror = false;
      setRotation(Leg5, 0F, 2.490967F, -0.3717861F);
      Leg6 = new ModelRenderer(this, 7, 27);
      Leg6.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg6.setRotationPoint(1.1F, 21F, 2.9F);
      Leg6.setTextureSize(64, 32);
      Leg6.mirror = false;
      setRotation(Leg6, 0F, 2.193538F, -0.3717861F);
      Leg7 = new ModelRenderer(this, 32, 8);
      Leg7.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg7.setRotationPoint(-2F, 21F, -3.7F);
      Leg7.setTextureSize(64, 32);
      setRotation(Leg7, 0F, -0.6878043F, -0.3717861F);
      Leg7.mirror = false;
      Leg8 = new ModelRenderer(this, 32, 11);
      Leg8.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg8.setRotationPoint(-2.4F, 21F, -2.6F);
      Leg8.setTextureSize(64, 32);
      Leg8.mirror = false;
      setRotation(Leg8, 0F, -0.1673038F, -0.3717861F);
      Leg9 = new ModelRenderer(this, 36, 16);
      Leg9.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg9.setRotationPoint(-3F, 21F, -1.4F);
      Leg9.setTextureSize(64, 32);
      Leg9.mirror = false;
      setRotation(Leg9, 0F, -0.0557679F, -0.3717861F);
      Leg10 = new ModelRenderer(this, 36, 20);
      Leg10.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg10.setRotationPoint(-3F, 21F, 0.1F);
      Leg10.setTextureSize(64, 32);
      Leg10.mirror = false;
      setRotation(Leg10, 0F, 0.2974289F, -0.3717861F);
      Leg11 = new ModelRenderer(this, 36, 24);
      Leg11.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg11.setRotationPoint(-2.7F, 21F, 1.4F);
      Leg11.setTextureSize(64, 32);
      Leg11.mirror = false;
      setRotation(Leg11, 0F, 0.4833219F, -0.3717861F);
      Leg12 = new ModelRenderer(this, 26, 27);
      Leg12.addBox(-6F, 0F, 0F, 6, 1, 1);
      Leg12.setRotationPoint(-3F, 21F, 2.4F);
      Leg12.setTextureSize(64, 32);
      Leg12.mirror = false;
      setRotation(Leg12, 0F, 0.8551081F, -0.3717861F);
      Head = new ModelRenderer(this, 16, 4);
      Head.addBox(-1.5F, -1.5F, -1.5F, 4, 4, 4);
      Head.setRotationPoint(-1F, 21F, -6F);
      Head.setTextureSize(64, 32);
      Head.mirror = false;
      setRotation(Head, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 19, 12);
      Neck.addBox(-1F, -1F, -1F, 3, 3, 2);
      Neck.setRotationPoint(-1F, 21.5F, -2.5F);
      Neck.setTextureSize(64, 32);
      Neck.mirror = false;
      setRotation(Neck, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 14, 17);
      Body.addBox(-2F, -1F, -2F, 5, 3, 6);
      Body.setRotationPoint(-1F, 21.5F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = false;
      setRotation(Body, 0F, 0F, 0F);
      End = new ModelRenderer(this, 19, 26);
      End.addBox(-1.5F, -1F, -1F, 3, 2, 2);
      End.setRotationPoint(-0.5F, 22.5F, 5F);
      End.setTextureSize(64, 32);
      End.mirror = false;
      setRotation(End, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    Leg1.render(par7);
    Leg2.render(par7);
    Leg3.render(par7);
    Leg4.render(par7);
    Leg5.render(par7);
    Leg6.render(par7);
    Leg7.render(par7);
    Leg8.render(par7);
    Leg9.render(par7);
    Leg10.render(par7);
    Leg11.render(par7);
    Leg12.render(par7);
    Head.render(par7);
    Neck.render(par7);
    Body.render(par7);
    End.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }
}
