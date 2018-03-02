package com.academy;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;

public class GraphicsEngine {

    public static Terminal terminal = TerminalFacade.createSwingTerminal(GameEngine.COL, GameEngine.ROWS);

    public static void init(){

        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
    }

    public static void render(ArrayList<Point> toRenderList) {

        terminal.clearScreen();
        for (Point point : toRenderList) {
            terminal.moveCursor(point.getX(), point.getY());
            terminal.applyForegroundColor(point.getColor());
            terminal.applyBackgroundColor(point.getBackGroundColor());
            terminal.putCharacter(point.getPixel());
        }
        GameEngine.addScoreToRenderList();
    }

    public static void showEndScreen() {
        terminal.clearScreen();
        for(int y = 0; y < GameEngine.ROWS; y++){
            for(int x = 0; x < GameEngine.COL;x++){
                terminal.moveCursor(x,y);
                terminal.applyBackgroundColor(0);
                terminal.applyForegroundColor(0);
                terminal.putCharacter('\u2588');
            }
        }
        putString("G A M E  O V E R !", GameEngine.COL/2-10, GameEngine.ROWS/2, 7, 1);
        putString("Press F7 to play again", (GameEngine.COL/2) -12, (GameEngine.ROWS/2) + 7, 1, 3);
        putString("YOUR SCORE: "+GameEngine.score, GameEngine.COL/2-10, GameEngine.ROWS/2+10, 7, 1);
        putString("HIGHSCORE: "+GameEngine.highScore.getHighScore(), GameEngine.COL/2-10, GameEngine.ROWS/2+12, 7, 1);


        Key key;
        while( true){
            key = terminal.readInput();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(key!= null && key.getKind() == Key.Kind.F7) {
                GameEngine.start();
                try {
                    Main.gameLoop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void putString(String s, int x, int y, int foregroundcolor, int backgroundcolor) {
        for (int i = 0; i < s.length(); i++) {
            terminal.applyForegroundColor(foregroundcolor);
            terminal.applyBackgroundColor(backgroundcolor);
            terminal.moveCursor(x + i, y);
            terminal.putCharacter(s.charAt(i));

        }


    }
}
