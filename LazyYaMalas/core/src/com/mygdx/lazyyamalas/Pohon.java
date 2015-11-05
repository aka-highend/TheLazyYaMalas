package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by fachrur_122 on 11/08/2015.
 *
 */
public class Pohon {
    Vector2 position, size;
    Texture pohon;
    Rectangle bounds;

    public Pohon(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
        bounds = new Rectangle(position.x, position.y, size.x, size.y);
        pohon = new Texture(Gdx.files.internal("pohon.png"));
    }

    public void update() {
        bounds.set(position.x, position.y, size.x, size.y);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(pohon, position.x, position.y, size.x, size.y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

//    public void setBounds(Rectangle bounds) {
//        this.bounds = bounds;
//    }

//    public Vector2 getPosition() {
//        return position;
//    }

//    public void setPosition(Vector2 position) {
//        this.position = position;
//    }
//
//    public Vector2 getSize() {
//        return size;
//    }
//
//    public void setSize(Vector2 size) {
//        this.size = size;
//    }
}
