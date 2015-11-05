package com.mygdx.lazyyamalas;

import com.badlogic.gdx.Game;

public class LazyYaMalas extends Game {
	Game game;

	@Override
	public void create() {
		game = this;
		setScreen(new MainMenu(game));
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
