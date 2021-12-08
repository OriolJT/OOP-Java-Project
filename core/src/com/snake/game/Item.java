package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public class Item {
    private int i_value;
    private final int i_size = 1;
    private Cell[][] i_cell;
    private Image i_img;
    private Animation i_anim;

    Item(Image img, Animation anim){
        this.i_img = img;
        this.i_anim = anim;
    }

    public int getI_value() {
        return i_value;
    }
    public void setI_value(int value){
        i_value = value;
    }
}