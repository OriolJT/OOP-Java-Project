package com.snake.game;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.snake.game.State;

public class Board {
    private final int ROWS = 30; //this is a temporal number.
    private final int COLS = 30;
    Random rand = new Random();


    private Main m_game;
    private Player m_player1;
    private Player m_player2;
    private int m_mode;
    private Cell[][] m_cells;
    private ArrayList<Item> m_item = new ArrayList<>();
    public int tempItemNum;
    boolean m_gameFinished;
    private Slotmachine slotmachine;

    public Player getM_player1(){
        return m_player1;
    }
    public Player getM_player2(){
        return m_player2;
    }
    public void setM_player1(Player player){
        this.m_player1 = player;
    }
    public void setM_player2(Player player){
        this.m_player2 = player;
    }
    public int getm_mode(){
        return m_mode;
    }
    public void setm_mode(int mode){
        this.m_mode = mode;
    }
    public Cell[][] getM_cells(){
        return this.m_cells;
    }
    public void setM_cells(Cell[][] cells){
        this.m_cells = cells;
    }
    public ArrayList<Item> getM_item(){
        return this.m_item;
    }
    public void setM_item(ArrayList<Item> arrayList){
            this.m_item = arrayList;
    }
    public Slotmachine getSlotmachine(){
        return this.slotmachine;
    }
    public boolean getM_gameFinished(){
        return m_gameFinished;
    }

    public Board(Main main) {
        m_gameFinished = false;
        m_game = main;
        tempItemNum = 0;
        Slotmachine slotmachine = new Slotmachine();
    }

    public int getBoard_score1() {
        return m_player1.getScore();
    }

    public int getBoard_score2() {
        return m_player2.getScore();
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public void startGame(int mode) {
        m_cells = new Cell[ROWS][COLS];
        //Here we create Matrix of Cells.
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLS; column++) {
                m_cells[row][column] = new Cell(row, column);
            }
        }

        //Now we generate the 1st item of the game.
        tempItemNum = createItem();
        gameMode(mode);
    }

    private int createItem() { //This function can only be called when there is not another item on the board.
        //We create the item making sure that there is not a snake in that posisiton.
        m_item = null; //we delete an item in case that already exists one in the game.
        boolean free = false;
        int row = -1;
        int col = -1;
        State temp = State.FREE;
        while (!free) {
            row = rand.nextInt(ROWS - 2) + 1; //1 to 28
            col = rand.nextInt(COLS - 3) + 1; //1 to 27 (because of buttons)
            if (m_cells[row][col].getState() == temp) {
                free = true;
            }
        }

        int itemNumber = rand.nextInt(3);

        Item tempItem = null;
        if (itemNumber == 0) {
            tempItem = new Item_Apple();
        } else {
            if (itemNumber == 1) {
                tempItem = new Item_Banana();
            } else if (itemNumber == 2) {
                tempItem = new Item_Kiwi();
            }
        }/* TODO change function because m_item is ArrayList
        m_item = tempItem; //Since there is only one item on the board, the class Board will have it. But the cell itself will know where the item is.
        m_cells[row][col].setState(State.ITEM);
        m_cells[row][col].setItem(m_item);
        tempItem.setI_cell(m_cells[row][col]);
         */
        return itemNumber;

    }

    public void setHighscore(int highscore) { //this class will be called by  the class Player when the highscore if the class changes
    }

    public Cell[][] getCells() {
        return m_cells;
    }

    private void gameMode(int mode) {
        m_mode = mode;
        int row = ROWS / 2;
        int col = COLS / 2;
        m_player1 = new Player(m_cells[row][col - 5], 1);
        if (mode == 1) { //singe player mode
            while (m_gameFinished) {
                this.moveSnake(1);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    // Restore the interrupted status
                    Thread.currentThread().interrupt();
                }
            }
        } else if (mode == 2) { //2 players mode (1 vs 1 mode)
            m_player2 = new Player(m_cells[row][col + 5], 2);
        } else {
            //THROW EXCEPCTION
            System.err.println("Player data wrong!");
        }
    }

    public void pickUpItem(){

    }
    public void setDirection(int player, int direction) {
        if (player == 1) {
            m_player1.mySnake.setDirection(direction);
        } else {
            m_player2.mySnake.setDirection(direction);
        }
    }

    public void moveSnake(int player) {
        if (player == 1) {
            switch (m_player1.mySnake.crash(m_player1.mySnake.movement())) {
                case 0:
                    m_gameFinished = true;
                    //m_game.gameOver(); //Snake dead so the game is finished.
                    break;
                case 1:
                    m_player1.mySnake.moveSnake(m_player1.mySnake.movement()); //Move snake to free cell
                    break;
                case 2:
                    m_player1.mySnake.moveSnake(m_player1.mySnake.movement()); //Pick up Item
                    m_player1.mySnake.movement().deleteItem();/*
                    m_player1.sumScore(m_item.getI_value());
                    */
                    createItem();
                    break;
            }
        } else {
            if (player == 2) {
                switch (m_player2.mySnake.crash(m_player2.mySnake.movement())) {
                    case 0:
                        //TODO Game Over
                        break;
                    case 1:
                        m_player2.mySnake.moveSnake(m_player2.mySnake.movement());
                        break;
                    case 2:
                        m_player2.mySnake.moveSnake(m_player2.mySnake.movement());
                        break;
                }
            } else {
                //THROW EXCEPTION
                System.err.println("Player data wrong!");
            }
        }
    }
}