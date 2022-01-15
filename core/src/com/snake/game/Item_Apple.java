package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Apple extends Item{
    private Animation anim;
    private Image img;
    private final String apple = "Apple";
    //point == Spawnrate
    public final int point = 1;

    Item_Apple(){
        super();
        this.name = apple;
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
