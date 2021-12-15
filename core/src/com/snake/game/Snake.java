package com.snake.game;

import java.util.LinkedList;


public class Snake {

    private LinkedList<Cell> snakeCells = new LinkedList<Cell>();

    private static final int INITIAL_SIZE = 3;

    //private Direction dir;
    private Cell head;
    private int size;

    Snake(){
        //need variable for position in multiplayer mode
        head = Cell(COL/2 ,ROWS/2); //need class to get col n rows
        snakeCells.add(head);
        head.setState(Cell.State.SNAKE);

    }
    void moveSnake(Cell cell){
        //actual movement
        Cell last = snakeCells.removeLast();
        last.setState(Cell.State.FREE);

    }

}
