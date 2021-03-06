package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.snake.game.Main;


public class MenuScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public MenuScreen(Main main, Screen_Main s_main){
        super(main, s_main);
        this.s_main = s_main;
    }

    public void startGame(){

    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("Snake Game", super.getSkin());
        title.setFontScale(2f);
        table.add(title).spaceBottom(25);
        table.row();

        //play button
        final TextButton play_Bt = super.createBt("PLAY", s_main.PLAY_S);
        table.add(play_Bt).size(400, 70).fillX().uniform().spaceBottom(15);
        table.row();

        //rule button
        final TextButton rule_Bt = super.createBt("RULE", s_main.RULE_S);
        table.add(rule_Bt).uniform().fill().spaceBottom(15);
        table.row();

        //high score button
        final TextButton highScore_Bt = super.createBt("HIGH SCORES", s_main.SCORE_S);
        table.add(highScore_Bt).uniform().fill().spaceBottom(10);
        table.row();

        //exit button
        TextButton exit_Bt = new TextButton("EXIT", super.getSkin() );
        exit_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                Gdx.app.exit();
            }
        });
        table.add(exit_Bt).size(100, 60).fill().spaceBottom(10);
    }
}
