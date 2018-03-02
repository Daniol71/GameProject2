package com.academy;

import java.util.ArrayList;

public class ObstacleLow extends Obstacles {

    public ObstacleLow(){

        setAppearance();

    }

    private void setAppearance(){

        int rand = (int) (Math.random()*15+1);

        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-5, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-5, '\u2588',rand,rand));

    }

}
