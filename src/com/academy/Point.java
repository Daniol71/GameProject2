package com.academy;

public class Point {

    private int x;
    private int y;
    private char pixel;
    private int color;

    public Point(int x, int y, char pixel, int color){

        this.x = x;
        this.y = y;
        this.pixel = pixel;
        this.color = color;

    }

    public char getPixel() {
        return pixel;
    }

    public void setPixel(char pixel) {
        this.pixel = pixel;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
