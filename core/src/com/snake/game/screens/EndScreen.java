package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.snake.game.Highscore;
import com.snake.game.Main;

import java.sql.Timestamp;
import java.util.Date;

public class EndScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;
    private TextField textField;
    public String name;

    public EndScreen(Main main, Screen_Main s_main){
        super(main, s_main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("Game End", super.getSkin());
        title.setFontScale(2f);
        table.add(title).spaceBottom(40);
        table.row();

        if(s_main.playScreen.getGameMode() == 2){
            title = new Label("Player 1 : " + main.m_board.getBoard_score1(), super.getSkin());
            title.setFontScale(1.2f);
            table.add(title).spaceBottom(20);
            table.row();
            //save score with name input
            Highscore score2 = new Highscore();
            saveScore(score2);

            title = new Label("Player 2 : " + main.m_board.getBoard_score2(), super.getSkin());
            title.setFontScale(1.2f);
            table.add(title).pad(20,0,20,0);
            table.row();
            //save score with name input
            Highscore score3 = new Highscore();
            saveScore(score3);
        }
        else {
            title = new Label("Score : " + main.m_board.getBoard_score1(), super.getSkin());
            title.setFontScale(1.2f);
            table.add(title).spaceBottom(20);
            table.row();
            //save score with name input
            Highscore score1 = new Highscore();
            saveScore(score1);
        }

        //save button
        final TextButton save_Bt = super.createBt("SAVE", s_main.SCORE_S);
        table.add(save_Bt).size(100, 60).fill().colspan(2);
    }

    private void saveScore(final Highscore score){
        final Highscore highscore = score;
        textField = new TextField("Name: ", super.getSkin());
        title.setFontScale(1.2f);

        textField.setOnscreenKeyboard(new TextField.OnscreenKeyboard() {
            @Override
            public void show(boolean visible) {
                Gdx.input.getTextInput(new Input.TextInputListener(){
                    @Override
                    public void input(String text){
                        Timestamp ts = new Timestamp(System.currentTimeMillis());
                        String date = new Date(ts.getTime()).toString();

                        highscore.setName(text);
                        //score.setScore(main.m_board.getBoard_score1());  //TODO : since score 0 is not visible now
                        highscore.setScore(30);
                        highscore.setDate(date);
                        s_main.highscoreList.addHighscore(highscore);
                    }
                    @Override
                    public void canceled(){
                        System.out.println("Cancelled.");
                    }
                }, "Write your Name", "", "to save your score");
            }
        });
        table.add(textField);
        table.row();
    }


}
