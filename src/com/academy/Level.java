package com.academy;

import java.util.ArrayList;

public class Level extends GameEntity {

    public Level(){

        this.pointList = setAppearance();

    }

    private ArrayList setAppearance(){

        ArrayList<Point> bodyList = new ArrayList<>();
        for(int i = 0; i < GameEngine.COL; i++){
            for (int j = GameEngine.ROWS-3; j < GameEngine.ROWS; j++) {
                bodyList.add(new Point(i,j, '*'));
            }
        }
        return bodyList;
    }



}
