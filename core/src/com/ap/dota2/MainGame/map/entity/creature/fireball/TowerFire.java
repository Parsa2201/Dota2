package com.ap.dota2.MainGame.map.entity.creature.fireball;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.standards.Damage;
import com.ap.dota2.MainGame.standards.Position;
import com.ap.dota2.MainGame.standards.Velocity;

public class TowerFire extends FireBall
{
    public TowerFire(Map map, Position startPosition, Position targetPosition, Velocity velocity, Damage damage)
    {
        super(map, startPosition, targetPosition, velocity, damage);
    }

    @Override
    public void dispose()
    {

    }
}
