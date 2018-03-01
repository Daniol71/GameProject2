package com.academy;

import java.util.ArrayList;

public class Level extends GameEntity {

    public Level(){
        setAppearance();

    }

    private void setAppearance(){

        for(int i = 0; i < GameEngine.COL; i++){
            for (int j = GameEngine.ROWS-3; j < GameEngine.ROWS; j++) {
                pointList.add(new Point(i,j, '*',5));
            }
        }

    }



}
