package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PlayScreen implements Screen{

    private Screen_Main parent;    //main
    private Stage stage;    //controller
    private Label title_L;  //label

    public PlayScreen(Screen_Main main){
        parent = main;
        stage = new Stage(new ScreenViewport()); //create stage as a controller
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

        //label
        title_L = new Label("Play", skin);
        //back button
        final TextButton back_Bt = new TextButton("Back", skin);
        back_Bt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Screen_Main.MENU_S);
            }
        });

        //draw table
        table.add(title_L);
        table.row();
        table.add(back_Bt).fillX().uniformX();
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

    }
}
