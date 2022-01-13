package com.snake.game.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.snake.game.Main;

public class EndScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;
    private TextField textField;

    public int score=999; //temporal score
    public String name = "AAA"; //temporal name

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
        title.setFontScale(1.5f);
        table.add(title).spaceBottom(20);
        table.row();


        title = new Label("Score : "+score, super.getSkin());
        table.add(title).spaceBottom(20);
        table.row();

        title = new Label("Name : ", super.getSkin());
        table.add(title).spaceBottom(20);

        //incomplete ,,,
        textField = new TextField("Name: ", super.getSkin());
        table.row();

        //save button
        final TextButton save_Bt = super.createBt("SAVE", s_main.SCORE_S);
        table.add(save_Bt).size(100, 60).fill().colspan(2);
    }
}
