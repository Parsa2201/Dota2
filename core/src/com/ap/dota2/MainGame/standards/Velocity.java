package com.ap.dota2.MainGame.standards;

public class Velocity
{
    private int x;
    private int y;

    public Velocity(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setVelocity(int speed, int angle)
    {
        this.x = (int) (speed * Math.cos(Math.toRadians(angle)));
        this.y = (int) (speed * Math.sin(Math.toRadians(angle)));
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
