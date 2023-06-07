package com.ap.dota2.MainGame;

import com.ap.dota2.MainGame.camera.DotaCamera;
import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.ap.dota2.MainGame.standards.Resizable;
import com.ap.dota2.MainGame.map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public class GameElements implements DotaDrawable, InputProcessor, HasAction, Resizable, Disposable
{
    private final DotaCamera camera;
    public final Map map;

    public GameElements(Batch batch)
    {
        camera = new DotaCamera(batch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        map = new Map(camera);
    }

    @Override
    public void draw(Batch batch)
    {
        map.draw(batch);
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if(camera.keyDown(keycode))
            return true;
        return map.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(camera.keyUp(keycode))
            return true;
        return map.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character)
    {
        if(camera.keyTyped(character))
            return true;
        return map.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if(camera.touchDown(screenX, screenY, pointer, button))
            return true;
        return map.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        if(camera.touchUp(screenX, screenY, pointer, button))
            return true;
        return map.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        if(camera.touchDragged(screenX, screenY, pointer))
            return true;
        return map.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        if(camera.mouseMoved(screenX, screenY))
            return true;
        return map.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        if(camera.scrolled(amountX, amountY))
            return true;
        return map.scrolled(amountX, amountY);
    }

    @Override
    public void action(float delta)
    {
        map.action(delta);
        camera.action(delta);
    }

    @Override
    public void resize(int width, int height)
    {
        camera.resize(width, height);
    }

    @Override
    public void dispose()
    {
        map.dispose();
    }
}
