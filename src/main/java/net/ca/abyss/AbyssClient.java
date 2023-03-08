package net.ca.abyss;

import net.ca.abyss.Exploits.Fly;
import net.ca.abyss.Exploits.Teleport;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class AbyssClient implements ClientModInitializer {
    private static final String CATEGORY = EvilMod.MODID + ".key_category";
    private static final KeyBinding keyBindingX = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            EvilMod.MODID+".x",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            CATEGORY
    ));

    private static final KeyBinding keyBindingU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            EvilMod.MODID+".u",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_U,
            CATEGORY
    ));

    @Override
    public void onInitializeClient() {
        //Teleport hotkey
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBindingU.wasPressed()) {
                Teleport teleport = new Teleport();
                teleport.sendTpPacket(10);

            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Fly fly = new Fly();
            fly.vehicleFly(client);
            fly.fly(client);
        });



    }
}
