package com.ap.dota2.MainMenu;

import com.ap.dota2.Dota2Game;
import com.ap.dota2.net.SocketClientHandler;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UI implements Screen {
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
//        NinePatch patch = new NinePatch(new Texture("button1.png"), 12, 12, 12, 12);
//
//        BitmapFont myFont = new BitmapFont();
//
//        NinePatchDrawable drawable = new NinePatchDrawable(patch);

//        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
//        myTextButtonStyle.fontColor = Color.RED;
        final Sound hoverSound = Gdx.audio.newSound(Gdx.files.internal("Hover.mp3"));
        final Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("Click.mp3"));
        final Music backgroundMusic;
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("background_music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.3F);
        backgroundMusic.play();
        rootTable.row();
        Texture backgroundTexture = new Texture(Gdx.files.internal("background2.jpg"));
        TextureRegion backgroundRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(backgroundRegion);
        final Image background = new Image(backgroundDrawable);
        background.setSize(stage.getWidth(), stage.getHeight());
        background.setFillParent(true);
        stage.addActor(background);


        Button startButton = new Button(getStyle("startSilver.png", "startGold.png"));
        startButton.setPosition(250, 400);
        stage.addActor(startButton);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                mainMenu.startGame();
                backgroundMusic.pause();
            }
        });
        startButton.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                hoverSound.play();
            }
        });


        Button exitButton = new Button(getStyle("exitSilver.png", "exitGold.png"));
        exitButton.setSize(830,232);
        exitButton.setPosition(1020, 431);
        stage.addActor(exitButton);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                System.exit(0);
                backgroundMusic.pause();


            }
        });
        exitButton.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                hoverSound.play();
            }
        });

        Button clientButton = new Button(getStyle("clientSilver.png", "clientGold.png"));
        clientButton.setSize(830, 232);
        clientButton.setPosition(1020, 100);
        stage.addActor(clientButton);
        clientButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                try
                {
                    String IP = InetAddress.getLocalHost().getHostAddress();
                    SocketClientHandler.getInstance().setGame(mainMenu.game);
                    SocketClientHandler.getInstance().setIp(IP);
                    // TODO: show the ip to the user
                    // .
                    // .
                    // .


                } catch (UnknownHostException e)
                {
                    throw new RuntimeException(e);
                }
                backgroundMusic.pause();
            }
        });
        clientButton.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                hoverSound.play();
            }
        });

        Button serverButton = new Button(getStyle("serverSilver.png", "serverGold.png"));
        serverButton.setSize(830, 232);
        serverButton.setPosition(250, 100);
        stage.addActor(serverButton);
        serverButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                String IP = "localhost"; // TODO: set the ip from a text field
                SocketClientHandler.getInstance().setGame(mainMenu.game);
                SocketClientHandler.getInstance().setIp(IP);
                backgroundMusic.pause();
            }
        });
        serverButton.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                hoverSound.play();
            }
        });


//        rootTable.add(makeStartButton("startGold.png", "", Color.WHITE));
//        rootTable.add(makeExitButton("exitGold.png", "", Color.YELLOW));
    }

    /*
    *These implemented methods are from Screen interface, which are not decided to be deleted or not yet
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the stage
        stage.act(v);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    private Button.ButtonStyle getStyle(String upButton, String downButton)
    {
        TextureRegion buttonUp = new TextureRegion(new Texture(Gdx.files.internal(upButton)));
        TextureRegion buttonDown = new TextureRegion(new Texture(Gdx.files.internal(downButton)));
        TextureRegion buttonOver = new TextureRegion(new Texture(Gdx.files.internal(downButton)));
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.over = new TextureRegionDrawable(buttonOver);
        style.up = new TextureRegionDrawable(buttonUp);
        style.down = new TextureRegionDrawable(buttonDown);
        return style;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

//    /**
//     * create a new button (second edition - TextButton only)
//     *
//     * @param Image   - the image of the button
//     * @param message - the message of the button
//     * @param color   - the color of the button
//     * @return Button - ?
//     */
//    public Button makeStartButton(String Image, @Null String message, @Null Color color) {
//        NinePatch patch = new NinePatch(new Texture(Image), 22, 22, 22, 22);
//        NinePatchDrawable drawable = new NinePatchDrawable(patch);
//        BitmapFont bitmapFont = new BitmapFont();
//        bitmapFont.getData().setScale(5);
//        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, bitmapFont);
//        if (color != null) myTextButtonStyle.fontColor = color;
//        else myTextButtonStyle.fontColor = Color.RED;
//
//        TextButton myButton = new TextButton(message, myTextButtonStyle);
//
//
//        myButton.addListener(new InputListener() {
//            @Override
//            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
//                mainMenu.startGame();
//                return true;
//            }
//
//
//        });
//
//
//        return myButton;
//    }
//
//    public Button makeExitButton(String Image, @Null String massage, @Null Color color) {
//        NinePatch patch = new NinePatch(new Texture(Image), 22, 22, 22, 22);
//
//        BitmapFont myFont = new BitmapFont();
//        myFont.getData().setScale(3.2F);
//
//        NinePatchDrawable drawable = new NinePatchDrawable(patch);
//
//        TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle(drawable, drawable, drawable, myFont);
//        if (color != null) myTextButtonStyle.fontColor = color;
//        else myTextButtonStyle.fontColor = Color.RED;
//
//        TextButton myButton = new TextButton(massage, myTextButtonStyle);
//
//        myButton.addListener(new InputListener() {
//            @Override
//            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
//                System.exit(0);
//                return true;
//            }
//        });
//
//        return myButton;
//    }

}
