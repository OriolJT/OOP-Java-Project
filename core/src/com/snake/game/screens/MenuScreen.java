package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class MenuScreen implements Screen {

    private Screen_Main parent; //main
    private Stage stage; //controller

    public MenuScreen(Screen_Main main){
        parent = main;
        stage = new Stage(new ScreenViewport()); //create stage as a controller
    }

    public void startGame(){

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        //create a table
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        //temporary skin
        Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

        /* menu buttons */
        TextButton play_Bt = new TextButton("Play", skin );
        TextButton rule_Bt = new TextButton("Rules", skin);
        TextButton highScore_Bt = new TextButton("High Scores", skin );
        TextButton exit_Bt = new TextButton("Exit", skin );

        //create buttons to table
        table.add(play_Bt).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(rule_Bt).fillX().uniformX();
        table.row();
        table.add(highScore_Bt).fillX().uniformX();
        table.row();
        table.add(exit_Bt).fillX().uniformX();

        /* Button Listeners */
        //load Play Screen
        play_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                parent.changeScreen(Screen_Main.PLAY_S);
            }
        });
        //load Rule Screen
        rule_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                parent.changeScreen(Screen_Main.RULE_S);
            }
        });
        //load Score Screen
        highScore_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                parent.changeScreen(Screen_Main.SCORE_S);
            }
        });
        //exit program
        exit_Bt.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        //clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //let stage start draw
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
