package com.snake.game;

public class Board {
    final int ROWS = 20; //this is a temporal number.
    final int COLS = 20;


    private Game m_game;
    private Player m_player1;
    private Player m_player2;
    private int m_mode;
    private Cell[][] m_cells;



    public void startGame(Game game){
        m_game = game;
        m_cells = new Cell[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLS; column++) {
                m_cells[row][column] = new Cell(row, column);
            }
        }
    }

    public void setHighscore(int highscore){ //this class will be called by  the class Player when the highscore if the class changes.
        m_game.setHighscore(highscore);
    }

    public Cell[][] getCells()
    {
        return m_cells;
    }

    public void gameMode(int mode){
        m_mode = mode;
        if (mode == 1){ //singe player mode
            //m_player1.start();
        }
        else
            if (mode == 2){ //2 players mode (1 vs 1 mode)

            }
            else{
                //THROW EXCEPCTION
                System.err.println("Player data wrong!");
            }
    }

    public void moveSnake(int player, char direction) {
        if (player == 1){
            m_player1.move(direction);
        }
        else{
            if (player == 2){
                m_player2.move(direction);
            }
            else{
                //THROW EXCEPCTION
                System.err.println("Player data wrong!");
            }
        }
    }
}
