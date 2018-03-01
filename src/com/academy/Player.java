package com.academy;

import java.util.ArrayList;

public class Player extends GameEntity {

    private boolean isMoving = false;

    public Player() {

        setAppearance();

    }

    private void setAppearance() {

        this.pointList.add(new Point(8, GameEngine.ROWS - 4, 'o'));
        this.pointList.add(new Point(6, GameEngine.ROWS - 4, 'o'));
        this.pointList.add(new Point(7, GameEngine.ROWS - 5, 'o'));
        this.pointList.add(new Point(7, GameEngine.ROWS - 6, 'o'));
        this.pointList.add(new Point(8, GameEngine.ROWS - 6, 'o'));
        this.pointList.add(new Point(6, GameEngine.ROWS - 6, 'o'));
        this.pointList.add(new Point(7, GameEngine.ROWS - 7, 'o'));

    }

    public void playerJump() {
        isMoving = true;
        for (Point point : pointList) {
            point.setY(point.getY() - 2);
        }
    }
    public boolean isMoving() {
        return isMoving;
    }

}
