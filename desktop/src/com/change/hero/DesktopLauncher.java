package com.change.hero;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.change.hero.ChangeHero;

public class DesktopLauncher extends ChangeHero{
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(ChangeHero.WINDOW_WIDTH , ChangeHero.WINDOW_HEIGHT);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new ChangeHero(), config);
	}
}
