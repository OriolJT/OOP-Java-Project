package com.snake.game;

/**
 * @Author Minh Le,
 */
public class Player {
    protected String name;
    public Snake mySnake;
    public int m_score;

    public Player(){
        this.name= "";
        this.mySnake = new Snake();
        this.m_score = 0;
    }
    public Player(Cell cell, int playerNum){
        this.name = null;
        this.mySnake = new Snake(cell, playerNum);
        this.m_score = 0;
    }

    public int getScore(){
        return m_score;
    }
    public void setScore(int score){
        this.m_score = score;
    }
    public void sumScore(int points){
        this.m_score += points;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Snake getSnake(){
        return mySnake;
    }
    public void setSnake(Snake snake){
        this.mySnake = snake;
    }
}