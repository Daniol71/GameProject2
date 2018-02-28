package com.academy;

import java.util.ArrayList;

public class Player extends GameEntity {

    public Player(){

        this.pointList = setAppearance();

    }

    private ArrayList setAppearance(){

        ArrayList<Point> bodyList = new ArrayList<>();

        bodyList.add(new Point(8, GameEngine.ROWS-4, 'o'));
        bodyList.add(new Point(6, GameEngine.ROWS-4, 'o'));
        bodyList.add(new Point(7, GameEngine.ROWS-5, 'o'));
        bodyList.add(new Point(7, GameEngine.ROWS-6, 'o'));
        bodyList.add(new Point(8, GameEngine.ROWS-6, 'o'));
        bodyList.add(new Point(6, GameEngine.ROWS-6, 'o'));
        bodyList.add(new Point(7, GameEngine.ROWS-7, 'o'));

        return bodyList;
    }

}
