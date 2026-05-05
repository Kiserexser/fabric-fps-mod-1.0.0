
package com.example.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class FPSMod implements ClientModInitializer {

    public static KeyBinding key;

    @Override
    public void onInitializeClient() {

        key = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("Open FPS Menu", GLFW.GLFW_KEY_RIGHT_SHIFT, "FPS Mod")
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (key.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new ConfigScreen());
            }
        });
    }
}
