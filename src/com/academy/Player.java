package com.academy;


public class Player extends GameEntity {

    private boolean isMoving = false;

    public Player() {

        setPlayerNeutral();

    }

    public void setPlayerNeutral() {

        this.pointList.clear();

        this.pointList.add(new Point(8, GameEngine.ROWS - 4, 'o',10,0));
        this.pointList.add(new Point(6, GameEngine.ROWS - 4, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 5, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(8, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(6, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 7, 'Å',7,0));

        isMoving = false;

    }

    public void setPlayerLegsTogether(){


        this.pointList.clear();

        this.pointList.add(new Point(7, GameEngine.ROWS - 4, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 4, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 5, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(8, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(6, GameEngine.ROWS - 6, 'o',10,0));
        this.pointList.add(new Point(7, GameEngine.ROWS - 7, 'Å',7,0));

        isMoving = false;

    }

    public void playerJump() {
        isMoving = true;
        for (Point point : pointList) {
            point.setY(point.getY() - 2);
        }
    }

    public void playerCrouch() {
        isMoving = true;
        for (Point point : pointList) {
            point.setY(point.getY() + 2);
        }
    }

    public boolean isMoving() {

        return isMoving;

    }

}
