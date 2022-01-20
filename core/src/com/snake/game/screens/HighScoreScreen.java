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

/**@Author Minh Le, Jina Kong
 *
 */
public class HighScoreScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;
    //private HighscoreList highscoreList;
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
        table.add(title).spaceBottom(40).colspan(3);
        table.row();

        // Column Labels
        title = new Label("Score", super.getSkin());
        title.setFontScale(1.2f);
        table.add(title).center().pad(0,0,30,80);

        title = new Label("Name", super.getSkin());
        title.setFontScale(1.2f);
        table.add(title).center().spaceBottom(30);

        title = new Label("Date", super.getSkin());
        title.setFontScale(1.2f);
        table.add(title).center().spaceBottom(30).spaceLeft(20);
        table.row();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String date = new Date(ts.getTime()).toString();
        /**
         * because the game does not work, we are adding some Highscores manually to show their functionality in
         * Highscorescreen
         */
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


        s_main.highscoreList.addHighscore(highscore2);
        s_main.highscoreList.addHighscore(highscore);
        s_main.highscoreList.addHighscore(highscore3);
        s_main.highscoreList.addHighscore(highscore4);
        s_main.highscoreList.addHighscore(highscore5);
        //Draws the Highscores on the Screen
        for (int i = 0; i<s_main.highscoreList.highscoreArrayList.size();i++){
            //adds one Score Row
            table.add(prefs.getString(Integer.toString(i))).fillX().pad(0,15,25,60);
            //adds one Name Row
            table.add(prefs.getString("Player".concat(Integer.toString(i)))).fillX().spaceBottom(25);
            //adds Timestamp
            table.add(prefs.getString("Date".concat(Integer.toString(i)))).fillX().spaceBottom(25).spaceLeft(70);
            table.row();



        }

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.MENU_S);
        table.add(back_Bt).size(100, 60).fill().colspan(3);
    }
}
