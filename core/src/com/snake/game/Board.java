package com.snake.game;
import java.util.Random;

public class Board {
    final int ROWS = 20; //this is a temporal number.
    final int COLS = 20;
    Random rand = new Random();


    private Main m_game;
    private Player m_player1;
    private Player m_player2;
    private int m_mode;
    private Cell[][] m_cells;
    private Item m_item;
    public int board_score1;
    public int board_score2;


    public int getBoard_score1(){
        return board_score1;
    }

    public int getBoard_score2(){
        return board_score2;
    }

    public int getRows(){
        return ROWS;
    }

    public int getCols(){
        return COLS;
    }

    public void startGame(Main game){
        m_game = game;
        m_cells = new Cell[ROWS][COLS];
        //Here we create Matrix of Cells.
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLS; column++) {
                m_cells[row][column] = new Cell(row, column);
            }
        }
        m_cells[3][3].setState(State.SNAKE); //TODO: DELETE THIS LINE SINCE ITS JUST TO TEST
        //Now we generate the 1st item of the game.
        createItem();
    }

    private void createItem(){ //This function can only be called when there is not another item on the board.
        //We create the item making sure that there is not a snake in that posisiton.
        boolean free = false;
        int row = -1;
        int col = -1;
        State temp = State.FREE;
        while (!free) {
            row = rand.nextInt(ROWS);
            col = rand.nextInt(COLS);
            if (m_cells[row][col].getState() == temp){
                free = true;
            }
        }

        int itemNumber = rand.nextInt(2);
        Item tempItem;
        if(itemNumber == 0){
            tempItem = new Item_Apple();
        }
        else {
            if (itemNumber == 1) {
                tempItem = new Item_Banana();
            } else {
                tempItem = new Item_Kiwi();
            }
        }
        m_item = tempItem; //Since there is only one item on the board, the class Board will have it. But the cell itself will know where the item is.
        m_cells[row][col].setState(State.ITEM);
        m_cells[row][col].setItem(m_item);
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