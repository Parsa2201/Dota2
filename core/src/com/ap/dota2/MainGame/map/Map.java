package com.ap.dota2.MainGame.map;

import com.ap.dota2.MainGame.camera.DotaCamera;
import com.ap.dota2.MainGame.map.entity.Entities;
import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.ap.dota2.MainGame.standards.HasAction;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public class Map implements DotaDrawable, Disposable, InputProcessor, HasAction
{
    private final Texture background;
    public final Obstacles obstacles;
    public final Entities entities;
    public final DotaCamera camera;
    public static final int WIDTH = 16340;
    public static final int HEIGHT = 16340;

    public Map(DotaCamera camera)
    {
        background = new Texture("map - 2.png");
        obstacles = new Obstacles();
        entities = new Entities(this);
        this.camera = camera;
    }

    @Override
    public void draw(Batch batch)
    {
        batch.draw(background, 0, 0, WIDTH, HEIGHT);
        obstacles.draw(batch);
        entities.draw(batch);
    }

    @Override
    public void dispose()
    {
        background.dispose();
        obstacles.dispose();
        entities.dispose();
    }

    @Override
    public boolean keyDown(int keycode)
    {
        return entities.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return entities.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character)
    {
        return entities.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return entities.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return entities.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return entities.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return entities.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return entities.scrolled(amountX, amountY);
    }

    @Override
    public void action(float delta)
    {
        entities.action(delta);
    }
}
