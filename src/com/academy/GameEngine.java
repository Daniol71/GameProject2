package com.academy;

import java.util.ArrayList;

public class GameEngine {

    public static final int COL = 120;
    public static final int ROWS = 35;

    public static ArrayList<GameEntity> characterList = new ArrayList<>();
    public static ArrayList<Obstacles> obstacleList = new ArrayList<>();
    public static ArrayList<Point> toRenderList = new ArrayList<>();

    public static void start() {

        characterList.add(new Player());
        characterList.add(new Level());
        GraphicsEngine.init();

    }

    public static void addObstacle() {
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







}
