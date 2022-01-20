package com.snake.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
