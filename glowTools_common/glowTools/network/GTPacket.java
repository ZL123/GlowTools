/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.network;

import glowTools.lib.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

public abstract class GTPacket {
	
	private static final BiMap<Integer, Class<? extends GTPacket>> idMap;
    
    static {
            ImmutableBiMap.Builder<Integer, Class<? extends GTPacket>> builder = ImmutableBiMap.builder();
            
            //Packets go here:
            //				  Packet ID		  	  Packet Class
            //builder.put(Integer.valueOf(0), SomethingPacket.class);
            
            idMap = builder.build();
    }
    
    public static GTPacket constructPacket(int packetId) throws ProtocolException, ReflectiveOperationException {
        Class<? extends GTPacket> packetClass = idMap.get(Integer.valueOf(packetId));
        if (packetClass == null) {
        	throw new ProtocolException("Invalid Packet Id...!");
        } else {
        	return packetClass.newInstance();
        }
    }
    
    public final int getPacketId() {
        if (idMap.inverse().containsKey(getClass())) {
                return idMap.inverse().get(getClass()).intValue();
        } else {
                throw new RuntimeException("Packet " + getClass().getSimpleName() + " is missing a mapping...!");
        }
    }
    
    public final Packet makePacket() {
    	ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeByte(getPacketId());
        write(out);
        return PacketDispatcher.getPacket(Reference.PACKETCHANNEL_GT, out.toByteArray());
    }
    
    public abstract void write(ByteArrayDataOutput out);
    
    public abstract void read(ByteArrayDataInput in) throws ProtocolException;
    
    public abstract void execute(EntityPlayer player, Side side) throws ProtocolException;
    
    
    public static class ProtocolException extends Exception {

        public ProtocolException() {
        }

        public ProtocolException(String message, Throwable cause) {
                super(message, cause);
        }

        public ProtocolException(String message) {
                super(message);
        }

        public ProtocolException(Throwable cause) {
                super(cause);
        }
    }
}
