package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.oop.Main;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture pole, mag, monk;
	Main game;

	@Override
	public void create() {
		batch = new SpriteBatch();
		pole = new Texture("pole.png");
	    mag = new Texture("mag.png");
	    monk = new Texture("monk.png");
		game = new Main();
		game.mainStep();
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(pole, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(mag, game.getArrayListDark().get(0).getPosition()[0]*mag.getWidth()/10, 0);
		batch.draw(monk, game.getArrayListDark().get(0).getPosition()[0]*mag.getWidth()/10, 150);
		batch.end();
		if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) game.step();

	}
	@Override
	public void dispose() {
		batch.dispose();
		pole.dispose();
	}
}
