package com.academy;

public class ObstacleHigh extends Obstacles{

    public ObstacleHigh(){

        setAppearance();

    }

    public ObstacleHigh(boolean addDoubles){

        setAppearanceDoubles();

    }


    private void setAppearance(){

        int rand = (int) (Math.random()*15+1);

        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-6, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-6, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-7, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-7, '\u2588',rand,rand));

    }

    private void setAppearanceDoubles(){

        int rand = (int) (Math.random()*15+1);

        this.pointList.add(new Point(GameEngine.COL+5, GameEngine.ROWS-6, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+6, GameEngine.ROWS-6, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+5, GameEngine.ROWS-7, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+6, GameEngine.ROWS-7, '\u2588',rand,rand));

    }

}
