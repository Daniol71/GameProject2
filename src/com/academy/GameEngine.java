package com.academy;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.util.ArrayList;

public class GameEngine {

    public static final int COL = 120;
    public static final int ROWS = 35;
    public static ArrayList<GameEntity> characterList = new ArrayList<>();
    public static ArrayList<Point> toRenderList = new ArrayList<>();

    public static void start(){

        characterList.add(new Player());
        characterList.add(new Level());
        GraphicsEngine.init();

        prepareRenderList(); // maybe överflödig


    }

    public static void addObstacle(){
        characterList.add(new ObstacleLow());

        //// very  ugly, plz refactor if possible ///////
        ObstacleLow tmp = (ObstacleLow) characterList.get(characterList.size()-1);

        for(int i = 0; i<tmp.pointList.size();i++){
            toRenderList.add(tmp.pointList.get(i));
        }
        ////////////////////////////////////////////////
    }

    public static void moveObstacles(){
        for(GameEntity obs: characterList){
            if(obs instanceof Obstacles){
                for(Point p: obs.pointList){
                    p.setX(p.getX()-1);
                }
            }
        }
    }

    public static void prepareRenderList(){
        toRenderList.clear();
        for (GameEntity gameEntity : characterList) {
            for (Point p : gameEntity.pointList) {
                toRenderList.add(p);
            }
        }
    }

    public static boolean checkCollision () {
        boolean collision = false;
        for (GameEntity gameEntity : characterList) {
            if (gameEntity instanceof Obstacles) {
                for (Point point : gameEntity.pointList) {
                    for (Point playerPoint : characterList.get(0).pointList) {
                        if (point.getX()==playerPoint.getX() && point.getY() == playerPoint.getY()) {
                            collision = true;
                            return collision;
                        }
                    }
                }
            }
        }
        return collision;
    }
}
