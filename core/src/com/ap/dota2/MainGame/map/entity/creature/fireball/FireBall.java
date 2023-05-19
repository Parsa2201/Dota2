package com.ap.dota2.MainGame.map.entity.creature.fireball;

import com.ap.dota2.MainGame.map.entity.Entity;
import com.ap.dota2.MainGame.standards.Damage;
import com.ap.dota2.MainGame.standards.Position;
import com.ap.dota2.MainGame.standards.Velocity;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class FireBall extends Entity
{
    protected final Velocity velocity;
    protected final Position startPosition;
    protected final Position targetPosition;
    protected final Damage damage;

    public FireBall(Position startPosition, Position targetPosition, Velocity velocity, Damage damage)
    {
        super(startPosition.getX(), startPosition.getY());
        this.startPosition = startPosition;
        this.targetPosition = targetPosition;
        this.velocity = velocity;
        this.damage = damage;
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
}
