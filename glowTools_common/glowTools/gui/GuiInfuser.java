/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.gui;

import glowTools.inventory.ContainerInfuser;
import glowTools.lib.Reference;
import glowTools.tileentity.TileEntityGsInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiInfuser extends GuiContainer
{
    private TileEntityGsInfuser infuserInventory;
    
    public GuiInfuser(InventoryPlayer par1InventoryPlayer, TileEntityGsInfuser par2TileEntityInfuser)
    {
        super(new ContainerInfuser(par1InventoryPlayer, par2TileEntityInfuser));
        this.infuserInventory = par2TileEntityInfuser;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.infuserInventory.isInvNameLocalized() ? this.infuserInventory.getInvName() : StatCollector.translateToLocal(this.infuserInventory.getInvName());
        fontRenderer.drawString(Integer.toString(this.infuserInventory.getGlowFuelAmount()), this.xSize / 4 - 1 - this.fontRenderer.getStringWidth(Integer.toString(this.infuserInventory.getGlowFuelAmount())) / 2, this.ySize / 3, 0xffff33);
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Reference.GSINFUSERGUI);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        
        if (this.infuserInventory.isBurning())
        {
            i1 = this.infuserInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 59, l + 38 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }
        
        i1 = this.infuserInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 87, l + 37, 176, 14, i1 + 1, 16);
    }
}
