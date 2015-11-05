package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by fachrur_122 on 11/08/2015.
 *
 */
public class TableScreen implements Screen {
    Game game;

    Stage stage;
    Table table;

    SpriteBatch batch;

    public TableScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage();
        batch = new SpriteBatch();

        table = new Table();
        table.debug();
        table.setBounds(Gdx.graphics.getWidth() / 48, 0, Gdx.graphics.getWidth() - (Gdx.graphics.getHeight() / 24), Gdx.graphics.getHeight());

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.input.setInputProcessor(stage);
        stage.act();

        batch.begin();
        stage.draw();
//        table.drawDebug(stage);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
