/*package com.snake.game;

import com.snake.game.screens.MenuScreen;

public class Game {
    private Board m_board;
    private Screen m_screen;
    private MenuScreen m_menu;

    void startGame(){ //main will call this function
        m_board.startGame(this);
        m_screen.startGame();
        m_menu.startGame();
    }

    void gameMode(int mode){ //class screen is gonna call this function with the decision of the player.
        m_board.gameMode(mode);
    }


    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
/*
    void setHighscore(int highscore){
        m_screen.setHighscore(highscore);
    }

    void moveSnake(int player, char direction){
        m_board.moveSnake(player, direction);
    }

}
*/