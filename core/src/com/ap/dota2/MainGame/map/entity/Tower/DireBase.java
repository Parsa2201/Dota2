package com.ap.dota2.MainGame.map.entity.Tower;

import com.ap.dota2.MainGame.map.Map;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class DireBase extends BaseTower
{
    @Override
    public void draw(Batch batch)
    {
        batch.draw(building, position.x, position.y);//TODO : this need to decoration
    }
    public DireBase (Map map, int x, int y, float hp)
    {
        super(map, x, y, hp, new Texture("DireTower.png"));
    }
}
