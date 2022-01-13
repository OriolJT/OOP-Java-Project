package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.Main;

public class RuleScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title, rule;

    public RuleScreen(Main main, Screen_Main s_main){
        super(main, s_main);
        this.s_main = s_main;
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table

        //title label
        title = new Label("Game Rules", super.getSkin());
        title.setFontScale(1.5f);
        table.add(title).center().spaceBottom(30);
        table.row();

        //rules
        rule = new Label("- How to Control a Snake :: by keyboard arrow keys (in 1vs1 mode, W, S, A, D keys also)", super.getSkin());
        table.add(rule).pad(0,5,20,0).left();
        table.row();

        rule = new Label("- When Eating an Item :: the score increases, but the snake’s length will also increase.", super.getSkin());
        table.add(rule).pad(0,5,20,0).left();
        table.row();

        rule = new Label("- Game End :: When the snake collides with the border", super.getSkin());
        table.add(rule).pad(0,5,7,0).left();
        table.row();

        rule = new Label("                    (in 1vs1 mode, when colliding with another snake also)", super.getSkin());
        table.add(rule).pad(0,5,30,0).left();
        table.row();

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.MENU_S);
        table.add(back_Bt).size(100, 60).spaceBottom(10);
    }
}
