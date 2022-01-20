package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

import java.awt.*;

/**
 * @Author Minh Le
 *
 */
public class Item_Apple extends Item{
    private Image img;
    private final String apple = "Apple";

    Texture texture_a = new Texture(Gdx.files.internal("apple.png"));

    Item_Apple(){
        super();
        this.name = apple;
        this.img = img;
    }
    public String getName(){
        return name;
    }
    public Image getImg(){
        return this.img;
    }
    public int addToScore(int score, int multiplier){
        return score+(multiplier*point);
    }

}
