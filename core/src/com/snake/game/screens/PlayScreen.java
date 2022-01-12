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

    public PlayScreen(Main main, Screen_Main s_main){
        super(main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("Choose a Game Mode", super.getSkin());
        title.setFontScale(1.5f);
        table.add(title).spaceBottom(30).colspan(2);
        table.row();

        //singleMode button
        TextButton singleMode_Bt = new TextButton("Single Mode", super.getSkin());
        singleMode_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(Screen_Main.GAME_S);
            }
        });
        table.add(singleMode_Bt).size(250, 60).fill().spaceBottom(50);

        //multiMode button
        TextButton multiMode_Bt = new TextButton("1 vs 1 Mode", super.getSkin());
        multiMode_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(Screen_Main.GAME_S);
            }
        });
        table.add(multiMode_Bt).size(250, 60).fill().spaceBottom(50);
        table.row();

        //back button
        final TextButton back_Bt = new TextButton("Back", super.getSkin());
        back_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(Screen_Main.MENU_S);
            }
        });
        table.add(back_Bt).size(100, 60).fill().colspan(2);
    }
}
