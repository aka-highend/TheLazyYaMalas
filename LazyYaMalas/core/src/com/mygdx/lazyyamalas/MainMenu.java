package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by fachrur_122 on 11/08/2015.
 *
 */
public class MainMenu implements Screen {
    Stage stage;
    Label label;
    Label.LabelStyle style;
    BitmapFont font;

    TextureAtlas buttonAtlas;
    TextButton.TextButtonStyle buttonStyle;
    TextButton playButton, physicsButton, tableButton;
    Skin skin;

    SpriteBatch batch;
//    Player player;

    Game game;

    public MainMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage();

        font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
        style = new Label.LabelStyle(font, Color.BLUE);

        label = new Label("BADR INTERACTIVE", style);
        label.setPosition((Gdx.graphics.getWidth() / 2) - (label.getWidth() / 2), Gdx.graphics.getHeight() - label.getHeight());

        stage.addActor(label);

        skin = new Skin();
        //buttonAtlas = new TextureAtlas(Gdx.files.internal("button/button.pack"));
        buttonAtlas = new TextureAtlas(Gdx.files.internal("button/button.pack"));
        skin.addRegions(buttonAtlas);

        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.up = skin.getDrawable("button");
        buttonStyle.over = skin.getDrawable("buttonpressed");
        buttonStyle.down = skin.getDrawable("buttonpressed");
        buttonStyle.font = font;

        playButton = new TextButton("PLAY", buttonStyle);
        playButton.setWidth(Gdx.graphics.getWidth() / 3);
        playButton.setHeight(Gdx.graphics.getHeight() / 6);
        playButton.setPosition((Gdx.graphics.getWidth() / 2) - (playButton.getWidth() / 2), (Gdx.graphics.getHeight() / 2) - (playButton.getHeight() / 2));

        stage.addActor(playButton);
        Gdx.input.setInputProcessor(stage);

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.getTextInput(new Input.TextInputListener() {
//
//                    @Override
//                    public void input(String text) {
//                        player = loadPlayer();
////                        player.setName(text);
//                        game.setScreen(new PlayScreen(game, player));
//                        stage.clear();
//                    }
//
//                    @Override
//                    public void canceled() {
//
//                    }
//                }, "What's your name dude?", "<Insert Text Here>");
//                return true;
                game.setScreen(new PlayScreen(game));
                stage.clear();
                return true;
            }
        });

        physicsButton = new TextButton("PHYSICS", buttonStyle);
        physicsButton.setWidth(Gdx.graphics.getWidth() / 3);
        physicsButton.setHeight(Gdx.graphics.getHeight() / 6);
        physicsButton.setPosition((Gdx.graphics.getWidth() / 2) - (physicsButton.getWidth() / 2), (Gdx.graphics.getHeight() / 4));

        stage.addActor(physicsButton);

        physicsButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                stage.clear();
                game.setScreen(new PhysicsScreen(game));
                return true;
            }
        });

        tableButton = new TextButton("TABLES", buttonStyle);
        tableButton.setWidth(Gdx.graphics.getWidth() / 3);
        tableButton.setHeight(Gdx.graphics.getHeight() / 6);
        tableButton.setPosition((Gdx.graphics.getWidth() / 2) - (tableButton.getWidth() / 2), (Gdx.graphics.getHeight() / 4) - (2 * (tableButton.getHeight() / 2)));

        stage.addActor(tableButton);

        tableButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                stage.clear();
                game.setScreen(new TableScreen(game));
                return true;
            }
        });

        batch = new SpriteBatch();
    }

//    public Player loadPlayer() {
//        Player player = null;
//        if (Gdx.files.local("Player.dat").exists()) {
//            try {
//                player = new Player(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2), "fachrur.png");
//                player.setPosition(Player.readPlayer());
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return player;
//    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        batch.begin();
        stage.draw();
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
