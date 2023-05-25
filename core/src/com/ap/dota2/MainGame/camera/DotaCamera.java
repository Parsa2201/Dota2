package com.ap.dota2.MainGame.camera;

import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.standards.Direction;
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

        direction = Direction.NONE;
        velocity = new Velocity(2500, 2500);
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
		switch (character) {
			case '-':
				scrolled(-1, -1);
				return true;
			case '+':
				scrolled(1, 1);
				return true;
		}
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
        if(amountY > 0 && camera.zoom > -1.5f)
            camera.zoom -= amountY * 0.1f;
        else if(amountY < 0 && camera.zoom < 2.5f)
            camera.zoom -= amountY * 0.1f;
        if(camera.zoom < -1.5f)
            camera.zoom = -1.5f;
        else if(camera.zoom > 2.5f)
            camera.zoom = 2.5f;

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        return true;
    }

    @Override
    public void action(float delta)
    {

        switch (direction)
        {
            case LEFT:
                camera.position.x -= velocity.getX() * delta;
                verifyPosition();
                break;
            case RIGHT:
                camera.position.x += velocity.getX() * delta;
                verifyPosition();
                break;
            case DOWN:
                camera.position.y += velocity.getY() * delta;
                verifyPosition();
                break;
            case UP:
                camera.position.y -= velocity.getY() * delta;
                verifyPosition();
                break;
            default:
                break;
        }

        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    private void verifyPosition()
    {
        // has some bugs

        if(camera.position.x < camera.viewportWidth / 2)
            camera.position.x = camera.viewportWidth / 2;
        else if(camera.position.x > Map.WIDTH - camera.viewportWidth / 2)
            camera.position.x = Map.WIDTH - camera.viewportWidth / 2;

        if(camera.position.y < camera.viewportHeight / 2)
            camera.position.y = camera.viewportHeight / 2;
        else if(camera.position.y > Map.HEIGHT - camera.viewportHeight / 2)
            camera.position.y = Map.HEIGHT - camera.viewportHeight / 2;
    }
}
