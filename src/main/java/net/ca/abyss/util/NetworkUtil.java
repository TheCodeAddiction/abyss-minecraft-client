package net.ca.abyss.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;

public class NetworkUtil {
    /**
     * Sends a packet
     * @param packet, the packet you want to send
     */
    public static void sendPacket(Packet<?> packet){
        if(MinecraftClient.getInstance().getNetworkHandler() != null){
            MinecraftClient.getInstance().getNetworkHandler().sendPacket(packet);
        }
    }
}
