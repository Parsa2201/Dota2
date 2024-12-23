package com.ap.dota2.MainGame.map.entity;

import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.ap.dota2.MainGame.standards.Position;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public abstract class Entity implements DotaDrawable, HasAction, InputProcessor, Disposable
{
    protected final Position position;

    public Entity(int x, int y)
    {
        position = new Position(x, y);
    }

    @Override
    public abstract void draw(Batch batch);

    @Override
    public abstract void action(float delta);

    @Override
    public abstract boolean keyDown(int keycode);

    @Override
    public abstract boolean keyUp(int keycode);

    @Override
    public abstract boolean keyTyped(char character);

    @Override
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);

    @Override
    public abstract boolean touchUp(int screenX, int screenY, int pointer, int button);

    @Override
    public abstract boolean touchDragged(int screenX, int screenY, int pointer);

    @Override
    public abstract boolean mouseMoved(int screenX, int screenY);

    @Override
    public abstract boolean scrolled(float amountX, float amountY);

    @Override
    public abstract void dispose();
}
