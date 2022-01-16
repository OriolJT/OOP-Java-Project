package com.snake.game;

public class HighscoreList {
    public final int  list_number = 10;
    public Highscore [] list;

    public Highscore[] getList(){
        return this.list;
    }
    public HighscoreList(){
        list = new Highscore[list_number];
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
    public void addHighscore(Highscore h) {
        int i = 0;
        Highscore p=list[i];
        Highscore p2=null;
        while(list[i]!=null) {
            if (list[i].getScore()< h.getScore()) {
                p = list[i];
                p2 = list[i + 1];
                break;
            }i++;
        }
        list[i]=h;
        list[i+1]=p;
        list[i+2]=p2;
    }
}
