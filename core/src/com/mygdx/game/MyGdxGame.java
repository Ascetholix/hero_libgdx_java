package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.oop.Main;
import com.mygdx.game.oop.Unit.Person;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture pole, mag, monk,sniper,spearman,crossbowman, outlaw,farmer,die;
	Main game;

	@Override
	public void create() {
		batch = new SpriteBatch();
		pole = new Texture("pole1.png");
	    mag = new Texture("mag.png");
	    monk = new Texture("monk.png");
		sniper = new Texture("sniper.png");
		spearman = new Texture("spearman.png");
		crossbowman = new Texture("crossbowman.png");
		outlaw = new Texture("outlaw.png");
		farmer = new Texture("farmer.png");
		die = new Texture("die.png");
		game = new Main();
		game.mainStep();
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(pole, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		int count=0;
		for (int i = 0; i < 10; i++) {
			batch.draw(getPersonWhite(i), (game.getArrayListDark().get(i).getPosition()[0]), 0+3+count);
			count+=48;
		}
		count = 0;
		for (int i = 0; i < 10; i++) {
			batch.draw(getPersonDark(i), (game.getArrayListDark().get(i).getPosition()[0]+600), 0+3+count);
			count+=48;
		}
		batch.end();
		if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) game.step();

	}
	@Override
	public void dispose() {
		batch.dispose();
		pole.dispose();
	}
	public Texture getPersonDark(int i){
		ArrayList<Person> person = Main.arrayListDark;
		if(person.get(i).getState().equals("Die"))return die;
		if(person.get(i).getInfo().equals("Колдун"))return mag;
		if(person.get(i).getInfo().equals("Снайпер"))return sniper;
		if(person.get(i).getInfo().equals("Разбойник"))return outlaw;
		if(person.get(i).getInfo().equals("Фермер"))return farmer;

		return null;
	}
	public Texture getPersonWhite(int i){
		ArrayList<Person> person = Main.arrayListWhite;
		if(person.get(i).getState().equals("Die"))return die;
		if(person.get(i).getInfo().equals("Монах"))return monk;
		if(person.get(i).getInfo().equals("Копейщик"))return spearman;
		if(person.get(i).getInfo().equals("Арбалетчик"))return crossbowman;
		if(person.get(i).getInfo().equals("Фермер"))return farmer;

		return null;
	}

}
