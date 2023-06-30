package com.ap.dota2.MainGame.map.entity.Tower;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.standards.HP;
import com.badlogic.gdx.graphics.Texture;

public abstract class BaseTower extends Tower
{
    Texture building;
    HP hp;
    public BaseTower(Map map, int x, int y, float hp, Texture texture)
    {
        super(map, x ,y);
        this.hp = new HP(hp);
        this.building = texture;
    }

}
