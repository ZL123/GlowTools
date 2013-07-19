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
import glowTools.lib.Reference;
import glowTools.network.GTPacket;
import glowTools.network.GTPacket.ProtocolException;

import java.util.logging.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

/**
 * Exceptional...!
 */
public class GTPacketHandler implements IPacketHandler {
	
	@Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
            try {
            	EntityPlayer entityPlayer = (EntityPlayer)player;
            	ByteArrayDataInput in = ByteStreams.newDataInput(packet.data);
            	int packetId = in.readInt();
            	GTPacket gtPacket = GTPacket.constructPacket(packetId);
            	gtPacket.read(in);
            	gtPacket.execute(entityPlayer, entityPlayer.worldObj.isRemote ? Side.CLIENT : Side.SERVER);
            } catch (ProtocolException e) {
            	if (player instanceof EntityPlayerMP) {
            		((EntityPlayerMP) player).playerNetServerHandler.kickPlayerFromServer("Protocol exception...!");
            			Logger.getLogger(Reference.CHANNELNAME).warning("Player " + ((EntityPlayer)player).username + " caused a Protocol Exception on a packet...!");
            	}
            } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Unexpected Reflection exception during Packet construction...!", e);
            }
    }

}
