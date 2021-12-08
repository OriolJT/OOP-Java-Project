package com.snake.game;

public class Slotmachine {
    private Item s_item1;
    private Item s_item2;
    private Item s_item3;
    public double s_factor;

    Slotmachine(){
        s_item1 = s_item2 = s_item3 = null;
    }
    Slotmachine(Item item1){
        s_item1 = item1;
    }
    Slotmachine(Item item1, Item item2){
        s_item1 = item1;
        s_item2 = item2;
    }
    Slotmachine(Item item1, Item item2, Item item3){
        s_item1 = item1;
        s_item2 = item2;
        s_item3 = item3;
    }

    public double check_factor(){
        if (s_item1.getI_value()==s_item2.getI_value() && s_item1.getI_value() ==s_item3.getI_value()){
            s_factor=3;
        }
        return s_factor;
    }

}
