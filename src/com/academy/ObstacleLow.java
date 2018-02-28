package com.academy;

import java.util.ArrayList;

public class ObstacleLow extends Obstacles {

    public ObstacleLow(){

        this.pointList = setAppearance();

    }

    private ArrayList setAppearance(){

        ArrayList<Point> bodyList = new ArrayList<>();

        bodyList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-4, '#'));
        bodyList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-4, '#'));
        bodyList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-5, '#'));
        bodyList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-5, '#'));

        return bodyList;
    }

}
