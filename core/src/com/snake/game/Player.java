package com.snake.game;
//import java.awt.event.*;



public class Player {

    protected String name;
    public Snake mySnake;

    Player(){
        this.mySnake = null;
        this.name = null;
    }
    Player(String name, Cell head){

        this.mySnake = new Snake(head);
        this.name = name;
    }



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
