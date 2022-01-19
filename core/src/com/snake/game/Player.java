package com.snake.game;

public class Player {
    protected String name;
    public Snake mySnake;

    Player(){
        this.name = null;
        this.mySnake = null;
    };




    public String getName() {
        return name;
    }

}