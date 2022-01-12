package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Banana extends Item{
    private Animation anim;
    private Image img;
    private final String banana = "Banana";
    //point == Spawnrate
    public final int point = 2;

    Item_Banana(){
        super();
        this.name = banana;
        this.anim = anim;
        this.img = img;
    }
    public Image getImg(){
        return this.img;
    }
    public Animation getAnim(){
        return this.anim;
    }
    public int addToScore(int score, int multiplier){
        return score+(multiplier*point);
    }
}
