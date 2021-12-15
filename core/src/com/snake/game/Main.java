package com.snake.game;

import com.badlogic.gdx.Game;
import com.snake.game.screens.*;

public class Main extends Game {
    @Override
    public void create() {
        InitialScreen initialScreen;

        //Init Screen
        initialScreen = new InitialScreen(new Screen_Main(this));
        setScreen(initialScreen);
    }

    @Override
    public void render() {
        super.render();
    }


}
