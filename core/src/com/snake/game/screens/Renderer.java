package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.State;



public class Renderer {
    private GameScreen GS;
    private ShapeRenderer shapeRenderer;


    public Renderer(GameScreen gameScreen){
        this.GS = gameScreen;
        shapeRenderer = new ShapeRenderer();
    }

    public void render(int modeFlag, int x, int y){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        if (GS.cells[x][y].getState() == State.SNAKE){
            shapeRenderer.setColor(Color.LIME);
            shapeRenderer.rect(x * GS.RowNCol, y * GS.RowNCol, GS.RowNCol, GS.RowNCol);
        }
        if(modeFlag == 2) {
            if (GS.cells[x][y].getState() == State.SNAKE2) {
                shapeRenderer.setColor(Color.YELLOW);
                shapeRenderer.rect(x * GS.RowNCol, y * GS.RowNCol, GS.RowNCol, GS.RowNCol);
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
