package com.snake.game;

public class HighscoreList {
    private final int  list_number = 20;
    private Highscore [] list;
    private int i=0;

    public HighscoreList(){
        list = new Highscore[list_number];
    }
    public HighscoreList(Highscore[] hs_l){
        list = new Highscore[list_number];
        while(i!=20){
            list[i]=hs_l[i];
            i++;
        }
        i=0;
    }
    private void deleteHighscore(int rank){
        while(i!=rank){
            i++;
        }
        list[i] = list[i+1];
        while(list[i+1]!=null){
            list[i]=list[i+1];
        }
        i=0;
    }
    private void addHighscore(Highscore h){
        Highscore p;
        while(list[i].getScore()>h.getScore()){
            i++;
        }
        p=list[i+1];
        list[i+1]=list[i];
        list[i]=h;
        while(i!=20){
            list[i]=p;
            p=list[i+1];
        }
    }
}
