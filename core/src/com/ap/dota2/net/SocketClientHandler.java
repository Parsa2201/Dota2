package com.ap.dota2.net;

import com.ap.dota2.MainGame.map.entity.creature.hero.Hero;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class SocketClientHandler implements Disposable
{
    private static final String TAG = "NET.SOCKET-IO";
    private static String SERVER_URL = "http://localhost:8080";

    private static SocketClientHandler socketClientHandler;

    private Socket socket;
    private String id = null;

    private SocketClientHandler()
    {
        connectAndConfigure();
    }

    private void connectAndConfigure()
    {
        try
        {
            socket = IO.socket(SERVER_URL).connect();
            configureSocket();
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
    }

    private void configureSocket()
    {
        if(socket == null)
        {
            Gdx.app.error(TAG, "Not connected yet to the socket");
            return;
        }

        socket.on(Socket.EVENT_CONNECT, args -> Gdx.app.log(TAG, "Connection made with the server, waiting for the first event"))
                .on(SocketEvents.MY_SOCKET_ID, this::handleMySocketId)
                .on(SocketEvents.NEW_HERO, this::handleNewHero)
                .on(SocketEvents.PLAYER_DISCONNECTED, this::handlePlayerDisconnected)
                .on(SocketEvents.START_GAME, this::handleStartGame)
                .on(SocketEvents.HERO_DESTINATION_CHANGED, this::handleHeroDestinationChanged)
                .on(SocketEvents.HERO_SPEED_CHANGED, this::handleHeroSpeedChanged);
    }

    public static SocketClientHandler getInstance()
    {
        if(socketClientHandler == null)
            socketClientHandler = new SocketClientHandler();
        return socketClientHandler;
    }

    public void setIp(String ip)
    {
        SERVER_URL = "http://" + ip + ":8080";
    }

    private void handleMySocketId(Object... objects)
    {
        var data = (JSONObject) objects[0];
        try
        {
            String id = data.getString("id");
            this.id = id;
            Gdx.app.log(TAG, "My player ID: " + id);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void handleNewHero(Object... objects)
    {
        // TODO
    }

    private void handlePlayerDisconnected(Object... objects)
    {
        // TODO
    }

    private void handleStartGame(Object... objects)
    {
        // TODO
    }

    private void handleHeroDestinationChanged(Object... objects)
    {
        // TODO
    }

    private void handleHeroSpeedChanged(Object... objects)
    {
        // TODO
    }

    public void startGame()
    {
        socket.emit(SocketEvents.START_GAME);
    }

    public void newHero(Hero hero)
    {
        try
        {
            JSONObject data = new JSONObject();
            data.put("x", hero.getPosition().x);
            data.put("y", hero.getPosition().y);
            data.put("destinationX", hero.getDestination().getX());
            data.put("destinationY", hero.getDestination().getY());
            data.put("speed", hero.getSpeed());
            data.put("heroType", hero.getHeroType().getValue());
            socket.emit(SocketEvents.NEW_HERO, data);
        }
        catch (JSONException e)
        {
            Gdx.app.error(TAG, "Error sending player destination");
        }
    }

    @Override
    public void dispose()
    {

    }
}
