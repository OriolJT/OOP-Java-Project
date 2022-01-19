package com.snake.game;
//import java.awt.event.*;

public abstract class Player {

    protected String name;
    public Snake mySnake;

    Player(){
        this.name = null;
        this.mySnake = null;
    };

    Player(String name, Cell cell) {
        this.name = name;
        this.mySnake = Snake(cell);
    };



    public String getName() {
        return name;
    }

/*
    this is a sample code for keybinding, take what is needed form here
    public void keyPressed(KeyEvent k){
        switch(k.getKeyCode()){
            case KeyEvent.VK_LEFT:
                mySnake.setDirection(1);
                break;
            case KeyEvent.VK_UP:
                mySnake.setDirection(2);
                break;
            case KeyEvent.VK_RIGHT:
                mySnake.setDirection(3);
                break;
            case KeyEvent.VK_DOWN:
                mySnake.setDirection(4);
                break;
            case KeyEvent.VK_A:
                mySnake.setDirection(1);
                break;
            case KeyEvent.VK_W:
                mySnake.setDirection(2);
                break;
            case KeyEvent.VK_D:
                mySnake.setDirection(3);
                break;
            case KeyEvent.VK_S:
                mySnake.setDirection(4);
                break;
        }
 */

    }
}