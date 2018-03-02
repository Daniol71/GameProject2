package com.academy;


public class ObstacleLow extends Obstacles {

    public ObstacleLow(){

        setAppearance();

    }

    public ObstacleLow(boolean addDoubles){

        setAppearanceDoubles();

    }

    private void setAppearance(){

        int rand = (int) (Math.random()*15+1);

        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+3, GameEngine.ROWS-5, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+4, GameEngine.ROWS-5, '\u2588',rand,rand));

    }

    private void setAppearanceDoubles(){

        int rand = (int) (Math.random()*15+1);

        this.pointList.add(new Point(GameEngine.COL+5, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+6, GameEngine.ROWS-4, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+5, GameEngine.ROWS-5, '\u2588',rand,rand));
        this.pointList.add(new Point(GameEngine.COL+6, GameEngine.ROWS-5, '\u2588',rand,rand));

    }

}
