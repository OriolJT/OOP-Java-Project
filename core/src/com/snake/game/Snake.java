package com.snake.game;

import java.util.LinkedList;
import com.snake.game.Board;

public class Snake {

    private LinkedList<Cell> snakeCells = new LinkedList<Cell>();

    //private Direction dir;
    private Cell head;
    private int size;

    public Snake(){//default, dont need specified cell

        //head = Cell(Board.getCols()/2,Board.getRows()/2);
        snakeCells.add(head);
        head.setState(State.SNAKE);
    }
    public Snake(Cell start){
        head = start;
        snakeCells.add(head);
        head.setState(State.SNAKE);
    }

    void eat() {
        snakeCells.add(head);
        head.setState(State.SNAKE); //now there's the head of the snake
    }

    void moveSnake(Cell cell){
        //actual movement
        Cell last = snakeCells.removeLast();
        last.setState(State.FREE); //THAT WAY?
        head = cell;
        head.setState(State.SNAKE);
        snakeCells.addFirst(head);

    }
    //create void movement with just direction

    //newCell MUST BE a valid option to move (col+-1, row+-1) and inside the board
    public boolean Crash(Cell newCell)
    {
        if(newCell.getState() == State.FREE) {
            return false;
        }else if(newCell.getState() == State.ITEM){
            return false;
        }else return true; //the only option left is another snake

    }

    public LinkedList<Cell> getSnakeCells()
    {
        return snakeCells;
    }

    public void setSnakeCells(LinkedList<Cell> snakeCells) { this.snakeCells = snakeCells;}

    public Cell getHead() {return head;}

    public void setHead(Cell head) {this.head = head;}
}