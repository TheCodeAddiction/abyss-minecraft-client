package net.ca.abyss;

import net.ca.abyss.Exploits.Teleport;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class AbyssClient implements ClientModInitializer {
    private static KeyBinding keyBindingU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.abyss.u",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_U,
            "category.abyss.test"
    ));

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBindingU.wasPressed()) {
                double x = client.player.getX();
                double y = client.player.getY();
                double z = client.player.getZ();
                Vec3d vec3d = new Vec3d(0, 2, 0);
                //client.player.move(MovementType.PLAYER, vec3d);
                Teleport fly = new Teleport();
                fly.sendFlyPacket(x,y+10,z,false);


            }
        });
    }
}
