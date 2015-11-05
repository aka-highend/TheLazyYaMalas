package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by fachrur_122 on 11/08/2015.
 *
 */
public class Musuh {
    Vector2 position;
    Texture musuhTexture;
    Player player;
    Rectangle bounds;

    public Musuh(Vector2 position, Player player) {
        musuhTexture = new Texture(Gdx.files.internal("Musuh.png"));
        this.position = position;
        this.player = player;
        bounds = new Rectangle(position.x, position.y, 50, 50);
    }

    public void update() {

        bounds = new Rectangle(position.x, position.y, 25, 25);

        if (player.getPosition().x > position.x) {
            position.x++;
        } else {
            position.x--;
        }
        if (player.getPosition().y > position.y) {
            position.y++;
        } else {
            position.y--;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

//    public void setPosition(Vector2 position) {
//        this.position = position;
//    }

    public Texture getMusuhTexture() {
        return musuhTexture;
    }

//    public void setMusuhTexture(Texture musuhTexture) {
//        this.musuhTexture = musuhTexture;
//    }

    public Rectangle getBounds() {
        return bounds;
    }

//    public void setBounds(Rectangle bounds) {
//        this.bounds = bounds;
//    }
}
