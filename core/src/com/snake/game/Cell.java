package com.snake.game;

public class Cell {
    private int x, y;
    private State state; //what is inside the cell
    private Item m_item;
    private Player player;

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

    public void setX(){
        this.x=x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public Item getM_item(){
        return this.m_item;
    }
    public void setItem(Item item)
    {
        m_item = item;
        setState(State.ITEM);
    }
    public void deleteItem(){ //TODO:
        if(this.state==State.ITEM){
            setItem(null);
            setState(State.FREE);
        }
    }

    public void setPlayer(Player player, int i) {
        switch (i){
            case 1 :
                this.player=player;
                setState(State.SNAKE);
                break;
            case 2:
                this.player=player;
                setState(State.SNAKE2);
        }
    }
}
