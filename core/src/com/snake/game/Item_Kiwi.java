package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item_Kiwi extends Item{
    private Animation anim;
    private Image img;
    private final String kiwi = "Kiwi";

    Item_Kiwi(){
        super();
        this.name = kiwi;
        this.anim = anim;
        this.img = img;
    }
}
