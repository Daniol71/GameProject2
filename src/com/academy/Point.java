package com.academy;

public class Point {

    private int x;
    private int y;
    private char pixel;
    private int color;
    private int backGroundColor;

    public Point(int x, int y, char pixel, int color,int backGroundColor){

        this.x = x;
        this.y = y;
        this.pixel = pixel;
        this.color = color;
        this.backGroundColor = backGroundColor;

    }

    public char getPixel() {
        return pixel;
    }

    public void setPixel(char pixel) {
        this.pixel = pixel;
    } // for future use

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
    } // for future use

    public int getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
    } // for future use
}
