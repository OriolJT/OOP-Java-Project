package com.snake.game.screens;

import com.badlogic.gdx.Screen;

public class InitialScreen implements Screen {
    private Screen_Main parent; //to store main

    public InitialScreen(Screen_Main main){
        parent = main;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // After loading initialScreen, load menuScreen
        parent.changeScreen(Screen_Main.MENU_S);
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