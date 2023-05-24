package com.ap.dota2.MainGame.map.entity;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.creature.Hero;
import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.ap.dota2.MainMenu.MainMenu;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Entities implements InputProcessor, HasAction, Disposable, DotaDrawable
{
    // a libgdx hash for entities
    private final Array<Entity> entities;
    private final Map map;

    public Entities(Map map)
    {
        entities = new Array<>();
        this.map = map;
        entities.add(new Hero(1800, 1200));
    }

    @Override
    public boolean keyDown(int keycode)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.keyDown(keycode))
                return true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.keyUp(keycode))
                return true;

        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.keyTyped(character))
                return true;

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.touchDown(screenX, screenY, pointer, button))
                return true;

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.touchUp(screenX, screenY, pointer, button))
                return true;

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.touchDragged(screenX, screenY, pointer))
                return true;

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.mouseMoved(screenX, screenY))
                return true;

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        for(Entity entity : new Array.ArrayIterator<>(entities))
            if(entity.scrolled(amountX, amountY))
                return true;

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
