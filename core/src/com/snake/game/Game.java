package com.snake.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.screens.MenuScreen;


public class Game extends com.badlogic.gdx.Game {
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    BitmapFont font;

    @Override
    public void create(){
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
    }

    @Override
    public void dispose(){
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }

    /*   private Board m_board;
    private Screen m_screen;
    private MenuScreen m_menu;

    public Game(String title,int width, int height){
        this.width = width;

    }
    void startGame(){ //main will call this function
        m_board.startGame(this);
        m_screen.startGame();
        m_menu.startGame();
    }
    public void run(){

    }


    /*
    void gameMode(int mode){ //class screen is gonna call this function with the decision of the player.
        m_board.gameMode(mode);
    }


    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
}

