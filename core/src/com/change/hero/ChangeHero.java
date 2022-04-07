package com.change.hero;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChangeHero extends ApplicationAdapter {

	public static int WINDOW_WIDTH = 1280;
	public static int WINDOW_HEIGHT = 720;

	SpriteBatch batch;
	Texture heroMario;
	Texture arrowNext;
	Texture arrowPrevious;
	Texture bg;
	BitmapFont textX;
	BitmapFont textY;

	int marioX = WINDOW_WIDTH / 2 - 100 / 2;
	int marioY = WINDOW_HEIGHT / 2 - 200 / 2;

	BackGround bgPos = new BackGround(WINDOW_WIDTH , WINDOW_HEIGHT);

	Hero mario = new Hero(marioX , marioY , 100 , 200 , "hero1.png");
	Arrow next = new Arrow(marioX + mario.heroWidth  , marioY , 150 , 100);
	Arrow previous = new Arrow(marioX - 50 , marioY , 150 , 100);

	Text mouseX = new Text(50 , WINDOW_HEIGHT - 10 , 100 , 50);
	Text mouseY = new Text(50 , WINDOW_HEIGHT - 30 , 100 , 50);

	public int nextFreeSpace = next.arrowWidth / 2;
	public int previouseFreeSpace = previous.arrowWidth;

	@Override
	public void create () {
		batch = new SpriteBatch();
		arrowNext = new Texture("next.png");
		arrowPrevious = new Texture("previous.png");
		textX = new BitmapFont();
		textY = new BitmapFont();
		bg = new Texture("bg.jpeg");
	}


	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		mario.changeHero();

		mario.heroTexture = "hero" + mario.textureNum + ".png";

		int cursorY = WINDOW_HEIGHT - 1 - Gdx.input.getY();
		int cursorX = Gdx.input.getX();

		batch.begin();
		batch.draw(bg , 0 , 0 , bgPos.bgWidth , bgPos.bgHeight);
		textX.draw(batch , "Mouse x: " +  cursorX , mouseX.textPositionX , mouseX.textPositionY);
		textY.draw(batch , "Mouse y: " + cursorY  , mouseY.textPositionX , mouseY.textPositionY);
		batch.draw(heroMario = new Texture(mario.heroTexture) , mario.heroPositionX , mario.heroPositionY , mario.heroWidth , mario.heroHeight);
		batch.draw(arrowNext , next.arrowPositionX + nextFreeSpace , next.arrowPositionY + next.arrowHeight / 2 , next.arrowWidth , next.arrowHeight);
		batch.draw(arrowPrevious , previous.arrowPositionX - previouseFreeSpace , previous.arrowPositionY + previous.arrowHeight / 2, previous.arrowWidth, previous.arrowHeight);
		batch.end();
	}
}
