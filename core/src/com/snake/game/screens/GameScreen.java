package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snake.game.*;

public class GameScreen extends Screen_Abstract {
    private Renderer renderer;
    public Main game;
    protected Screen_Main s_main;
    private Table table;
    private Label title;

    public Cell[][] cells;
    protected int RowNCol = 30;
    private int itemNum;
    public int score = 999; //temporal score

    Texture texture_a = new Texture(Gdx.files.internal("apple.png"));
    Image apple = new Image(texture_a);
    Texture texture_k = new Texture(Gdx.files.internal("kiwi.png"));
    Image kiwi = new Image(texture_k);
    Texture texture_b = new Texture(Gdx.files.internal("banana.png"));
    Image banana = new Image(texture_b);


    public GameScreen(Main main, Screen_Main s_main) {
        super(main, s_main);
        this.s_main = s_main;
        this.cells = s_main.main.getCells();
        renderer = new Renderer(this);

        // Draw items as an image
        for (int x = 1; x < RowNCol - 1; x++) {
            for (int y = 1; y < RowNCol - 1; y++) {
                if (cells[x][y].getState() == State.ITEM) {
                    itemNum = main.m_board.tempItemNum;
                    drawItem(x, y, itemNum);
                }
            }
        }
    }

    public void drawItem(int x, int y, int itemNum) {
        switch (itemNum) {
            case 0: //apple
                apple.setPosition(x * RowNCol, y * RowNCol);
                stage.addActor(apple);
                break;
            case 1: //banana
                banana.setPosition(x * RowNCol, y * RowNCol);
                stage.addActor(banana);
                break;
            case 2: //kiwi
                kiwi.setPosition(x * RowNCol, y * RowNCol);
                stage.addActor(kiwi);
                break;
        }
    }

    @Override
    public void show() {
        if(table != null) table.clear();
        super.show();
        table = super.createTable();    //create a table
        table.setBounds(0,0,800,500);

        //back button
        final TextButton back_Bt = super.createBt("BACK", s_main.PLAY_S);
        table.add(back_Bt).size(80, 60).pad(10,40,0,0).top().fill();

        //label
        score = main.m_board.getBoard_score1();
        title = new Label("Score: "+score, super.getSkin());
        title.setFontScale(1.5f);
        table.add(title).pad(30,280,0,0).top().expand().fillX();

        //exit button
        final TextButton exit_Bt = super.createBt("EXIT", s_main.END_S);
        table.add(exit_Bt).size(80, 60).pad(10,0,0,40).top().fill();
    }

    @Override
    public void render(float delta){
        renderer.render();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
}

