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
    public void deleteHighscores(){
        int i=0;
        while(i<list_number){
            list[i]=null;
            i++;
        }
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
    public void insertHighscorePos(int pos){

    }
    public void insertHighscore(Highscore highscore) {
            int i = 0;
            int index=0;
            Highscore p = null;
            if(list[0]==null){
                list[0]=highscore;
                return;
            }
            while(i!=10&&list[i].getScore()>highscore.getScore()) {
                i++;
                index=i;
            }
            System.out.println(Integer.toString(index).concat("Test"));
            Highscore[] highscoreList = new Highscore[11];

            for(int k=0;k<index;k++){
                highscoreList[k]=list[k];
                System.out.println(Integer.toString(index).concat(" Erste For Schleife"));
            }
            highscoreList[index]=highscore;
            for(int j=index;j<list_number;j++){
                highscoreList[j+1]=list[j];
                System.out.println(Integer.toString(index).concat(" Zweite For Schleife"));
            }
            for(int l=0;l<list_number;l++){
                list[l]=highscoreList[l];
            }
    }
}
