package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.snake.game.State;


public class Renderer {
    private GameScreen gameScreen;
    private ShapeRenderer shapeRenderer;

    Texture texture = new Texture(Gdx.files.internal("apple.png"));
    Image apple = new Image(texture);

    public Renderer(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        shapeRenderer = new ShapeRenderer();
    }

    public void render(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Drawing walls
        shapeRenderer.setColor(Color.DARK_GRAY);
        shapeRenderer.rect(0,0, gameScreen.scl, Gdx.graphics.getHeight()); // Left
        shapeRenderer.rect(Gdx.graphics.getWidth() - gameScreen.scl, 0, gameScreen.scl, Gdx.graphics.getHeight()); // Right
        shapeRenderer.rect(gameScreen.scl, 0, Gdx.graphics.getWidth() - gameScreen.scl, gameScreen.scl);
        shapeRenderer.rect(gameScreen.scl, Gdx.graphics.getHeight() - gameScreen.scl, Gdx.graphics.getWidth() - gameScreen.scl, gameScreen.scl);

        // Drawing a snake
        shapeRenderer.setColor(Color.LIME);
        for (int x = 0; x < gameScreen.rows - 1; x++) {
            for (int y = 0; y < gameScreen.cols - 1; y++) {
                if (gameScreen.cells[x][y].getState() == State.SNAKE )
                    shapeRenderer.rect(x * gameScreen.scl, y * gameScreen.scl, gameScreen.scl, gameScreen.scl);
                else if (gameScreen.cells[x][y].getState() == State.ITEM)
                    apple.setPosition(x*10, y*10);
            }
        }
        shapeRenderer.end();
    }
}
