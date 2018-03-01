package com.academy;


import com.googlecode.lanterna.input.Key;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // break out the below calls to separate method startGame?

        GameEngine.start();
        gameLoop();

    }

    public static void gameLoop() throws InterruptedException {

        int counter = 20;
        Key key;

        while (true) {
            if (counter % 20 == 0) {
                GameEngine.addObstacle();
            }
            counter++;

            key = GraphicsEngine.terminal.readInput();

            if(key != null)
                GameEngine.playerAction(key);

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
