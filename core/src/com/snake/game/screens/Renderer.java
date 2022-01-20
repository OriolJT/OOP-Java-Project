package com.snake.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.State;



public class Renderer {
    private GameScreen GS;
    private ShapeRenderer shapeRenderer;


    Music music = Gdx.audio.newMusic(Gdx.files.internal("Snake Music.mp3"));

    public Renderer(GameScreen gameScreen){
        this.GS = gameScreen;
        shapeRenderer = new ShapeRenderer();
    }

    public void render(){
        music.setVolume(0.2f);
        music.play();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        /*
        // Drawing walls
        shapeRenderer.setColor(Color.DARK_GRAY);
        shapeRenderer.rect(0,0, gameScreen.scl, Gdx.graphics.getHeight()); // Left
        shapeRenderer.rect(Gdx.graphics.getWidth() - gameScreen.scl, 0, gameScreen.scl, Gdx.graphics.getHeight()); // Right
        shapeRenderer.rect(gameScreen.scl, 0, Gdx.graphics.getWidth() - gameScreen.scl, gameScreen.scl);
        shapeRenderer.rect(gameScreen.scl, Gdx.graphics.getHeight() - gameScreen.scl, Gdx.graphics.getWidth() - gameScreen.scl, gameScreen.scl);
         */
        for (int x = 0; x < GS.RowNCol - 1; x++) {
            for (int y = 0; y < GS.RowNCol - 1; y++) {
                // Draw a snake
                if (GS.cells[x][y].getState() == State.SNAKE ) {
                    shapeRenderer.setColor(Color.LIME);
                    shapeRenderer.rect(x * GS.RowNCol, y * GS.RowNCol, GS.RowNCol, GS.RowNCol);
                }
                if (GS.cells[x][y].getState() == State.SNAKE2 ) {
                    shapeRenderer.setColor(Color.YELLOW);
                    shapeRenderer.rect(x * GS.RowNCol, y * GS.RowNCol, GS.RowNCol, GS.RowNCol);
                }
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            GS.game.m_board.setDirection(1,1);

            System.out.println("A");
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            GS.game.m_board.setDirection(1,2);
            System.out.println("W");
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            GS.game.m_board.setDirection(1,3);
            System.out.println("D");
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            GS.game.m_board.setDirection(1,4);
            System.out.println("S");
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            GS.game.m_board.setDirection(2,1);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            GS.game.m_board.setDirection(2,2);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            GS.game.m_board.setDirection(2,3);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            GS.game.m_board.setDirection(2,4);
        }
        shapeRenderer.end();
    }

}
