package com.snake.game;

import java.sql.Date;
import java.sql.Time;

public class Highscore {
    private String name;
    private Date date;
    private Time time;
    private int score;

    public Highscore(){
        this.name = "";
        this.date = null;
        this.time = null;
        this.score = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String s){
        this.name = s;
    }
    public Time getTime(){
        return time;
    }
    public void setTime(Time t){
        this.time = t;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date d){
        this.date = d;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
