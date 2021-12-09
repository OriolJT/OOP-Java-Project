package com.snake.game.screens;

import com.badlogic.gdx.Screen;
import com.snake.game.Main;


public class InitialScreen implements Screen {
    private Main parent;

    public InitialScreen(Main Main){
        parent = Main;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
