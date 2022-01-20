package com.snake.game;


import com.snake.game.screens.Screen_Main;

public class Game implements Runnable {
    private final float timeUpdate = 1/60;
    private Main main;
    boolean isRunning;
    private Board board;
    public Game(Main main, Screen_Main screen_main) {
        this.board = screen_main.main.m_board;
        this.main =main;
    }
    @Override
    /**
     * @Author Minh Le
     */
    public void run(){
        isRunning=true;
        while(isRunning){
            try {
                main.m_screen.gameScreen.update();
                main.m_screen.gameScreen.render(timeUpdate);
            }catch(NullPointerException e){
            }
        }
    }


    /*   private Board m_board;
    private Screen m_screen;
    private MenuScreen m_menu;

    public Game(String title,int width, int height){
        this.width = width;

    }
    void startGame(){
        m_board.startGame(this);
        m_screen.startGame();
        m_menu.startGame();
    }
    public void run(){

    }


    /*
    void gameMode(int mode){ //class screen is gonna call this function with the decision of the player.
        m_board.gameMode(mode);
    }


    /* Since we have to see the highscore in real time, instead of the screen asking for the highscore, the class
        board will call the function setHighscore from the main so this one sends the order to the class Screen with
        the new value of the highscore.*/
}

