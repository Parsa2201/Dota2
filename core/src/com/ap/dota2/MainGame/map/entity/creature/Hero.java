package com.ap.dota2.MainGame.map.entity.creature;

import com.ap.dota2.MainGame.standards.Direction;
import com.ap.dota2.MainGame.standards.Position;
import com.ap.dota2.MainGame.standards.Velocity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Hero extends Creature
{
    private Texture texture;
    private Direction direction;
    private Movement movement;

    public Hero(int x, int y)
    {
        super(x, y);
        texture = new Texture("hero1.png");
        velocity.setX(800);
        velocity.setY(800);
        direction = Direction.NONE;
        movement = new Movement(this);
        movement.start();
    }

    public Position getPosition() { return position; }

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

    /*
    final float eps = 0.1f;
    public void move(float dx, float dy) {
        if (dx >= 0f) {
            if (dy >= 0f) {
                while (dx >= eps && dy >= eps) {
                    dx -= eps; dy -= eps;
                    direction = Direction.DOWN;
                    move(eps);
                    direction = Direction.RIGHT;
                    move(eps);
                }
                while (dx >= eps) {
                    dx -= eps;
                    direction = Direction.DOWN;
                    move(eps);
                }
                while (dy >= eps) {
                    dy -= eps;
                    direction = Direction.RIGHT;
                    move(eps);
                }
                direction = Direction.DOWN;
                if (dx < 0f) dx *= -1f;
                move(dx);
                direction = Direction.RIGHT;
                if (dy < 0f) dy *= -1f;
                move(dy);
                direction = Direction.NONE;
            } else {
                while (dx >= eps && dy <= eps) {
                    dx -= eps; dy += eps;
                    direction = Direction.DOWN;
                    move(eps);
                    direction = Direction.LEFT;
                    move(eps);
                }
                while (dx >= eps) {
                    dx -= eps;
                    direction = Direction.DOWN;
                    move(eps);
                }
                while (dy <= eps) {
                    dy += eps;
                    direction = Direction.LEFT;
                    move(eps);
                }
                direction = Direction.DOWN;
                if (dx < 0f) dx *= -1f;
                move(dx);
                direction = Direction.LEFT;
                if (dy < 0f) dy *= -1f;
                move(dy);
                direction = Direction.NONE;
            }
        } else {
            if (dy >= 0f) {
                while (dx <= eps && dy >= eps) {
                    dx += eps; dy -= eps;
                    direction = Direction.UP;
                    move(eps);
                    direction = Direction.RIGHT;
                    move(eps);
                }
                while (dx <= eps) {
                    dx += eps;
                    direction = Direction.UP;
                    move(eps);
                }
                while (dy >= eps) {
                    dy -= eps;
                    direction = Direction.RIGHT;
                    move(eps);
                }
                direction = Direction.UP;
                if (dx < 0f) dx *= -1f;
                move(dx);
                direction = Direction.RIGHT;
                if (dy < 0f) dy *= -1f;
                move(dy);
                direction = Direction.NONE;
            } else {
                while (dx <= eps && dy <= eps) {
                    dx += eps; dy += eps;
                    direction = Direction.UP;
                    move(eps);
                    direction = Direction.LEFT;
                    move(eps);
                }
                while (dx <= eps) {
                    dx += eps;
                    direction = Direction.DOWN;
                    move(eps);
                }
                while (dy <= eps) {
                    dy += eps;
                    direction = Direction.LEFT;
                    move(eps);
                }
                direction = Direction.UP;
                if (dx < 0f) dx *= -1f;
                move(dx);
                direction = Direction.LEFT;
                if (dy < 0f) dy *= -1f;
                move(dy);
                direction = Direction.NONE;
            }
        }
    }
    */

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
    public synchronized boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if (button == Buttons.LEFT) {
            // move((float)(screenX - position.getX()), (float)(screenY - position.getY()));
            // int dx = (screenX - position.getX()), dy = -(screenY - position.getY());
            // while (dx != 0 && dy != 0) {
            //     keyDown(InputKeys(Xdir(dx))); dx = moveToZero(dx);
            //     keyDown(InputKeys(Ydir(dy))); dy = moveToZero(dy);
            // }
            // while (dx != 0) {
            //     keyDown(InputKeys(Xdir(dx))); dx = moveToZero(dx);
            // }
            // while (dy != 0) {
            //     keyDown(InputKeys(Ydir(dy))); dy = moveToZero(dy);
            // }

            // while (screenX != position.getX() && screenY != position.getY()) {
            //     keyDown(InputKeys(Xdir(dx)));
            //     keyDown(InputKeys(Ydir(dy)));
            // }
            // while (screenX != position.getX()) {
            //     keyDown(InputKeys(Xdir(dx)));
            // }
            // while (screenY != position.getY()) {
            //     keyDown(InputKeys(Ydir(dy)));
            // }
            // try {
            //     if (movement.isAlive()) movement.stop();
            // } catch (Exception e) {}
            movement.Xtarget = screenX; movement.Ytarget = screenY;
            // movement.start();

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

    @Override
    public void dispose()
    {

    }
}
