/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.handler;

import glowTools.gui.GuiGsInfuser;
import glowTools.inventory.ContainerGsInfuser;
import glowTools.tileentity.TileEntityGsInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{	
	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityGsInfuser){
                    return new ContainerGsInfuser(player.inventory, (TileEntityGsInfuser) tileEntity);
            }
            return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityGsInfuser){
                    return new GuiGsInfuser(player.inventory, (TileEntityGsInfuser) tileEntity);
            }
            return null;
    }
}
