package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.*;

import java.util.Random;

public class GameScreen extends Screen_Abstract {
    private Screen_Main s_main;
    private Table table;
    private Label title;

    public Cell[][] cells;
    //private Item item;
    public int rows = 20;
    public int cols = 20;
    public int scl = Gdx.graphics.getWidth()/cols;
    public Game game;
    Texture texture = new Texture(Gdx.files.internal("apple.png"));
    public int score = 999; //temporal score


    private Renderer renderer;

    //random for test
    Random rand = new Random();
    int randX, randY;
    int randX2, randY2;


    public GameScreen(Main main, Screen_Main s_main) {
        super(main, s_main);
        this.s_main = s_main;

        //cell
        this.cells = new Cell[rows][cols];
        //snake =
        renderer = new Renderer(this);

        //initialize
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }

        //snake drawing test
        randX = rand.nextInt(cols-2);
        randY = rand.nextInt(rows-2);
        cells[randX][randY].setState(State.SNAKE);
        cells[randX+1][randY].setState(State.SNAKE);
        cells[randX+2][randY].setState(State.SNAKE);

        //item drawing test
        Image apple = new Image(texture);
        randX2 = rand.nextInt(cols-1);
        randY2 = rand.nextInt(rows-1);
        cells[randX2][randY2].setState(State.ITEM);
        for (int x = 1; x < rows - 1; x++) {
            for (int y = 1; y < cols - 1; y++) {
                if (cells[x][y].getState() == State.ITEM)
                    apple.setPosition(x*32, y*32);
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

