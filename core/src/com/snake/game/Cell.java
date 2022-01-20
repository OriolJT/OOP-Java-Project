package com.snake.game;

public class Cell {
    private int x, y;
    private State state; //what is inside the cell
    private Item m_item;

    public Cell(){
        this.x = 0;
        this.y = 0;
    }

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
        if(this.state==State.ITEM){
            setItem(null);
            setState(State.FREE);
        }
    }
}
