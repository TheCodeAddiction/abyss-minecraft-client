package net.ca.abyss.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;

import java.util.concurrent.TimeUnit;

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
