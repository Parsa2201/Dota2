package com.ap.dota2.MainGame.map.entity;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.creature.hero.Hero;
import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.ap.dota2.net.SocketClientHandler;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Entities implements InputProcessor, HasAction, Disposable, DotaDrawable, Iterable<Entity>
{
    // a libgdx hash for entities
    private final Array<Entity> entities;
    public final Map map;
    public final Hero hero;

    public Entities(Map map)
    {
        entities = new Array<>();
        this.map = map;
        SocketClientHandler socketClientHandler = SocketClientHandler.getInstance();
        this.hero = new Hero(map, 1800, 1800);
        hero.setId(SocketClientHandler.getInstance().getId());
        entities.add(hero);
        socketClientHandler.newHero(hero);
    }

    public void addHero(Hero hero)
    {
        entities.add(hero);
    }

    @Override
    public boolean keyDown(int keycode)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.keyDown(keycode))
//                return true;
        return hero.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.keyUp(keycode))
//                return true;

        return hero.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.keyTyped(character))
//                return true;

        return hero.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.touchDown(screenX, screenY, pointer, button))
//                return true;

        return hero.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.touchUp(screenX, screenY, pointer, button))
//                return true;

        return hero.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.touchDragged(screenX, screenY, pointer))
//                return true;

        return hero.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.mouseMoved(screenX, screenY))
//                return true;

        return hero.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
//        for(Entity entity : new Array.ArrayIterator<>(entities))
//            if(entity.scrolled(amountX, amountY))
//                return true;

        return hero.scrolled(amountX, amountY);
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

    @NotNull
    @Override
    public Iterator<Entity> iterator()
    {
        return new Array.ArrayIterator<>(entities);
    }
}
