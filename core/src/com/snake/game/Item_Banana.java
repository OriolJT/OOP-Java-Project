package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

/**
 * @Author
 * Minh Le
 */
public class Item_Banana extends Item{
    private Image img;
    private final String banana = "Banana";
    //point == Spawnrate


    Item_Banana(){
        super();
        this.name = banana;
        this.img = img;
    }
    public String getName(){
        return name;
    }
    public Image getImg() {
        return this.img;
    }
    public int addToScore(int score, int multiplier){
        return score+(multiplier*point);
    }
}
