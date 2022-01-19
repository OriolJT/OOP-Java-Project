package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.ArrayList;

/**@Author Minh Le
 *
 */
public class HighscoreList {
    private final int list_number = 10;
    Preferences prefs = Gdx.app.getPreferences("My Highscores");
    public ArrayList<Highscore> highscoreArrayList = new ArrayList<Highscore>();

    //Standard Constructor for HighscoreList
    //takes Information from my Preferences and creates a ArrayList
    public HighscoreList() {
        ArrayList<Highscore> highscoreArrayList = new ArrayList<>(list_number);
        for(int i = 0; i<highscoreArrayList.size()-1;i++){
            Highscore h = new Highscore();
            h.setName(prefs.getString("Player".concat(Integer.toString(i)),"Default"));
            h.setScore(prefs.getInteger(Integer.toString(i),0));
            h.setDate(prefs.getString("Date".concat(Integer.toString(i))));
            highscoreArrayList.add(h);
        }
    }

    // Sorting Algorithm Bubblesort from
    //https://falconbyte.net/blog-java-bubblesort.php#:~:text=Der%20Bubblesort-Algorithmus%20in%20Java,sukzessive%20in%20die%20richtige%20Reihenfolge.
    public void sortArrayList(){
        Highscore smaller;
        Highscore bigger;
        boolean run = true;
        for(int i = 0 ; i<highscoreArrayList.size()&& run == true;i++){
            run = false;
            for(int j=0 ; j<highscoreArrayList.size()-1;j++){
                if(highscoreArrayList.get(j).getScore()<highscoreArrayList.get(j+1).getScore()){
                    bigger = highscoreArrayList.get(j);
                    smaller = highscoreArrayList.get(j+1);
                    highscoreArrayList.set(j,smaller);
                    highscoreArrayList.set(j+1,bigger);
                    run = true;
                }
            }

        }
        return;
    }

    public ArrayList<Highscore> getHighscoreArrayList() {
        return highscoreArrayList;
    }

    //Adds a Highscore to the Arraylist and simultaneously changes the Preferences Saves
    //Removes access Highscores to reach the number 10;
    public void addHighscore(Highscore highscore){
        highscoreArrayList.add(highscore);
        sortArrayList();
        while(highscoreArrayList.size()>10){
            highscoreArrayList.remove(highscoreArrayList.size()-1);
        }
        saveToPreferences();
    }

    //Saves the current Arraylist to Preferences
    public void saveToPreferences(){
        for (int i = 0; i<highscoreArrayList.size()-1;i++){
            if(highscoreArrayList.get(i)!=null) {
                highscoreArrayList.get(i).saveHighscore(this, i);
            }
        }
    }
}
