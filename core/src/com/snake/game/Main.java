package com.snake.game;

import com.badlogic.gdx.Game;

import com.snake.game.screens.HighScoreScreen;
import com.snake.game.screens.InitialScreen;
import com.snake.game.screens.MenuScreen;
import com.snake.game.screens.RuleScreen;


public class Main extends Game {
    //Screens
    private InitialScreen initialScreen;
    private MenuScreen menuScreen;
    private RuleScreen ruleScreen;
    private HighScoreScreen highScoreScreen;


    @Override
    public void create () {
        //Init Screen
        initialScreen = new InitialScreen(this);
        setScreen(initialScreen);
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
    }

    public void changeScreen() {
        if(menuScreen == null)
            menuScreen = new MenuScreen(this);
        this.setScreen(menuScreen);
    }
}