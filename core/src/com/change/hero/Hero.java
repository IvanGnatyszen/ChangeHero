package com.change.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Hero {
    int heroPositionX;
    int heroPositionY;
    int heroWidth;
    int heroHeight;
    public int textureNum = 1;
    int heroCount = 3;

    String heroTexture;

    public Hero(int heroPositionX, int heroPositionY, int heroWidth, int heroHeight, String heroTexture) {
        this.heroPositionX = heroPositionX;
        this.heroPositionY = heroPositionY;
        this.heroWidth = heroWidth;
        this.heroHeight = heroHeight;
        this.heroTexture = heroTexture;
    }

    public void changeHero(){

        // By numPad
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            if(textureNum < heroCount){
                textureNum++;
            } else {
                textureNum = 1;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            if(textureNum <= heroCount && textureNum > 1){
                textureNum--;
            } else {
                textureNum = heroCount;
            }
        }
        int cursorX = Gdx.input.getX();
        int cursorY = Gdx.input.getY();
    }
}
