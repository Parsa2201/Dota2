package com.ap.dota2.MainGame.map.entity;

import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Entities implements InputProcessor, HasAction, Disposable, DotaDrawable
{
    // a libgdx hash for entities
    private final Array<Entity> entities;

    public Entities()
    {
        entities = new Array<>();
    }

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return false;
    }

    @Override
    public void action(float delta)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            entity.action(delta);
    }

    @Override
    public void dispose()
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            entity.dispose();
    }

    @Override
    public void draw(Batch batch)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            entity.draw(batch);
    }
}
