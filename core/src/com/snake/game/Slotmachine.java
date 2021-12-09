package com.snake.game;

public class Slotmachine {
    private Item [] s_slots;
    private final int s_number = 3;
    public double s_factor;

    Slotmachine(){
        s_slots = new Item[s_number];
    }

    Slotmachine(Item item1){
        s_slots = new Item[s_number];
        s_slots[0] = item1;
    }
    Slotmachine(Item item1, Item item2){
        s_slots = new Item[s_number];
        s_slots[0] = item1;
        s_slots[1] = item2;
    }
    Slotmachine(Item item1, Item item2, Item item3){
        s_slots = new Item[s_number];
        s_slots[0] = item1;
        s_slots[1] = item2;
        s_slots[2] = item3;
    }

    public double s_calcFactor(){
        //if the first slot of the Slotmachine is empty,
        //the whole Slotmachine is empty hence the factor will be 1
        if(s_slots[0]==null){
            return s_factor=1;
        }
        if (s_slots[0].getName()==s_slots[1].getName() && s_slots[0].getName() ==s_slots[2].getName()){
            s_factor=3;
        } else if (s_slots[0].getName()==s_slots[1].getName()){
            s_factor=2;
        } else {s_factor=1;}
        return s_factor;
    }
    public void setS_item(Item item, int number){
        this.s_slots[number-1]= item;
    }
    public Item getS_item(int number){
        return s_slots[number-1];
    }
};
