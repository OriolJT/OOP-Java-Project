package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.Date;
import java.sql.Time;

public class Highscore {
    private String name;
    private String date;
    private int score;
    Preferences prefs = Gdx.app.getPreferences("My Highscores");

    public Highscore(){
        this.name = "";
        this.date = null;
        this.score = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String s){
        this.name = s;
    }
    public String getDate(){
        return this.date;
    }
    public void setDate(String d){
        this.date = d;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void saveHighscore(HighscoreList highscoreList,int i){
        highscoreList.insertHighscore(this);
        prefs.putInteger(Integer.toString(i), this.getScore());
        prefs.putString("Player".concat(Integer.toString(i)), this.getName());
        prefs.putString("Date".concat(Integer.toString(i)), this.getDate());
        System.out.println(i);
        /*
        prefs.putInteger(this.getName(), this.getScore());
        prefs.putString(this.getName().concat("str"), this.getName());
         */
        prefs.flush();
        System.out.println(prefs.get().values());
    }
}
