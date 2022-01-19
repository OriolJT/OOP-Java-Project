package com.snake.game.screens;

import com.snake.game.Main;

public class Screen_Main extends Thread{
    public Main main;

    public Screen_Main(Main main){
        this.main = main;
    }

    public void startGame(){

    }

    public void setHighscore(int highscore){

    }

    //Screens
    public  MenuScreen menuScreen;              // menu: 0
    public  PlayScreen playScreen;              // play: 1
    public  RuleScreen ruleScreen;              // rule: 2
    public  HighScoreScreen highScoreScreen;    // highScore: 3
    public  EndScreen endScreen;              // exit: 4
    public  GameScreen gameScreen;

    public static final int MENU_S = 0;
    public static final int PLAY_S = 1;
    public static final int RULE_S = 2;
    public static final int SCORE_S = 3;
    public static final int END_S = 4;
    public static final int GAME_S = 5;


    public void changeScreen(int screenNum) {
        switch (screenNum) {
            case MENU_S:
                if (menuScreen == null) menuScreen = new MenuScreen(main,this);
                main.setScreen(menuScreen);
                break;
            case PLAY_S:
                if (playScreen == null) playScreen = new PlayScreen(main,this);
                main.setScreen(playScreen);
                break;
            case RULE_S:
                if (ruleScreen == null) ruleScreen = new RuleScreen(main,this);
                main.setScreen(ruleScreen);
                break;
            case SCORE_S:
                if (highScoreScreen == null) highScoreScreen = new HighScoreScreen(main,this);
                main.setScreen(highScoreScreen);
                break;
            case END_S:
                if (endScreen == null) endScreen = new EndScreen(main, this);
                main.setScreen(endScreen);
                break;
            case GAME_S:
                main.startGame(1);
                if (gameScreen == null) gameScreen = new GameScreen(main,this);
                main.setScreen(gameScreen);
                break;
        }
    }
}


