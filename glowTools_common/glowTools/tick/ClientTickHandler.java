/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.tick;

import glowTools.gui.GuiInfuser;
import glowTools.lib.Reference;
import glowTools.tileentity.TileEntityGsInfuser;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{
	private GuiInfuser guiGSInfuser;
	private TileEntityGsInfuser teGSInfuser;
	
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null)
            {
                onTickInGUI(guiscreen);
            } else {
                onTickInGame();
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
    }

    @Override
    public String getLabel() {
    	return Reference.MODID + ": " + getClass().getSimpleName();
    }

    public void onRenderTick() {}

    public void onTickInGUI(GuiScreen guiscreen) {}

    public void onTickInGame() {}
}