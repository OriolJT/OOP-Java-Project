package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.State;


public class Renderer {
    private GameScreen GS;
    private ShapeRenderer shapeRenderer;

    public Renderer(GameScreen gameScreen){
        this.GS = gameScreen;
        shapeRenderer = new ShapeRenderer();
    }

    public void render(){
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
                /*
                // Draw items as a filled Cell (not image)
                else if(gameScreen.cells[x][y].getState() == State.ITEM) {
                    shapeRenderer.setColor(Color.RED);
                    shapeRenderer.rect(x * gameScreen.scl, y * gameScreen.scl, gameScreen.scl, gameScreen.scl);
                    //banana
                    //kiwi
                }
                */
            }
        }
        shapeRenderer.end();
    }
}
