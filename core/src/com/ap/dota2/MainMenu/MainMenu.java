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
	private final Dota2Game game;
	private final Stage stage;
	private final Table table;

	/**
	 * create a new button (first edition - TextButton only)
	 * @param Image
	 * @param massage
	 * @param color
	 * @return Button
	 */
	public static Button makeNewButton (String Image, @Null String massage, @Null Color color) {
		NinePatch patch = new NinePatch(new Texture(Image), 12, 12, 12, 12);
		
		BitmapFont myFont = new BitmapFont();
		
		NinePatchDrawable drawable = new NinePatchDrawable(patch);

		TextButtonStyle myTextButtonStyle = new TextButtonStyle(drawable, drawable, drawable, myFont);
		if (color != null) myTextButtonStyle.fontColor = color;
		else myTextButtonStyle.fontColor = Color.RED;
		
		TextButton myButton = new TextButton(massage, myTextButtonStyle);
		return myButton;
	}
	
	/**
	 * Constructor for the main menu.
	 * @param game The game object.
	 */
	public MainMenu(Dota2Game game)
	{
		this.game = game;
		this.stage = new Stage(new ExtendViewport(1920, 1080));
		Gdx.input.setInputProcessor(stage);

		this.table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		table.setDebug(true); // This is optional, but enables debug lines for tables.

		//!
		NinePatch patch = new NinePatch(new Texture("button1.png"), 12, 12, 12, 12);
		
		BitmapFont myFont = new BitmapFont();
		
		NinePatchDrawable drawable = new NinePatchDrawable(patch);

		TextButtonStyle myTextButtonStyle = new TextButtonStyle(drawable, drawable, drawable, myFont);
		myTextButtonStyle.fontColor = Color.RED;

		TextButton myButton = new TextButton("hello bluh bluh bluh bluh bluh bluh bluh bluh world", myTextButtonStyle);

		table.add(myButton);
		///

		table.row(); //!
		table.add(makeNewButton("button3.png", "helloooooooooooooooooooo world", Color.BLUE));
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
