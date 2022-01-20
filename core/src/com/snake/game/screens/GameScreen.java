package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.snake.game.*;
import com.snake.game.Cell;

import java.util.LinkedList;
import java.util.Random;

public class GameScreen extends Screen_Abstract implements Runnable {
    private Renderer renderer;
    public Main game;
    protected Screen_Main s_main;
    private Table table;
    private Label title;
    private Board board;
    protected int RowNCol = 30;
    private int itemNum;
    public int score1, score2;
    public Cell[][] cells;
    Texture texture_a = new Texture(Gdx.files.internal("apple.png"));
    Image apple = new Image(texture_a);
    Texture texture_k = new Texture(Gdx.files.internal("kiwi.png"));
    Image kiwi = new Image(texture_k);
    Texture texture_b = new Texture(Gdx.files.internal("banana.png"));
    Image banana = new Image(texture_b);


    public GameScreen(Main main, Screen_Main s_main) {
        super(main, s_main);
        this.s_main = s_main;
        this.cells = s_main.main.m_board.getCells();
        this.board = s_main.main.m_board;
        renderer = new Renderer(this);

        //initializes Player 1 with modeFlag==1 (Single Player)
        if(main.m_screen.playScreen.modeFlag==1){
            board.setM_player1(new Player());
            board.getM_player1().setName("Player 1");
            board.getM_player1().setSnake(new Snake());
            board.getM_player1().getSnake().setHead(randomize());
            board.setm_mode(1);
        }
        //initializes Player 2 with modeFlag==2 (1 versus 1)
        if(main.m_screen.playScreen.modeFlag==2){
            board.setM_player1(new Player());
            board.getM_player1().setName("Player 1");
            board.getM_player1().setSnake(new Snake());
            board.getM_player1().getSnake().setHead(randomize());
            board.setM_player2(new Player());
            board.getM_player2().setName("Player 2");
            board.getM_player2().setSnake(new Snake());
            board.getM_player2().getSnake().setHead(randomize());
            board.setm_mode(2);
        }
    }

    public void drawSnake(){
        if(main.m_screen.playScreen.modeFlag==1){
           LinkedList<Cell> snakeCells = board.getM_player1().getSnake().getSnakeCells();
            for (Cell c: snakeCells
                 ) {
                //TODO Draw SnakeCells and IMG;
                int x = c.getX();
                int y = c.getY();
                renderer.render(1, x, y);
            }
        }
        if(main.m_screen.playScreen.modeFlag==2) {
            LinkedList<Cell> snakeCells = board.getM_player1().getSnake().getSnakeCells();
            LinkedList<Cell> snakeCells2 = board.getM_player2().getSnake().getSnakeCells();
            for(Cell c : snakeCells){
                //TODO Draw SnakeCells Player 1
                int x = c.getX();
                int y = c.getY();
                 renderer.render(1, x, y);
            }
            for (Cell c: snakeCells2
                 ) {
                //TODO Draw SnakeCells Player 2
                int x = c.getX();
                int y = c.getY();
                renderer.render(2, x, y);
            }
            }
        }


    public Cell randomize(){
        Random rand = new Random();
        int x = rand.nextInt(RowNCol);
        int y = rand.nextInt(RowNCol);
        Cell cell = new Cell(x,y);
        if(cells[x][y].getState()!=State.FREE){
            randomize();
        }
        return cell;
    }

    public void drawItem(){
        for (int x = 1; x < RowNCol - 1; x++) {
            for (int y = 1; y < RowNCol - 1; y++) {
                if (cells[x][y].getState() == State.ITEM) {
                    itemNum = main.m_board.tempItemNum;
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
            }
        }
    }

    private void update(){

    }

    @Override
    public void run(){
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
        if(s_main.playScreen.modeFlag == 2){
            score1 = main.m_board.getBoard_score1();
            title = new Label("Player 1 : "+score1, super.getSkin());
            title.setFontScale(1.5f);
            table.add(title).pad(30,100,0,0).top().expand().fillX();

            score2 = main.m_board.getBoard_score2();
            title = new Label("Player 2 : "+score2, super.getSkin());
            title.setFontScale(1.5f);
            table.add(title).pad(30,40,0,0).top().expand().fillX();
        }
        else {
            score1 = main.m_board.getBoard_score1();
            title = new Label("Score: " + score1, super.getSkin());
            title.setFontScale(1.5f);
            table.add(title).pad(30, 280, 0, 0).top().expand().fillX();
        }

        //exit button
        final TextButton exit_Bt = super.createBt("EXIT", s_main.END_S);
        table.add(exit_Bt).size(80, 60).pad(10,0,0,40).top().fill();
        drawItem();
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        drawItem();
        drawSnake();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
}

