package com.snake.game;

public class Player {
    protected String name;
    public Snake mySnake;
    public int m_score;

    public Player(Cell cell){
        this.name = null;
        this.mySnake = new Snake(cell);
        this.m_score = 0;
    };

    public int getScore(){
        return m_score;
    }

    public void sumScore(int points){
        this.m_score += points;
    }

    public String getName() {
        return name;
    }

}