package com.ap.dota2.MainGame.map.entity.creature;

import com.ap.dota2.MainGame.standards.Direction;
import com.ap.dota2.MainGame.standards.Velocity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Hero extends Creature
{
    private Texture texture;
    private Direction direction;

    public Hero(int x, int y)
    {
        super(x, y);
        texture = new Texture("hero1.png");
        velocity.setX(800);
        velocity.setY(800);
        direction = Direction.NONE;
    }

    @Override
    public void draw(Batch batch)
    {
        batch.draw(texture, position.getX(), position.getY(), ((texture.getWidth() * 0.2f)), (texture.getHeight() * 0.2f));
    }

    @Override
    public void action(float delta)
    {
        move(delta);
    }

    @Override
    public void move(float delta)
    {
        switch (direction)
        {
            case UP:
                position.addVelocity(velocity.onlyY(), delta);
                break;
            case DOWN:
                position.addVelocity(velocity.onlyNegY(), delta);
                break;
            case LEFT:
                position.addVelocity(velocity.onlyNegX(), delta);
                break;
            case RIGHT:
                position.addVelocity(velocity.onlyX(), delta);
                break;
        }
    }

    @Override
    public void attack()
    {

    }

    @Override
    public boolean keyDown(int keycode)
    {
        System.out.println(keycode);
        switch (keycode)
        {
            case Input.Keys.UP: case Input.Keys.W:
                direction = Direction.UP;
                return true;
            case Input.Keys.DOWN: case Input.Keys.S:
                direction = Direction.DOWN;
                return true;
            case Input.Keys.LEFT: case Input.Keys.A:
                direction = Direction.LEFT;
                return true;
            case Input.Keys.RIGHT: case Input.Keys.D:
                direction = Direction.RIGHT;
                return true;

            default:
                direction = Direction.NONE;
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode)
    {
        direction = Direction.NONE;
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return true;
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

    @Override
    public void dispose()
    {

    }
}
