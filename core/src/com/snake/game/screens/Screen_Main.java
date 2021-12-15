package com.snake.game.screens;

import com.snake.game.Main;

public class Screen_Main {
    private Main parent;

    public Screen_Main(Main main){
        parent = main;
    }

    //Screens
    public MenuScreen menuScreen;              // menu: 0
    public PlayScreen playScreen;              // play: 1
    public RuleScreen ruleScreen;              // rule: 2
    public HighScoreScreen highScoreScreen;    // highScore: 3
    public ExitScreen exitScreen;              // exit: 4
    // SetupScreen setupScreen;

    public static final int MENU_S = 0;
    public static final int PLAY_S = 1;
    public static final int RULE_S = 2;
    public static final int SCORE_S = 3;
    public static final int EXIT_S = 4;
    //final int SETUP = 4;


    public void changeScreen(int screenNum) {
        switch (screenNum) {
            case MENU_S:
                if (menuScreen == null) menuScreen = new MenuScreen(this);
                parent.setScreen(menuScreen);
                break;
            case PLAY_S:
                if (playScreen == null) playScreen = new PlayScreen(this);
                parent.setScreen(playScreen);
                break;
            case RULE_S:
                if (ruleScreen == null) ruleScreen = new RuleScreen(this);
                parent.setScreen(ruleScreen);
                break;
            case SCORE_S:
                if (highScoreScreen == null) highScoreScreen = new HighScoreScreen(this);
                parent.setScreen(highScoreScreen);
                break;
            case EXIT_S:
                if (exitScreen == null) exitScreen = new ExitScreen(this);
                parent.setScreen(exitScreen);
                break;
        }
    }
}


