package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.snake.game.Main;


public class MenuScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public MenuScreen(Main main, Screen_Main s_main){
        super(main);
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
        title.setFontScale(1.5f);
        table.add(title).spaceBottom(20);
        table.row();

        //buttons
        TextButton play_Bt = new TextButton("Play Game", super.getSkin() );
        table.add(play_Bt).size(250, 60).uniform().fill().spaceBottom(10);
        table.row();

        TextButton rule_Bt = new TextButton("Rules", super.getSkin());
        table.add(rule_Bt).uniform().fill().spaceBottom(10);
        table.row();

        TextButton highScore_Bt = new TextButton("High Scores", super.getSkin() );
        table.add(highScore_Bt).uniform().fill().spaceBottom(10);
        table.row();

        TextButton exit_Bt = new TextButton("Exit", super.getSkin() );
        table.add(exit_Bt).size(100, 60).fill().spaceBottom(10);

        /* Button Listeners */
        //load Play Screen
        play_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                s_main.changeScreen(Screen_Main.PLAY_S);
            }
        });
        //load Rule Screen
        rule_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                s_main.changeScreen(Screen_Main.RULE_S);
            }
        });
        //load Score Screen
        highScore_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                s_main.changeScreen(Screen_Main.SCORE_S);
            }
        });
        //exit program
        exit_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                Gdx.app.exit();
            }
        });
    }
}
