package com.ap.dota2.MainGame.standards;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Destination
{
    final Vector2 currentPosition;
    Vector2 destination;
    float speed;
    boolean reached = true;

    public Destination(Vector2 currentPosition, float speed)
    {
        this.currentPosition = currentPosition;
        this.destination = currentPosition;
        this.speed = speed;
    }

    public void setDestination(Vector2 destination)
    {
        this.destination = destination;
        reached = false;
    }

    public void setDestination(Vector3 destination)
    {
        this.destination.x = destination.x;
        this.
        reached = false;
    }

    public Vector2 getDestination()
    {
        return destination;
    }

    public float getX()
    {
        return destination.x;
    }

    public float getY()
    {
        return destination.y;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public float distance()
    {
        Vector2 currentPosition = new Vector2(this.currentPosition.x, this.currentPosition.y);
        Vector2 destination = new Vector2(this.destination.x, this.destination.y);

        return currentPosition.dst(destination);
    }

    public static float distance(float x1, float y1, float x2, float y2)
    {
        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public float angleRad()
    {
        Vector2 currentPosition = new Vector2(this.currentPosition.x, this.currentPosition.y);
        Vector2 destination = new Vector2(this.destination.x, this.destination.y);

        return MathUtils.atan2(destination.y - currentPosition.y, destination.x - currentPosition.x);

        //return currentPosition.sub(destination).angleRad();
    }

    public void move(float delta)
    {
        if(reached)
            return;

        float distance = distance();
        float angle = angleRad();


        float deltaX = (speed * MathUtils.cos(angle)) * delta;
        float deltaY = (speed * MathUtils.sin(angle)) * delta;

        if(distance() < distance(currentPosition.x + deltaX, currentPosition.y + deltaY, destination.x, destination.y))
        {
            reached = true;
            return;
        }

        currentPosition.x += deltaX;
        currentPosition.y += deltaY;

    }
}
