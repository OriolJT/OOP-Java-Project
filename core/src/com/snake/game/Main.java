package com.snake.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.snake.game.screens.*;

public class Main extends Game{
    public Board m_board;
    public Screen_Main m_screen;

    @Override
    public void create() {
        //Init Screen as menuScreen
        m_screen = new Screen_Main(this);
        setScreen(new MenuScreen(this, m_screen));
        m_board = new Board(this);
        //Multithreading myThread = new Multithreading();

    }

    @Override
    public void dispose(){
        super.dispose();
        Gdx.app.exit();
        System.exit(0);
    }

    @Override
    public void render() {
        super.render();
    }

    public void startGame(int mode){ //main will call this function
        m_screen.startGame();
        m_board.startGame(mode);
   }

   public void refreshGameScreen(){
        //m_screen.
   }

    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
    public void setHighscore(int highscore){
        m_screen.setHighscore(highscore);
    }

    public void moveSnake(int player){
        m_board.moveSnake(player);
    }

    public void setDirection(int player, int direction){
        m_board.setDirection(player, direction);
    }


    public void gameOver(){ //TODO: probably its not enough to end the game, look at this.
        m_screen.changeScreen(4);
    }
}
