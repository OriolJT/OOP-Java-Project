package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Null;

import java.text.DateFormat;
import java.util.Date;


public class HighscoreList {
    public final int  list_number = 10;
    public Highscore [] list;
    Preferences prefs = Gdx.app.getPreferences("My Highscores");
    public Highscore[] getList(){
        return this.list;
    }
    public HighscoreList(){
        list = new Highscore[list_number];
        for(int i =0; i<list_number;i++){
            Highscore h = new Highscore();
            h.setName(prefs.getString("Player".concat(Integer.toString(i))));
            h.setScore(prefs.getInteger(Integer.toString(i)));
            h.setDate(prefs.getString("Date".concat(Integer.toString(i))));
            list[i] = h;
        }
    }
    public HighscoreList(Highscore[] hs_l){
        list = new Highscore[list_number];
        int i =0;
        while(i!=10){
            list[i]=hs_l[i];
            i++;
        }
        i=0;
    }
    public void deleteHighscore(String name){
        int i=0;
        while(!list[i].getName().equals(name)){
            i++;
        }
        list[i] = list[i+1];
        while(list[i+1]!=null){
            list[i]=list[i+1];
        }
        i=0;
    }
    public int getIndex(Highscore highscore){
        int i = 0;
        while (i<list_number) {
            if(list[i].getScore()==highscore.getScore()&&list[i].getName()==highscore.getName()){
                return i;
            }
            i++;
        }
        return 0;
    }
    public void printHighscoreList(){
        int i = 0;
        while(i<list_number){
            System.out.print(list[i].getName());
        }
    }
    public void insertHighscore(Highscore highscore) {
            int i = 0;
            Highscore p = null;
            if(list[0]==null){
                list[0]=highscore;
                return;
            }
            while(i<list_number) {
                if (list[i].getScore()< highscore.getScore()) {
                    p = list[i];
                    list[i]=highscore;
                    return;
                }i++;
            }
            if(i+1<list_number){
                return;
            }
            while(i+1<list_number){
                list[i+1]=list[i];
                i++;
            }
    }
}
