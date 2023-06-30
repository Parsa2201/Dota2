package com.ap.dota2;

import com.ap.dota2.MainGame.MainGame;
import com.ap.dota2.MainMenu.MainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * This class is the main class of the game.
 * @author Parsa Salamatipour
 * @version 1.0
 */
public class Dota2Game extends Game
{
	public SpriteBatch batch;
	/**
	 * This is a boolean that is used to determine whether the game is in debug mode or not.
	 */
	public static final boolean DEBUG = false;
	private boolean isMainGame;
	private boolean screenChanged = false;

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		this.setScreen(new MainMenu(this));
	}

	public void goToMainMenu()
	{
		isMainGame = false;
		screenChanged = true;
	}

	public void startGame()
	{
		//this.setScreen(new MainMenu(this));
		isMainGame = true;
		screenChanged = true;
	}

	@Override
	public void render()
	{
		super.render(); // important!
		if(screenChanged)
		{
			if(isMainGame)
				setScreen(new MainGame(this, false));
			else
				setScreen(new MainMenu(this));
			screenChanged = false;
		}
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
