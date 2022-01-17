package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.Highscore;
import com.snake.game.HighscoreList;
import com.snake.game.Main;

import java.sql.Timestamp;
import java.util.Date;


public class HighScoreScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;
    private HighscoreList highscoreList;
    Preferences prefs = Gdx.app.getPreferences("My Highscores");
    public HighScoreScreen(Main main, Screen_Main s_main){
        super(main, s_main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable(); //create a table

        //label
        title = new Label("High Scores", super.getSkin());
        title.setFontScale(2f);
        table.add(title).spaceBottom(20);
        table.row();

        // Column Labels TODO still needs Timestamp as label
        table.add("Scores").left().size(1.5f).pad(0,5,30,0);
        table.add("Names").left().size(1.5f).pad(0,5,30,0);
        table.row();

        prefs.clear();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String date = new Date(ts.getTime()).toString();
        Highscore highscore = new Highscore();
        highscore.setName("Hans");
        highscore.setScore(5);

        highscore.setDate(date);

        Highscore highscore2 = new Highscore();
        highscore2.setName("Peter");
        highscore2.setScore(4);
        highscore2.setDate(date);

        Highscore highscore3 = new Highscore();
        highscore3.setName("Maffay");
        highscore3.setScore(8);
        highscore3.setDate(date);


        Highscore highscore4 = new Highscore();
        highscore4.setName("Tot");
        highscore4.setScore(2);
        highscore4.setDate(date);



        Highscore highscore5 = new Highscore();
        highscore5.setName("Bitte");
        highscore5.setScore(3);
        highscore5.setDate(date);


        HighscoreList highscoreList = new HighscoreList();

        /*
        highscore.saveHighscore(highscoreList);
        highscore2.saveHighscore(highscoreList);
        highscore3.saveHighscore(highscoreList);
        highscore4.saveHighscore(highscoreList);
        highscore5.saveHighscore(highscoreList);
         */




        highscoreList.insertHighscore(highscore);
        highscoreList.insertHighscore(highscore2);
        highscoreList.insertHighscore(highscore3);
        highscoreList.insertHighscore(highscore4);

        /*
        //saves every Highscore of highscoreList into Preferences
        for (Highscore h: highscoreList.list
             ) {
            if(h==null){
                break;
            }
            h.saveHighscore(highscoreList);
        }

     */

        /*
        //Creates the Highscore Table with highscoreList
        for (Highscore h: highscoreList.list
             ) {
            if(h==null) {
                break;
            }
            table.add(prefs.getString(h.getName())).left().size(1.5f).pad(0,5,30,0);
            table.add(prefs.getString(h.getName().concat("str"))).right().size(1.5f).pad(0,5,30,0);
            table.row();
        }
         */
        //speichert alle Highscores von Preferences ein
        for (int i = 0; i<highscoreList.list_number;i++){
            highscoreList.list[i].saveHighscore(highscoreList,i);
        }
        for (int i = 0; i<highscoreList.list_number;i++){
            table.add(prefs.getString(Integer.toString(i))).left().size(1.5f).pad(0,10,30,0);
            table.add(prefs.getString("Player".concat(Integer.toString(i)))).right().size(1.5f).pad(0,5,30,0);
            table.row();


            //adds Timestamp TODO needs to be aligned for the table
            table.add(prefs.getString("Date".concat(Integer.toString(i))));

        }
        /*
        while(highscoreList.list[i]!=null){
            table.add(prefs.getString(highscoreList.list[i].getName())).left();
            table.add(prefs.getString(highscoreList.list[i].getName().concat("str"))).right();
            table.row();
        }


        table.add(prefs.getString("Teststr")).left();
        table.add(prefs.getString("Test")).right();
        table.row();
        table.add(prefs.getString("Test2str")).left();
        table.add(prefs.getString("Test2")).right();
        table.row();



         */
        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.MENU_S);
        table.add(back_Bt).size(100, 60).fill();
    }
}
