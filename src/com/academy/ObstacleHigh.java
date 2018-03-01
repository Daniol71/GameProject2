package com.academy;

public class ObstacleHigh extends Obstacles{
    public ObstacleHigh(){

        setAppearance();

    }

    private void setAppearance(){

        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-6, '#'));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-6, '#'));
        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-7, '#'));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-7, '#'));

    }
}
