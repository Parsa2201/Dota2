package com.ap.dota2.MainGame.map.entity.creature;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Hero extends Creature
{
    public Hero(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Batch batch)
    {

    }

    @Override
    public void action(float delta)
    {

    }

    @Override
    public void move(float delta)
    {

    }

    @Override
    public void attack()
    {

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
    public void dispose()
    {

    }
}
