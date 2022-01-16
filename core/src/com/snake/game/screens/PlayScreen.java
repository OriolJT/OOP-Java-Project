package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.Main;

public class PlayScreen extends Screen_Abstract {

    private Screen_Main s_main;
    private Table table;
    private Label title;

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

        //multiMode button
        final TextButton multiMode_Bt = super.createBt("1 vs 1 Mode", s_main.GAME_S);
        table.add(multiMode_Bt).size(300, 70).fill().spaceBottom(50);
        table.row();

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.MENU_S);
        table.add(back_Bt).size(100, 60).fill().colspan(2);
    }
}
