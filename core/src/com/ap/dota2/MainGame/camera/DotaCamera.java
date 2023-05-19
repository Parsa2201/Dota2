package com.ap.dota2.MainGame.camera;

import com.ap.dota2.MainGame.standards.HasAction;
import com.ap.dota2.MainGame.standards.Resizable;
import com.ap.dota2.MainGame.standards.Velocity;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;

public class DotaCamera implements InputProcessor, Resizable, HasAction
{
    private final Batch batch;
    private final OrthographicCamera camera;
    private Direction direction;
    private Velocity velocity;

    public DotaCamera(Batch batch, int width, int height)
    {
        this.batch = batch;
        camera = new OrthographicCamera(width, height);

        // set the SpiritBatch's projection matrix to the camera's combined matrix
        batch.setProjectionMatrix(camera.combined);

        velocity = new Velocity(500, 500);
    }

    @Override
    public void resize(int width, int height)
    {
        camera.setToOrtho(false, width, height);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
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
        //camera.position.set(screenX, screenY, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);


        if (screenX < 10)
            direction = Direction.LEFT;
        else if (screenX > camera.viewportWidth - 10)
            direction = Direction.RIGHT;
        else if (screenY < 10)
            direction = Direction.DOWN;
        else if (screenY > camera.viewportHeight - 10)
            direction = Direction.UP;
        else
            direction = Direction.NONE;

        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return false;
    }

    @Override
    public void action(float delta)
    {
        if(direction == Direction.NONE)
            return;

        if(direction == Direction.LEFT)
            camera.position.x -= velocity.getX() * delta;
        else if(direction == Direction.RIGHT)
            camera.position.x += velocity.getX() * delta;
        else if(direction == Direction.DOWN)
            camera.position.y += velocity.getY() * delta;
        else if(direction == Direction.UP)
            camera.position.y -= velocity.getY() * delta;

        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }
}
