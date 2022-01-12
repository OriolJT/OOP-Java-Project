package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.snake.game.Main;

public class GameScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public GameScreen(Main main, Screen_Main s_main) {
        super(main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //label
        title = new Label("Score", super.getSkin());
        title.setFontScale(1.5f);
        table.add(title).spaceBottom(30).colspan(2);
        table.row();

        //exit button
        final TextButton back_Bt = new TextButton("Exit", super.getSkin());
        back_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(Screen_Main.END_S);
            }
        });
        table.add(back_Bt).size(100, 60).fill().colspan(2);
    }
}

