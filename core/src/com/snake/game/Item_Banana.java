package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Banana extends Item{
    private Animation anim;
    private Image img;
    private final String banana = "Banana";

    Item_Banana(){
        super();
        this.name = banana;
        this.anim = anim;
        this.img = img;
    }
}
