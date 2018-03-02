package com.academy;


import com.googlecode.lanterna.input.Key;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        GraphicsEngine.init();
        GameEngine.start();
        gameLoop();

    }

    public static void gameLoop() throws InterruptedException {

        Key key;
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.play("BackgroundMusic.mp3", true);

        while (true) {

            GameEngine.updateCounter();
            GameEngine.addObstacle();

            key = GraphicsEngine.terminal.readInput();

            if(key != null)
                GameEngine.playerAction(key);


            GameEngine.checkAndRemoveBulletCollision();
            GameEngine.moveObstacles();
            GameEngine.checkAndRemoveBulletCollision();
            GameEngine.removeObstacles();

            GameEngine.moveBullets();
            GameEngine.checkAndRemoveBulletCollision();


            if (GameEngine.checkPlayerCollision()) {
                SoundEngine.soundEffects(5);
                System.out.println("Game Over");
                soundEngine.stopAll();
                GraphicsEngine.showEndScreen();



            }
            Thread.sleep(50);

            GameEngine.prepareRenderList();
            GraphicsEngine.render(GameEngine.toRenderList);

        }


    }



}
