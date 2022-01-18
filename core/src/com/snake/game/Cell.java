package com.snake.game;

public class Cell {
    private int x, y;
    private State state; //what is inside the cell
    private Item m_item;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.setState(State.FREE);
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public static Cell add(Cell b){
        return new Cell(this.x + b.x, this.y + b.y);
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setItem(Item item){
        m_item = item;
    }
    public void deleteItem(){ //TODO:

    }
}
