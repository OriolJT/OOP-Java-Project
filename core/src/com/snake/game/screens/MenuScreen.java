package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.snake.game.Main;


public class MenuScreen implements Screen {

    private Main parent;
    private Stage stage;

    public MenuScreen(Main Main){
        parent = Main;

        stage = new Stage(new ScreenViewport());    //
        Gdx.input.setInputProcessor(stage);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        //table
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        //temporary skin
        Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

        //buttons
        TextButton PlayBt = new TextButton("Play", skin );
        TextButton RuleBt = new TextButton("Rules", skin);
        TextButton HighScoreBt = new TextButton("High Scores", skin );

        table.add(PlayBt).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(RuleBt).fillX().uniformX();
        table.row();
        table.add(HighScoreBt).fillX().uniformX();
    }

    public void startGame(){

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
