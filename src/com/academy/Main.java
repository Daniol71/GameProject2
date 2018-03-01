package com.academy;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        // break out the below calls to separate method startGame?

        GameEngine.start();
        gameLoop();

    }

    public static void gameLoop() throws InterruptedException {

        int counter = 20;

        while (true) {
            if (counter % 20 == 0) {
                GameEngine.addObstacle();
            }
            counter++;

            //Implement GameEngine.playerAction() ?
            GameEngine.moveObstacles();

            if (GameEngine.checkCollision()) {
                System.out.println("Game Over");
                break;
            }
            Thread.sleep(50);

            GameEngine.prepareRenderList();
            GraphicsEngine.render(GameEngine.toRenderList);


        }

        // if collision, we end up here, so call some game-over screen where you can initialize new game by calling startGame() ?

    }



}
