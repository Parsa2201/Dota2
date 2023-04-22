package com.ap.dota2;

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

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render()
	{
		super.render(); // important!
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
