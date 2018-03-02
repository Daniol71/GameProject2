package com.academy;

import java.io.*;

public class HighScore {

    public String highScore;
    public BufferedReader reader;
    {
        try {
            reader = new BufferedReader(new FileReader("HighScore.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readFile () {
        try {
            setHighScore(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }



}
