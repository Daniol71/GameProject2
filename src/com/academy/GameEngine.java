package com.academy;

import com.googlecode.lanterna.input.Key;

import java.util.ArrayList;

public class GameEngine {

    private static int counter = 0;
    private static int deltaCounter;
    public static final int COL = 120;
    public static final int ROWS = 35;


    public static ArrayList<GameEntity> characterList = new ArrayList<>();
    public static ArrayList<Obstacles> obstacleList = new ArrayList<>();
    public static ArrayList<Point> toRenderList = new ArrayList<>();

    public static Player player = new Player();


    public static void start() {

        characterList.add(player);
        characterList.add(new Level());
        GraphicsEngine.init();

    }

    public static void addObstacle() {
        if(counter % 20 == 0)
            obstacleList.add(new ObstacleLow());
    }

    public static void moveObstacles() {
        for (Obstacles obstacle : obstacleList)
                for (Point p : obstacle.pointList)
                    p.setX(p.getX() - 1);
    }

    public static void prepareRenderList() {

        toRenderList.clear();

        for (GameEntity gameEntity : characterList) {
            for (Point p : gameEntity.pointList) {
                toRenderList.add(p);
            }
        }
        for (Obstacles obstacle : obstacleList) {
            for (Point p : obstacle.pointList) {
                toRenderList.add(p);
            }
        }
    }

    public static boolean checkCollision() {

        boolean collision = false;

        for (Obstacles obstacle : obstacleList) {  // Iterate through each obstacle
            for (Point obstaclePoint : obstacle.pointList) { // For each obstacle, iterate through it's points
                for (Point playerPoint : characterList.get(0).pointList) {   //  For each of current obstacle's points, compare to each point the Player occupies
                    if (obstaclePoint.getX() == playerPoint.getX() && obstaclePoint.getY() == playerPoint.getY()) {
                        collision = true;
                        return collision;
                    }
                }
            }
        }
        return collision;
    }

    public static void playerAction(Key key) {
        if(!player.isMoving()) {
            deltaCounter = counter;
            switch (key.getKind()) {

                case ArrowUp:

                    System.out.println("Player jumped");
                    player.playerJump();
                    break;

                case ArrowDown:
                    System.out.println("Player crouched");
                    player.playerCrouch();
                    break;
                case Tab:
                    System.out.println("Player fired");
                    break;
                default:

                    break;

            }
        }

    }

    public static void updateCounter() {
        counter++;
        checkPlayerPosition();
    }

    private static void checkPlayerPosition() {
        if(counter - deltaCounter > 10){
            player.setPlayerNeutral();
        }
    }



}
