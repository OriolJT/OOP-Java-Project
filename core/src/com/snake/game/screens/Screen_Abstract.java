package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.*;
import com.snake.game.Main;


public class Screen_Abstract implements Screen {
    protected final Main main;
    protected final Screen_Main s_main;
    protected final Stage stage; //controller

    private Table table;
    private Skin skin;
    private Viewport viewport;

    protected Screen_Abstract(Main main,Screen_Main s_main){
        this.main = main;
        this.s_main = s_main;
        this.viewport = new StretchViewport(900, 900);
        this.stage = new Stage(viewport);
    }

    protected Table createTable(){
        if(table == null){
            table = new Table(getSkin());
            table.setFillParent(true);
            stage.addActor(table);
        }
        return table;
    }

    protected Skin getSkin(){
        if(skin == null){
            skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        }
        return skin;
    }

    protected TextButton createBt(String name, final int screenName){
        final TextButton Bt = new TextButton(name, getSkin());

        Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                s_main.changeScreen(screenName);
            }
        });
        return Bt;
     }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.stage);
    }

    @Override
    public void render(float v) {
        //clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
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
        if(skin != null){
            skin.dispose();
        }
        if(stage != null){
            stage.dispose();
        }

    }
}


