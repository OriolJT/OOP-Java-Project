package com.snake.game;

public class Game {
    private Board m_board;
    private Screen m_screen;
    private Menu m_menu;

    void startGame(){
        m_board.startGame(this);
        m_screen.startGame();
        m_menu.startGame();
    }


    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
    void setHighscore(int highscore){
        m_screen.setHighscore(highscore);
    }

    void moveSnake(int player, int direction){
        m_board.moveSnake(player, direction);
    }

}
