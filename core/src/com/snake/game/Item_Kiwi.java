package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Kiwi extends Item{
    private Image img;
    private final String kiwi = "Kiwi";
    //point == Spawnrate


    Item_Kiwi(){
        super();
        this.name = kiwi;
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
