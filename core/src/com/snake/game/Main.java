package com.snake.game;

import com.badlogic.gdx.Game;
import com.snake.game.screens.*;
import com.snake.game.screens.MenuScreen;

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

    public Board m_board;
    private Screen m_screen;
   // private MenuScreen m_menu;

    public void startGame(int mode){ //main will call this function
        m_board = new Board();
        m_board.gameMode(mode);
        m_screen = new Screen();
        m_board.startGame(this);
        m_screen.startGame();
       // m_menu.startGame();
    }

    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
    public void setHighscore(int highscore){
        m_screen.setHighscore(highscore);
    }

    public void moveSnake(int player, char direction){
        m_board.moveSnake(player, direction);
    }

    public Cell[][] getCells(){
        return m_board.getCells();
    }
}
