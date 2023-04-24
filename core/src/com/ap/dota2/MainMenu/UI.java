package com.ap.dota2.MainMenu;

import com.ap.dota2.Dota2Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Null;

public class UI
{
	private final MainMenu mainMenu;
	private final Stage stage;
	private final Table rootTable;

	public UI(MainMenu mainMenu, Stage stage, Table table)
	{
		this.mainMenu = mainMenu;
		this.stage = stage;
		this.rootTable = table;
		rootTable.setFillParent(true);
		stage.addActor(rootTable);
		Gdx.input.setInputProcessor(stage);

		table.setDebug(Dota2Game.DEBUG); // This is optional, but enables debug lines for tables.
	}

	/**
	 * initialize the UI
	 */
	public void init()
	{
		//!
		NinePatch patch = new NinePatch(new Texture("button1.png"), 12, 12, 12, 12);

		BitmapFont myFont = new BitmapFont();

		NinePatchDrawable drawable = new NinePatchDrawable(patch);

		TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
		myTextButtonStyle.fontColor = Color.RED;

		TextButton myButton = new TextButton("hello bluh bluh bluh bluh bluh bluh bluh bluh world", myTextButtonStyle);

		rootTable.add(myButton);
		///

		rootTable.row(); //!
		rootTable.add(makeNewButton("button3.png", "helloooooooooooooooooooo world", Color.BLUE));
	}

	/**
	 * create a new button (first edition - TextButton only)
	 * @param Image - the image of the button
	 * @param massage - the massage of the button
	 * @param color - the color of the button
	 * @return Button - ?
	 */
	public static Button makeNewButton (String Image, @Null String massage, @Null Color color)
	{
		NinePatch patch = new NinePatch(new Texture(Image), 12, 12, 12, 12);

		BitmapFont myFont = new BitmapFont();

		NinePatchDrawable drawable = new NinePatchDrawable(patch);

		TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
		if(color != null) myTextButtonStyle.fontColor = color;
		else myTextButtonStyle.fontColor = Color.RED;

		TextButton myButton = new TextButton(massage, myTextButtonStyle);
		return myButton;
	}

}
