package com.ap.dota2.MainGame.map.entity.creature.hero;

public enum HeroType
{
    FLAME(0)
    ;

    private final int value;

    HeroType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
