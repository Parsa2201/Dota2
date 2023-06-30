package com.ap.dota2.MainGame.map.entity.creature;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.Entity;
import com.ap.dota2.MainGame.standards.Damage;
import com.ap.dota2.MainGame.standards.Destination;
import com.ap.dota2.MainGame.standards.Velocity;
import com.badlogic.gdx.math.Vector2;

public abstract class Creature extends Entity
{
    protected final Damage damage;
    protected int range;
    protected boolean visible;
    protected Destination destination;
    protected float speed;

    public Creature(Map map, float x, float y, float speed)
    {
        super(map, x, y);
        damage = new Damage(0);
        this.speed = speed;
        destination = new Destination(position, speed);
    }

    public Creature(Map map, float x, float y, float speed, float destinationX, float destinationY)
    {
        super(map, x, y);
        damage = new Damage(0);
        this.speed = speed;
        destination = new Destination(position, speed);
        destination.setDestination(new Vector2(destinationX, destinationY));
    }

    public abstract void move(float delta);

    public abstract void attack();

    public Destination getDestination()
    {
        return destination;
    }

    public float getSpeed()
    {
        return speed;
    }
}
