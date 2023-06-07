package com.ap.dota2.MainGame.standards;

import com.ap.dota2.MainGame.map.Map;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Position
{
    float x;
    float y;

    public Position(float x, float y)
    {
        this.x = x;
        this.y = y;

        verifyPosition();
    }

    public Position(Vector2 vector)
    {
        this.x = vector.x;
        this.y = vector.y;

        verifyPosition();
    }

    public Position(Vector3 vector)
    {
        this.x = vector.x;
        this.y = vector.y;

        verifyPosition();
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void setX(float x)
    {
        this.x = x;
        verifyPosition();
    }
    public void setY(float y)
    {
        this.y = y;
        verifyPosition();
    }

    public void addVelocity(Velocity velocity, float delta)
    {
        x += velocity.getX() * delta;
        y += velocity.getY() * delta;

        verifyPosition();
    }

    private void verifyPosition()
    {
        if(x < 0)
            x = 0;
        if(x >= Map.WIDTH)
            x = Map.WIDTH - 1;

        if(y < 0)
            y = 0;
        if(y >= Map.HEIGHT)
            y = Map.HEIGHT - 1;
    }
}
