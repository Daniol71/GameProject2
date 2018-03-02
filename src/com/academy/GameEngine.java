package com.academy;

import com.googlecode.lanterna.input.Key;

import java.awt.*;
import java.util.ArrayList;

public class GameEngine {

    private static int counter = 0;
    public static int score = 0;
    private static int deltaCounter;
    public static final int COL = 120;
    public static final int ROWS = 35;


    public static ArrayList<GameEntity> characterList = new ArrayList<>();
    public static ArrayList<Obstacles> obstacleList = new ArrayList<>();
    public static ArrayList<Bullet> bulletList = new ArrayList<>();
    public static ArrayList<Point> toRenderList = new ArrayList<>();

    public static Player player = new Player();


    public static void start() {

        score = 0;


        characterList.clear();
        obstacleList.clear();
        bulletList.clear();
        characterList.add(player);
        characterList.add(new Level());



    }

    public static void addObstacle() {


        int rnd = (int) (Math.random()*7);

        if (counter % 20 == 0) {
            switch (rnd) {

                case 0:
                    break;
                case 1:
                    obstacleList.add(new ObstacleLow());
                    break;
                case 2:
                    obstacleList.add(new ObstacleHigh());
                    break;
                case 3:
                    obstacleList.add(new ObstacleLow());
                    obstacleList.add(new ObstacleHigh());
                    break;
                case 4:
                    obstacleList.add(new ObstacleLow());
                    obstacleList.add(new ObstacleLow(true));
                    break;

                case 5:
                    obstacleList.add(new ObstacleHigh());
                    obstacleList.add(new ObstacleHigh(true));
                    break;

                case 6:
                    obstacleList.add(new ObstacleLow());
                    obstacleList.add(new ObstacleLow(true));
                    obstacleList.add(new ObstacleHigh());
                    obstacleList.add(new ObstacleHigh(true));
                    break;

            }
        }
    }


    public static void removeObstacles() { // removes obstacle when it has passed the behind the player
        //REFACTOR to copy tmpList (maybe?)
        for (int i = 0; i < obstacleList.size(); i++)
            for (int j = 0; j < obstacleList.get(i).pointList.size(); j++) {
                if (obstacleList.get(i).pointList.get(j).getX() == 0) {
                    obstacleList.remove(obstacleList.get(i));
                    break;
                }
            }
    }////////////////////////////////////////

    public static void moveObstacles() {
        for (Obstacles obstacle : obstacleList)
            for (Point p : obstacle.pointList)
                p.setX(p.getX() - 1);
    }

    public static void moveBullets() {

        for (Bullet bullet : bulletList) {
            for (Point p : bullet.pointList) {
                if (p.getY() <= ROWS - 10) {
                    bullet.setDescending(true);
                }
                if (!bullet.isDescending()) {
                    p.setX(p.getX() + 3);
                    p.setY(p.getY() - 1);

                } else if (bullet.isDescending()) {
                    p.setX(p.getX() + 3);
                    p.setY(p.getY() + 1);
                }
            }

        }
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
        for (Bullet bullet : bulletList) {
            for (Point p : bullet.pointList) {
                toRenderList.add(p);
            }
        }
    }

    public static boolean checkPlayerCollision() {

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

    public static void checkAndRemoveBulletCollision() {
        ArrayList<Obstacles> tempObstaclesList = new ArrayList<>();
        ArrayList<Bullet> tempBulletList = new ArrayList<>();

        tempObstaclesList.addAll(obstacleList);
        tempBulletList.addAll(bulletList);


            for (Obstacles obstacle : obstacleList) {
                for (Point obstaclePoint : obstacle.pointList) {
                    for (Bullet bullet : bulletList) {
                        for (Point bulletPoint : bullet.pointList) {

                            if (obstaclePoint.getX() == bulletPoint.getX() && obstaclePoint.getY() == bulletPoint.getY()) {
                                tempObstaclesList.remove(obstacle);
                                addScore(100);
                                obstacleList = tempObstaclesList;
                                break; // If bullet hits ground and obstacle simultaneously, treat it as a obstacle-bullet collision

                            }
                            else if(bulletPoint.getY() >= ROWS-3 ) {
                                tempBulletList.remove(bullet);
                                bulletList = tempBulletList;
                                break;

                            }
                        }
                    }
                }
            }
        }


    public static void playerAction(Key key) {
        if (!player.isMoving()) {
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
                    if(bulletList.size() < 2) {
                        bulletList.add(new Bullet());
                        SoundEngine.soundEffects(4);
                    }
                    break;
                default:

                    break;

            }
        }

    }

    public static void updateCounter() {
        counter++;
        addScore(1);
        checkPlayerPosition();
    }

    public static void addScore(int addScore) {
        score += addScore;
    }

    private static void checkPlayerPosition() {

        if(!player.isMoving()){
            if(counter % 4 == 0){
                player.setPlayerNeutral();
            }
            else{
                player.setPlayerLegsTogether();
            }
        }

        if (counter - deltaCounter > 10 && player.isMoving()) {
            player.setPlayerNeutral();
        }
    }

    public static void addScoreToRenderList() {
        String scoreString = "SCORE: " + score;

        /*toRenderList.add(new Point(5, 2, 'S', 7,1));
        toRenderList.add(new Point(6, 2, 'C', 7,1));
        toRenderList.add(new Point(7, 2, 'O', 7,1));
        toRenderList.add(new Point(8, 2, 'R', 7,1));
        toRenderList.add(new Point(9, 2, 'E', 7,1));
        toRenderList.add(new Point(10, 2, ':', 7,1));
        for (int i = 0; i<scoreString.length(); i++) {
            toRenderList.add(new Point(11+i,2,scoreString.charAt(i),7,1));
        }*/
        GraphicsEngine.putString(scoreString, 5, 2, 7, 0);

    }


}
