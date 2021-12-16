package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Kiwi extends Item{
    private Animation anim;
    private Image img;
    private final String kiwi = "Kiwi";
    //point == Spawnrate
    public final int point = 3;

    Item_Kiwi(){
        super();
        this.name = kiwi;
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
