package com.snake.game;
public class Player {
    private final String name;
    private final Snake snake;
    private char previousdir;
    public Player(Snake snake){
        name = Player;
        this.snake = snake;
    }

    Cell move(char direction){
        if(direction != 'SAME'){
            int row = snake.getHead().getY();
            int col = snake.getHead().getX();
            if(direction = 'RIGHT') col++;
            else if(direction == 'LEFT') col--;
            else if(direction == 'UP') row--;
            else if(direction == 'DOWN') row++; //else if and not else cause could be an 'CRASH' option to not move
            Cell movetoCell(col,row);
            return movetoCell;
        }else{
            direction = previousdir;
           return move(direction); //recursive

        }
    }
}
