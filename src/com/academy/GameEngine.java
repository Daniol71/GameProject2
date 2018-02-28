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

        //Player player = new Player();
        //characterList.add(player);
        Level level = new Level();
        characterList.add(level);
        GraphicsEngine.init();

        for (GameEntity gameEntity : characterList) {
            for (Point p : gameEntity.pointList) {
                toRenderList.add(p);
            }
        }

        GraphicsEngine.render(toRenderList);



    }

}
