
package com.example.mod;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen {

    public ConfigScreen() {
        super(Text.literal("FPS Mod"));
    }

    @Override
    protected void init() {

        addDrawableChild(ButtonWidget.builder(
                Text.literal("Particles: " + Config.particlesOff),
                b -> {
                    Config.particlesOff = !Config.particlesOff;
                    Config.save();
                    client.setScreen(new ConfigScreen());
                }
        ).dimensions(width / 2 - 100, 60, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(
                Text.literal("Hide Entities: " + Config.hideEntities),
                b -> {
                    Config.hideEntities = !Config.hideEntities;
                    Config.save();
                    client.setScreen(new ConfigScreen());
                }
        ).dimensions(width / 2 - 100, 90, 200, 20).build());
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
