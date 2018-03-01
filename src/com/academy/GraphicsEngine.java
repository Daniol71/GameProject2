package com.academy;

import com.googlecode.lanterna.TerminalFacade;
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
            terminal.putCharacter(point.getPixel());
        }


    }



}
