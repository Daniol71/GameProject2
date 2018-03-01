package com.academy;

import java.util.ArrayList;

public class ObstacleLow extends Obstacles {

    public ObstacleLow(){

        setAppearance();

    }

    private void setAppearance(){

        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-4, '#'));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-4, '#'));
        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-5, '#'));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-5, '#'));

    }

}
