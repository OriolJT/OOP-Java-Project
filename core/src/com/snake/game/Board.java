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
    private ItemList itemList;
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
    public void setM_cells(Cell[][] cells){
        this.m_cells = cells;
    }
    public ItemList getItemList(){
        return this.itemList;
    }
    public void setItemList(ItemList itemList){
            this.itemList = itemList;
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
        ItemList ItemList = new ItemList();
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

        //TODO - For test
        m_cells[5][5].setState(State.SNAKE);
        m_cells[15][5].setState(State.ITEM);
        m_cells[20][20].setState(State.SNAKE2);


        //Now we generate the 1st item of the game.
        gameMode(mode);
    }

    /**
     * @Author Minh Le
     * Spawns a Player at a given Cell depending on if its player 1 or 2
     * @param cell
     * @param i
     * @return
     */
    public boolean spawnPlayer(Cell cell,int i){
        if(m_cells[cell.getX()][cell.getY()].getState()!=State.FREE){
            return false;
        }
        switch(i){
            case 1 :
                Player player = new Player();
                Snake snake = new Snake();
                snake.setHead(cell);
                player.setName("Player 1");
                player.setSnake(snake);
                m_cells[cell.getX()][cell.getY()].setPlayer(player,1);
                return true;
            case 2:
                Player player2 = new Player();
                Snake snake2 = new Snake();
                snake2.setHead(cell);
                player2.setName("Player 2");
                player2.setSnake(snake2);
                m_cells[cell.getX()][cell.getY()].setPlayer(player2,2);
                return true;
        }
        return true;
    }

    /**
     * @Author Minh Le spawns an Item at a given Cell
     * @param cell
     * @return boolean
     */
    public boolean spawnItem(Cell cell){
        if(m_cells[cell.getX()][cell.getY()].getState()!=State.FREE){
            return false;
        }
        int spawn =  rand.nextInt(3);
        switch(spawn){
            case 1:
                Item item = new Item_Apple();
                item.setI_cell(cell);
                m_cells[cell.getX()][cell.getY()].setItem(item);
                m_cells[cell.getX()][cell.getY()].setState(State.ITEM);
                // Adding Items to ItemList
                // ItemList.addItem(item);
                return true;
            case 2:
                Item item2 = new Item_Banana();
                item2.setI_cell(cell);
                m_cells[cell.getX()][cell.getY()].setItem(item2);
                m_cells[cell.getX()][cell.getY()].setState(State.ITEM);
                // ItemList.addItem(item2);
                return true;
            case 3:
                Item item3 = new Item_Kiwi();
                item3.setI_cell(cell);
                m_cells[cell.getX()][cell.getY()].setItem(item3);
                m_cells[cell.getX()][cell.getY()].setState(State.ITEM);
                //ItemList.addItem(item3);
                return true;
        }
        return true;
    }
    /*
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
        } TODO change function because m_item is ArrayList
        m_item = tempItem; //Since there is only one item on the board, the class Board will have it. But the cell itself will know where the item is.
        m_cells[row][col].setState(State.ITEM);
        m_cells[row][col].setItem(m_item);
        tempItem.setI_cell(m_cells[row][col]);

        return itemNumber;

    }
    */

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
    public void testSnake(Cell cell){
        m_player1.mySnake.setHead(cell);
        m_cells[cell.getX()][cell.getY()].setState(State.SNAKE);
        m_cells[cell.getX()][cell.getY()].setPlayer(m_player1,1);
    }

    /**
     * @Author Minh Le , Oriol
     * @param player
     */
    public void moveSnake(int player) {
        m_player1.mySnake.moveSnake(m_player1.mySnake.movement()); //Move snake to free cell
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