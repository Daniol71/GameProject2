package com.academy;

public class Bullet extends GameEntity {

    private boolean descending;

    public Bullet() {


        this.pointList.add(new Point(9,GameEngine.ROWS-6,'*',3,0));
        this.descending = false;
    }

    public boolean isDescending() {

        return descending;
    }


    public void setDescending(boolean descending) {
        this.descending = descending;
    }
}
