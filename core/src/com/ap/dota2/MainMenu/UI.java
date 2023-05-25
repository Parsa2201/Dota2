package com.ap.dota2.MainMenu;

import com.ap.dota2.Dota2Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Null;
import java.io.File;

public class UI {
    private final MainMenu mainMenu;
    private final Stage stage;
    private final Table rootTable;


    public UI(MainMenu mainMenu, Stage stage, Table table) {
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
    public void init() {
        //!
        NinePatch patch = new NinePatch(new Texture("button1.png"), 12, 12, 12, 12);

        BitmapFont myFont = new BitmapFont();

        NinePatchDrawable drawable = new NinePatchDrawable(patch);

        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
        myTextButtonStyle.fontColor = Color.RED;
        rootTable.row();

        Texture backgroundTexture = new Texture(Gdx.files.internal("background.jpg"));
        TextureRegion backgroundRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(backgroundRegion);
        Image background = new Image(backgroundDrawable);
        background.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(background);
        rootTable.add(makeStartButton("startGold.png", "", Color.WHITE));
        rootTable.add(makeExitButton("exitGold.png", "", Color.YELLOW));
    }

    /**
     * create a new button (second edition - TextButton only)
     *
     * @param Image   - the image of the button
     * @param message - the message of the button
     * @param color   - the color of the button
     * @return Button - ?
     */
    public Button makeStartButton(String Image, @Null String message, @Null Color color) {
        NinePatch patch = new NinePatch(new Texture(Image), 22, 22, 22, 22);
        NinePatchDrawable drawable = new NinePatchDrawable(patch);
        BitmapFont bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(5);
        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, bitmapFont);
        if (color != null) myTextButtonStyle.fontColor = color;
        else myTextButtonStyle.fontColor = Color.RED;

        TextButton myButton = new TextButton(message, myTextButtonStyle);


        myButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                mainMenu.startGame();
                return true;
            }


        });


        return myButton;
    }

    public Button makeExitButton(String Image, @Null String massage, @Null Color color) {
        NinePatch patch = new NinePatch(new Texture(Image), 22, 22, 22, 22);

        BitmapFont myFont = new BitmapFont();
        myFont.getData().setScale(3.2F);

        NinePatchDrawable drawable = new NinePatchDrawable(patch);

        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
        if (color != null) myTextButtonStyle.fontColor = color;
        else myTextButtonStyle.fontColor = Color.RED;

        TextButton myButton = new TextButton(massage, myTextButtonStyle);

        myButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
                return true;
            }
        });

        return myButton;
    }

}
