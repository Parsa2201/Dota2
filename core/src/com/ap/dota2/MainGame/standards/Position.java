package com.ap.dota2.MainGame.standards;

import com.ap.dota2.MainGame.map.Map;

public class Position
{
    private int x;
    private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;

        verifyPosition();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
        verifyPosition();
    }
    public void setY(int y)
    {
        this.y = y;
        verifyPosition();
    }

    public void addVelocity(Velocity velocity, float delta)
    {
        x += (int) (velocity.getX() * delta);
        y += (int) (velocity.getY() * delta);

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
