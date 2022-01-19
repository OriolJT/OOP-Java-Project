package com.snake.game;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import com.snake.game.Board;

public class Snake {

    private LinkedList<Cell> snakeCells = new LinkedList<Cell>();

    private int direction; // 1=LEFT 2=UP 3=RIGHT 4=DOWN
    private Cell head;
    private int size;

    /*public Snake(){//default, don't need specified cell

        head = Cell(Board.getCols()/2,Board.getRows()/2); //this gives conflict
        snakeCells.add(head);
        head.setState(State.SNAKE);
    }*/

    public Snake(Cell start){
        head = start;
        snakeCells.add(head);
        head.setState(State.SNAKE);
        direction = 4; //default movement is down
    }

    void eat() {
        snakeCells.add(head);
        head.setState(State.SNAKE); //now there's the head of the snake
    }

    public Cell movement(){ //calculates where to move

        Cell head = getHead();
        int x = head.getX();
        int y = head.getY();

        switch(direction){
            case 1: //left
                x--;
                break;
            case 2: //up
                y++;
                break;
            case 3: //right
                x++;
                break;
            case 4:
                y--;
                break;
        }

        Cell nextCell = new Cell(x,y);
        return nextCell;
    }

    void moveSnake(Cell cell){
        //actual movement
        Cell last = snakeCells.removeLast();
        last.setState(State.FREE); //THAT WAY?
        head = cell;
        head.setState(State.SNAKE);
        snakeCells.addFirst(head);

    }

    //newCell MUST BE a valid option to move (col+-1, row+-1) and inside the board
    public int crash(Cell newCell)
    {
        int aux =-1;
        switch(newCell.getState()){
            case FREE:
                aux = 1;
                break;
            case ITEM:
                aux = 2;
                break;
            case SNAKE:
                aux = 0;
                break;
            case SNAKE2:
                aux = 0;
                break;
        }
        return aux;
    }

    public LinkedList<Cell> getSnakeCells()
    {
        return snakeCells;
    }

    public void setSnakeCells(LinkedList<Cell> snakeCells) { this.snakeCells = snakeCells;}

    public int getDirection() {return direction;}

    public void setDirection(int dir) {this.direction = dir;}

    public Cell getHead() {return head;}

    public void setHead(Cell head) {this.head = head;}
}