package com.ap.dota2.MainGame.map.entity.Tower;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.Entity;
import com.ap.dota2.MainGame.standards.Damage;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Tower extends Entity
{
    private final Damage damage;

    public Tower(Map map, int x, int y)
    {
        super(map, x, y);
        damage = new Damage(10);
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
