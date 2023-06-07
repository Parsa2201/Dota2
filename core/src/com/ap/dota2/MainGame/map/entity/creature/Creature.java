package com.ap.dota2.MainGame.map.entity.creature;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.Entity;
import com.ap.dota2.MainGame.standards.Damage;
import com.ap.dota2.MainGame.standards.Destination;
import com.ap.dota2.MainGame.standards.Velocity;

public abstract class Creature extends Entity
{
    protected final Velocity velocity;
    protected final Damage damage;
    protected int range;
    protected boolean visible;
    protected Destination destination;
    protected float speed;

    public Creature(Map map, float x, float y, float speed)
    {
        super(map, x, y);
        velocity = new Velocity(0, 0);
        damage = new Damage(0);
        this.speed = speed;
        destination = new Destination(position, speed);
    }

    public abstract void move(float delta);

    public abstract void attack();
}
