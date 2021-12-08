package com.snake.game;

public class Board {
    private Game m_game;
    private Player m_player1;
    private Player m_player2;
    void startGame(Game game){
        m_game = game;
    }
    void setHighscore(int highscore){ //this class will be called by  the class Player when the highscore if the class changes.
        m_game.setHighscore(highscore);
    }

    public void moveSnake(int player, int direction) {
        if (player == 1){
            m_player1.move();
        }
        else{
            if (player == 2){
                m_player2.move();
            }
            else{
                //THROW EXCEPCTION
            }
        }
    }
}
