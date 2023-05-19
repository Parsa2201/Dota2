package com.ap.dota2.MainGame;

import com.ap.dota2.Dota2Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainGame implements Screen, InputProcessor
{
    public final Dota2Game game;
    private final GameElements gameElements;

    public MainGame(Dota2Game game)
    {
        this.game = game;
        gameElements = new GameElements(game.batch);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        gameElements.action(delta);

        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();
        gameElements.draw(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
        gameElements.resize(width, height);
    }

    @Override
    public void dispose()
    {
        gameElements.dispose();
    }

    @Override
    public void show()
    {
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
    public boolean keyDown(int keycode)
    {
        return gameElements.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return gameElements.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character)
    {
        return gameElements.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return gameElements.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return gameElements.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return gameElements.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return gameElements.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return gameElements.scrolled(amountX, amountY);
    }
}
