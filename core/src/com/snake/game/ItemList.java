package com.snake.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author Minh Le
 * class Itemlist, holds every Item that is currently on the board
 */
public class ItemList {
    public ArrayList<Item> itemArrayList;
    public ItemList(){
        itemArrayList = new ArrayList<>(3);
    }
    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }
    public ArrayList<Item> getItemArrayList(){
        return itemArrayList;
    }
    public void addItem(Item item){
        if(itemArrayList.size()<3)
        itemArrayList.add(item);
    }
    public void removeItem(Item item){
        itemArrayList.remove(item);
    }
}
