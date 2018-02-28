package com.academy;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        GameEngine.start();
        gameLoop();

    }

    public static void gameLoop() throws InterruptedException {
int counter = 10;
        while(true){
            if(counter%10 == 0) {
                GameEngine.addObstacle();
            }
            counter++;

            GameEngine.moveObstacles();
            Thread.sleep(100);
            //maybe player moves
            GameEngine.prepareRenderList();
            //check collisions
            GraphicsEngine.render(GameEngine.toRenderList);


        }

    }

}
