package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.Highscore;
import com.snake.game.HighscoreList;
import com.snake.game.Main;

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
        table.add(title).spaceBottom(20);
        table.row();
        
        Highscore highscore = new Highscore();
        highscore.setName("Test");
        highscore.setScore(5);
        Highscore highscore2 = new Highscore();
        highscore2.setName("Test2");
        highscore2.setScore(4);
        HighscoreList highscoreList = new HighscoreList();
        highscoreList.addHighscore(highscore);
        highscoreList.addHighscore(highscore2);

        for (Highscore h: highscoreList.list
             ) {
            if(h==null){
                break;
            }
            h.saveHighscore();
        }

        for (Highscore h: highscoreList.list
             ) {
            if(h==null){
                break;
            }
            table.add(prefs.getString(h.getName())).left();
            table.add(prefs.getString(h.getName().concat("str"))).right();
            table.row();
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
