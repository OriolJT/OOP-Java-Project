package com.snake.game;

public class Cell {
    private int x, y;
    private State state; //what is inside the cell

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

  /* public enum State {
        FREE,
        SNAKE,
        ITEM
    }*/
}
