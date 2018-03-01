package com.academy;

public class Bullet extends GameEntity {

    public Bullet() {

        this.pointList.add(new Point(9,GameEngine.ROWS-6,'*',120));

    }
}
