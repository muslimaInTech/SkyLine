package com.accenture.theIncredibles;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Roof {

    Building building;

    //      R O O F

    public Roof(Building building) {
        this.building = building;
    }

    void draw(double width, int roofType, double scale, CodeDraw cd) {

        int color = (int) Math.round(153 * scale);
        cd.setColor(Palette.fromRGB(color, color, color));

        switch (roofType) {
            case 1 -> cd.fillRectangle(building.getX() + 8, building.getY() - 16, width - 16, 16);
            case 2 -> {
                double x = building.getX() + 8;
                double y = building.getY() - 24;
                cd.fillRectangle(x, y, width - 16, 24);
                double secX = x + ((width - 16) / 2) - 16;
                cd.fillRectangle(secX, y - 24, 32, 24);
                cd.fillRectangle(secX + 12, y - 56, 8, 32);
            }
            case 3 -> {
                double x = building.getX() + (width - 64) / 2;
                double y = building.getY() - 16;
                cd.fillRectangle(x, y, 64, 16);
                cd.fillTriangle(x + 16, y, x + 32, y - 64, x + 48, y);
            }
        }
    }

}
