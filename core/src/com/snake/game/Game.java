package com.snake.game;

public class Game {
    private Board m_board;
    private Screen m_screen;
    private Menu m_menu;

    void startGame(){
        m_board.startGame();
        m_screen.startGame();
        m_menu.startGame();
    }
}
