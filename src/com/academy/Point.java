package com.academy;

public class Point {

    private int x;
    private int y;
    private char pixel;

    public Point(int x, int y, char pixel){

        this.x = x;
        this.y = y;
        this.pixel = pixel;

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
}
