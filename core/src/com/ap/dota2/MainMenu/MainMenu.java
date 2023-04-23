package com.ap.dota2.MainMenu;

import com.ap.dota2.Dota2Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * The main menu screen.
 * @author Parsa Salamatipour, Sina Sahabi
 * @version 1.0
 */
public class MainMenu implements Screen
{
	public final Dota2Game game;
	private final Stage stage;
	private final Table table;
	private final UI ui;


	
	/**
	 * Constructor for the main menu.
	 * @param game The game object.
	 */
	public MainMenu(Dota2Game game)
	{
		this.game = game;
		this.stage = new Stage(new ExtendViewport(1920, 1080));
		this.table = new Table();

		ui = new UI(this, stage, table);

		ui.init();
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		// clear the screen with the given RGB color (black)
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		ScreenUtils.clear(Color.BLACK);

		// tell the stage to do actions and draw itself
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height)
	{
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{
		stage.dispose();
	}
}
