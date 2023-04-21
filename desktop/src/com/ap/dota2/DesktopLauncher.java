package com.ap.dota2;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher
{
	public static void main(String[] arg)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		// set configurations
		config.setForegroundFPS(60); // fps
		config.setTitle("Dota2");    // title
		config.setMaximized(true);   // maximize
		config.useVsync(true);       // vsync

		new Lwjgl3Application(new Dota2Game(), config);
	}
}
