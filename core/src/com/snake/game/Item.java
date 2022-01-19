package com.snake.game;

import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

public abstract class Item {
    protected String name;
    public int i_value;
    public Cell i_cell;
    private final int i_size = 1;

    Item(){
        this.name = null;
        this.i_value = 0;
        this.i_cell = null;
    };

    public int getI_value() {
        return i_value;
    }
    public void setI_value(int value){
        this.i_value = value;
    }

    public Cell getI_cell() {
        return i_cell;
    }

    public void setI_cell(Cell i_cell) {
        this.i_cell = i_cell;
    }

    public String getName() {
        return name;
    }
    public abstract Animation getAnim();
    public abstract Image getImg();
    public abstract int addToScore(int score,int multiplier);
}