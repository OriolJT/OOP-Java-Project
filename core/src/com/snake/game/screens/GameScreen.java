package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.*;

public class GameScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public Cell[][] cells;
    public int rows = 20;
    public int cols = 20;
    public int scl = Gdx.graphics.getWidth()/cols;
    public Main game;
    Texture texture = new Texture(Gdx.files.internal("apple.png"));
    Image apple = new Image(texture);
    public int score = 999; //temporal score


    private Renderer renderer;

    public GameScreen(Main main, Screen_Main s_main) {
        super(main, s_main);
        this.s_main = s_main;
        this.cells = s_main.main.getCells();
        renderer = new Renderer(this);

        // Draw items as an image (problem: not exactly fit for Cells)
        for (int x = 1; x < rows - 1; x++) {
            for (int y = 1; y < cols - 1; y++) {
                if (cells[x][y].getState() == State.ITEM)
                    apple.setPosition(x*scl, y*scl);
            }
        }
        stage.addActor(apple);
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table
        table.setBounds(0,0,800,500);

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.PLAY_S);
        table.add(back_Bt).size(60, 40).pad(1,30,0,0).top().fill();

        //label
        title = new Label("Score: "+score, super.getSkin());
        table.add(title).pad(10,220,0,0).top().expand().fillX();

        //exit button
        final TextButton exit_Bt = super.createBt("EXIT", s_main.END_S);
        table.add(exit_Bt).size(60, 40).pad(1,0,0,30).top().fill();
    }

    @Override
    public void render(float delta){
        renderer.render();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
}

