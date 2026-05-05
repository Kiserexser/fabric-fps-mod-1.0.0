
package com.example.mod;

import com.google.gson.Gson;
import java.io.*;

public class Config {

    public static boolean particlesOff = true;
    public static boolean hideEntities = false;

    private static final File file = new File("config/fpsmod.json");
    private static final Gson gson = new Gson();

    public static void save() {
        try {
            file.getParentFile().mkdirs();
            FileWriter w = new FileWriter(file);
            gson.toJson(new Data(particlesOff, hideEntities), w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try {
            if (!file.exists()) return;
            FileReader r = new FileReader(file);
            Data d = gson.fromJson(r, Data.class);
            particlesOff = d.particlesOff;
            hideEntities = d.hideEntities;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Data {
        boolean particlesOff;
        boolean hideEntities;

        Data(boolean p, boolean h) {
            this.particlesOff = p;
            this.hideEntities = h;
        }
    }
}
