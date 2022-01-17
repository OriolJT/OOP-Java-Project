package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.snake.game.Main;

public class PlayScreen extends Screen_Abstract {

    private Screen_Main s_main;
    private Table table;
    private Label title;

    protected int modeFlag = 1;

    public PlayScreen(Main main, Screen_Main s_main){
        super(main, s_main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();

        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("Choose a Game Mode", super.getSkin());
        title.setFontScale(2f);
        table.add(title).spaceBottom(30).colspan(2);
        table.row();

        //singleMode button
        final TextButton singleMode_Bt = super.createBt("Single Mode", s_main.GAME_S);
        table.add(singleMode_Bt).size(300, 70).fill().spaceBottom(50).spaceRight(10);

        singleMode_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                modeFlag = 1;
                s_main.changeScreen(Screen_Main.GAME_S);
            }
        });

        /*
        final TextButton singleMode_Bt = new TextButton("Single Mode", getSkin());
        table.add(singleMode_Bt).size(300, 70).fill().spaceBottom(50).spaceRight(10);
        singleMode_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                modeFlag = 1;
                s_main.changeScreen(Screen_Main.GAME_S);
                System.out.println(modeFlag);
            }
        });
         */

        //multiMode button
        /*
        final TextButton multiMode_Bt = super.createBt("1 vs 1 Mode", s_main.GAME_S);
        table.add(multiMode_Bt).size(300, 70).fill().spaceBottom(50);
        table.row();

         */

        final TextButton multiMode_Bt = new TextButton("1 vs 1 Mode", getSkin());
        table.add(multiMode_Bt).size(300, 70).fill().spaceBottom(50);
        table.row();

        multiMode_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                modeFlag = 2;
                s_main.changeScreen(Screen_Main.GAME_S);
                System.out.println(modeFlag);
            }
        });

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.MENU_S);
        table.add(back_Bt).size(100, 60).fill().colspan(2);
    }

    public int getGameMode(){ return modeFlag; }
}
