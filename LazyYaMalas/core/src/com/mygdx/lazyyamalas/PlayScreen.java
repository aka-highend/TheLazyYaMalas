package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by fachrur_122 on 11/08/2015.
 *
 */
public class PlayScreen implements Screen {
    SpriteBatch batch;
    Player player;
    InputProcessor inputProcessor;
    Texture texture;
    Vector2 position;
    Pohon pohon, pohon2;
    ShapeRenderer sr;
    ArrayList<Pohon> pepohonan;
    Iterator<Pohon> iterationPohon;
    ArrayList<Musuh> bnykMusuh;
    Iterator<Musuh> musuhIterator;

    ArrayList<Tile> tiles;
    Iterator<Tile> tilesIterator;

    OrthographicCamera cam;

    Musuh musuh;
    Game game;

    public PlayScreen(Game game) {
        this.game = game;
//        this.player = player;
    }

    @Override
    public void show() {
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("fachrur.png"));
        sr = new ShapeRenderer();
        pohon = new Pohon(new Vector2(100, 100), new Vector2(50, 100));
        pohon2 = new Pohon(new Vector2(200, 100), new Vector2(50, 100));

        pepohonan = new ArrayList<Pohon>();
        bnykMusuh = new ArrayList<Musuh>();
        pepohonan.add(pohon);
        pepohonan.add(pohon2);
        System.out.println(pepohonan.size());

//		texture = new Texture(Gdx.files.internal("fachrur.png"));
//
//		position = new Vector2(683 - 64, 384 - 64);

        if (Gdx.files.local("player.dat").exists()) {
            try {
                player = new Player(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2), "fachrur.png");
                player.setPosition(Player.readPlayer());
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Player Exists, Reading File");
        } else {
            player = new Player(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2), "fachrur.png");
            try {
                player.savePlayer(player);
            }catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Player Doesn't Exists, Creating Player and Saving Player");
        }

        musuh = new Musuh(new Vector2(50, 50), player);
        bnykMusuh.add(musuh);

        bnykMusuh.add(new Musuh(new Vector2(100, 100), player));

        tiles = new ArrayList<Tile>();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20d; j++) {
                int R = (int) ((Math.random() * (2 - 0) + 0));
                if (R == 0) {
                    tiles.add(new Tile(new Texture("grass.png"), i * 50, j * 50, 50, 50));
                }
                if (R == 1) {
                    tiles.add(new Tile(new Texture("dirt.png"), i * 50, j * 50, 50, 50));
                }
            }
        }



        //setScreen(new MainMenu(game));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pohon.update();
        player.update();

        cam.position.set(player.getPosition().x + (player.getCurrentFrame().getRegionWidth() / 2), player.getPosition().y + (player.getCurrentFrame().getRegionWidth() / 2), 0);
        batch.setProjectionMatrix(cam.combined);
        cam.update();

        batch.begin();

        tilesIterator = tiles.iterator();
        while(tilesIterator.hasNext()) {
            Tile cur = tilesIterator.next();
            cur.render(batch);
        }


        batch.draw(player.getCurrentFrame(), player.getPosition().x, player.getPosition().y);
        //pohon.draw(batch);
        iterationPohon = pepohonan.iterator();
        while(iterationPohon.hasNext()) {
            Pohon cur = iterationPohon.next();
            cur.draw(batch);
            cur.update();

            if (player.getBounds().overlaps(cur.getBounds())) {
                player.reAdjust();
            }
        }

        musuhIterator = bnykMusuh.iterator();
        while(musuhIterator.hasNext()) {
            Musuh cur = musuhIterator.next();

            cur.update();
            batch.draw(cur.getMusuhTexture(), cur.getPosition().x, cur.getPosition().y, 25, 25);

            if (player.getBounds().overlaps(cur.getBounds())) {
                System.out.println("PLAYER HITS!!");
            }
        }

        //System.out.println(bnykMusuh.size());
        batch.end();

//		sr.begin(ShapeRenderer.ShapeType.Line);
//		sr.setColor(Color.BLUE);
//		sr.rect(player.getPosition().x, player.getPosition().y, player.getCurrentFrame().getRegionWidth(), player.getCurrentFrame().getRegionHeight());
//		sr.setColor(Color.RED);
//		sr.rect(pohon.getPosition().x, pohon.getPosition().y, pohon.getSize().x, pohon.getSize().y);
//		sr.end();
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
        try {
            player.savePlayer(player);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
