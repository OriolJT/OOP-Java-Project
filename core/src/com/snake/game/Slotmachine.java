package com.snake.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author Minh Le
 * Slotmachine(Combosystem) is unused mostly
 */
public class Slotmachine {
    private final ArrayList<Item> itemArrayList = new ArrayList<>();
    private final int s_number = 3;
    public int s_factor;


    Slotmachine(){
       ArrayList<Item> itemArrayList = new ArrayList<>(s_number);
    }


    public boolean checkForItem(Item item){
        int i=0;
        boolean rightItem=false;
        while(itemArrayList.get(i)!=null&&itemArrayList.size()<=3){
            if(itemArrayList.get(i).getName().equals(item.getName())){
                rightItem = true;
            }
        }
        return rightItem;
    }
    public void addItem(Item item){
        if (itemArrayList.get(0)==null) {
            itemArrayList.add(item);
        }
        int i = 0;
        if(itemArrayList.get(i).getName().equals(item.getName())&&itemArrayList.size()<=3){
            i++;
            addItem(item);
        }
    }
    public int s_calcFactor(){
        int factor = 1;
        int i = 0;
        while(itemArrayList.get(i)!=null){
            factor++;
            i++;
        }
        return factor;
    }
    public void setS_item(Item item, int index){
        itemArrayList.set(index,item);
    }
    public Item getS_item(int index){
        return itemArrayList.get(index);
    }
}
