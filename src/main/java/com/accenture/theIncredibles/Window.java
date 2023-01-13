package com.accenture.theIncredibles;

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Window {

    Building build;
    private double x;
    private double y;

    //          W I N D O W


    public Window(Building build) {
        this.build = build;
    }

    void draw(int windowType, CodeDraw cd) {
        long lastSec = 0;
        while (!build.isRun()) {
            long sec = System.currentTimeMillis() / 1000;
            if (sec != lastSec) {
                lastSec = sec;
            }

            int color = build.randomInteger(0, 3);
            if (color == 1 && build.getRectWidth() <= 200) {
                cd.setColor(Color.yellow);
            } else {
                cd.setColor(Palette.fromRGB(102, 102, 102));
            }

            switch (windowType) {
                case 0 -> cd.fillRectangle(getX() + 4, getY() + 2, 8, 10);
                case 1 -> {
                    cd.fillRectangle(getX() + 2, getY() + 3, 5, 8);
                    cd.fillRectangle(getX() + 9, getY() + 3, 5, 8);
                }
                case 2 -> cd.fillRectangle(getX(), getY() + 3, 16, 8);

                case 3 -> cd.fillRectangle(getX() + 5, getY() + 1, 6, 14);
            }
            build.setRun(true);
        }
    }

    void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
