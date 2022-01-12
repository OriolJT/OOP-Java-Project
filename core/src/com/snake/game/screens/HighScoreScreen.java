package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.snake.game.Main;

public class HighScoreScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public HighScoreScreen(Main main, Screen_Main s_main){
        super(main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("High Scores", super.getSkin());
        table.add(title).spaceBottom(20);
        table.row();

        //back button
        final TextButton back_Bt = new TextButton("Back", super.getSkin());
        back_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(Screen_Main.MENU_S);
            }
        });
        table.add(back_Bt).size(100, 60).fill();
    }
}
