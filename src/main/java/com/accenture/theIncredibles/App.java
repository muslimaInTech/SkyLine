package com.accenture.theIncredibles;

import codedraw.CodeDraw;
import codedraw.Palette;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.drawSkyLine();
    }

    public void drawSkyLine() {
        // Constructing animations
        CodeDraw codeDraw = new CodeDraw(1000, 400);
        Building build = new Building();
        Window window = new Window(build);
        Roof roof = new Roof(build);

        long lastSec = 0;
        while (true) {
            long sec = System.currentTimeMillis() / 1000;
            if (sec != lastSec) {
                lastSec = sec;
            }
            codeDraw.clear();
            build.gradient(codeDraw);
            build.setRectWidth(build.getRectWidth() + 100);
            codeDraw.setColor(Palette.fromRGB(204, 204, 204));
            codeDraw.fillRectangle(0, 300, 1000, 100);
            build.row(0.6, 180, codeDraw, window, roof);
            build.row(0.8, 280, codeDraw, window, roof);
            build.row(1, 390, codeDraw, window, roof);
            codeDraw.show(1000);
        }
    }
}
