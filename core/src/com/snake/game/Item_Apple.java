package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Apple extends Item{
    private Animation anim;
    private Image img;
    private final String apple = "Apple";

    Item_Apple(){
        super();
        this.name = apple;
        this.anim = anim;
        this.img = img;
    }
}
