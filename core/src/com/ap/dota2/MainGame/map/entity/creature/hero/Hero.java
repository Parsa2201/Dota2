package com.ap.dota2.MainGame.map.entity.creature.hero;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.creature.Creature;
import com.ap.dota2.net.SocketClientHandler;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Hero extends Creature
{
    private Texture texture = null;
    protected HeroType heroType = HeroType.FLAME;
    protected String id;


    public Hero(Map map,  float x, float y)
    {
        super(map, x, y, 800f);
        texture = new Texture("Hero1.gif");
    }

    public Hero(Map map, float x, float y, float destinationX, float destinationY, float speed, HeroType heroType, String id)
    {
        super(map, x, y, speed, destinationX, destinationY);
        this.heroType = heroType;
        this.id = id;
    }

    private void setTexture()
    {
        texture = switch (heroType)
        {
            case FLAME -> new Texture("Hero1.gif");
        };
    }

    public Vector2 getPosition() { return position; }

    @Override
    public void draw(Batch batch)
    {
        if(texture == null)
            setTexture();
        batch.draw(texture, position.x, position.y, ((texture.getWidth() * 0.4f)), (texture.getHeight() * 0.4f));
    }

    @Override
    public void action(float delta)
    {
        move(delta);
    }

    @Override
    public void move(float delta)
    {
        destination.move(delta);
    }

    @Override
    public void attack()
    {

    }

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public synchronized boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if (button == Buttons.RIGHT)
        {
            destination.setDestination(map.camera.camera.unproject(new Vector3(screenX, screenY, 0f)));
            SocketClientHandler.getInstance().setDestination(destination);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return false;
    }

    public HeroType getHeroType()
    {
        return heroType;
    }

    @Override
    public void dispose()
    {

    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setDestination(float destinationX, float destinationY)
    {
        destination.setDestination(new Vector2(destinationX, destinationY));
    }
}
