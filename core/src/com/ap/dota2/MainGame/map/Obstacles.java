package com.ap.dota2.MainGame.map;

import com.ap.dota2.MainGame.standards.DotaDrawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Obstacles implements DotaDrawable, Disposable
{
    private final Array<Obstacle> obstacles;

    public Obstacles()
    {
        obstacles = new Array<Obstacle>();
    }


    @Override
    public void draw(Batch batch)
    {
        for(Obstacle obstacle : new Array.ArrayIterator<>(obstacles))
            obstacle.draw(batch);
    }

    @Override
    public void dispose()
    {
        for(Obstacle obstacle : new Array.ArrayIterator<>(obstacles))
            obstacle.dispose();
    }
}
