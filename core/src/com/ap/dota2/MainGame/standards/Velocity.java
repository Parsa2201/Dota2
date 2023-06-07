package com.ap.dota2.MainGame.standards;

public class Velocity
{
    float x;
    float y;

    public Velocity(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVelocity(float speed, float angle)
    {
        this.x = (float) (speed * Math.cos(Math.toRadians(angle)));
        this.y = (float) (speed * Math.sin(Math.toRadians(angle)));
    }

    public Velocity onlyX()
    {
        return new Velocity(x, 0);
    }

    public Velocity onlyY()
    {
        return new Velocity(0, y);
    }

    public Velocity onlyNegX()
    {
        return new Velocity(-x, 0);
    }

    public Velocity onlyNegY()
    {
        return new Velocity(0, -y);
    }
}
