package com.snake.game;
import java.util.Random;

public class Board {
    final int ROWS = 20; //this is a temporal number.
    final int COLS = 20;
    Random rand = new Random();

    private Game m_game;
    private Player m_player1;
    private Player m_player2;
    private int m_mode;
    private Cell[][] m_cells;
    private Item m_item;


    public int getRows(){
        return ROWS;
    }

    public int getCols(){
        return COLS;
    }

    public void startGame(Game game){
        m_game = game;
        m_cells = new Cell[ROWS][COLS];
        //Here we create Matrix of Cells.
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLS; column++) {
                m_cells[row][column] = new Cell(row, column);
            }
        }
        //Now we generate the 1st item of the game.
        createItem();
    }

    private void createItem(){ //This function can only be called when there is not another item on the board.
        //We create the item making sure that there is not a snake in that posisiton.
        int row = rand.nextInt(ROWS);
        int col = rand.nextInt(COLS);
        if (m_player1.snakeInPos(row, col) == false || m_player2.snakeInPos(row, col) == false){
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
            State aux = State.ITEM;
            m_cells[row][col].setState(aux);
        }
        else{
            createItem(); //TODO: SINCE THIS PART IS RECURSIVE, MAKE SURE THAT THERE ARE NO BUGS.
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
