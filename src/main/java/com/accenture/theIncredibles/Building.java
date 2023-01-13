package com.accenture.theIncredibles;

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Building {

    private double x;
    private double y;
    private int rectWidth;

    private boolean run = false;

    void building(double leftX, double groundY, int units, int floors, int windowType, int roofType, double scale, CodeDraw cd, Window window, Roof roof) {

        double width = (units * 16) + (4 * 2);
        double height = (floors * 16) + (4 * 2);

        y = (groundY - height);

        int color = (int) Math.round(153 * scale);
        cd.setColor(Palette.fromRGB(color, color, color));
        cd.fillRectangle(leftX, y, width, height);

        window.setX(x + 4);
        window.setY(y + 4);
        for (int j = 0; j < floors; ++j) {
            for (int i = 0; i < units; ++i) {
                setRun(false);
                window.draw(windowType, cd);
                window.move(16, 0);
            }
            window.setX(x + 4);
            window.move(0, 16);
        }
        roof.draw(width, roofType, scale, cd);
    }

    void row(double scale, int ground, CodeDraw cd, Window window, Roof roof) {
        scale(scale, scale);
        int x = 0;
        double end = (1000 / scale);
        while (x < end) {
            int units = randomInteger(4, 10);
            int floors = randomInteger(5, 18);
            int windowType = randomInteger(0, 4);
            int roofType = randomInteger(0, 4);

            this.x = x;
            building(this.x, (ground / scale), units, floors, windowType, roofType, scale, cd, window, roof);
            x += (units * 16) + (4 * 2) + 12;
        }
    }

    // H E L P - M E T H O D S
    int randomInteger(int min, int max) {
        return (int) (min + Math.floor(Math.random() * (max - min)));
    }

    void gradient(CodeDraw cd) {
        Color color1 = Palette.fromRGB(255, 255, 224);
        Color color2 = Palette.fromRGB(0, 1, 18);

        int steps = 30;
        for (int i = 0; i < steps; i++) {
            float ratio = (float) i / (float) steps;
            int red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            int green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            int blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
            Color stepColor = new Color(red, green, blue);
            cd.setColor(stepColor);
            cd.fillRectangle(getRectWidth() * i, 0, 1000, 400);
        }
    }

    void scale(double x, double y) {
        setY(getY() * (1 - y));
        setX(getX() * (1 - x));
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

    public int getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(int rectWidth) {
        if (rectWidth > 2000) {
            rectWidth = 1;
        }
        this.rectWidth = rectWidth;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

}
