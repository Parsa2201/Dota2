package com.ap.dota2.net;

import com.ap.dota2.Dota2Game;
import com.ap.dota2.MainGame.MainGame;
import com.ap.dota2.MainGame.map.Map;
import com.ap.dota2.MainGame.map.entity.Entity;
import com.ap.dota2.MainGame.map.entity.creature.hero.Hero;
import com.ap.dota2.MainGame.map.entity.creature.hero.HeroType;
import com.ap.dota2.MainGame.standards.Destination;
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
    private int playerCount = 0;
    private Dota2Game game;
    private MainGame mainGame;
    private Map map;
    private boolean gameHasStarted = false;

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
                .on(SocketEvents.NEW_PLAYER, this::handleNewPlayer)
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

    public void setGame(Dota2Game game)
    {
        this.game = game;
    }

    public void setMainGame(MainGame mainGame)
    {
        this.mainGame = mainGame;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    private void handleMySocketId(Object... objects)
    {
        var data = (JSONObject) objects[0];
        try
        {
            String id = data.getString("id");
            this.id = id;
            playerCount++;
            Gdx.app.log(TAG, "My player ID: " + id);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void handleNewPlayer(Object... objects)
    {
        var data = (JSONObject) objects[0];
        try
        {
            String id = data.getString("id");
            playerCount++;
            Gdx.app.log(TAG, "New player ID: " + id);
            if(playerCount >= 2)
                startGame();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void handleNewHero(Object... objects)
    {
        var data = (JSONObject) objects[0];
        try
        {
            String id = data.getString("id");
            float x = (float) data.getDouble("x");
            float y = (float) data.getDouble("y");
            float destinationX = (float) data.getDouble("destinationX");
            float destinationY = (float) data.getDouble("destinationY");
            float speed = (float) data.getDouble("speed");
            HeroType heroType = HeroType.values()[data.getInt("heroType")];


            while (map == null)
                Thread.sleep(50);

            Hero hero = new Hero(map, x, y, destinationX, destinationY, speed, heroType, id);

            map.entities.addHero(hero);
            Gdx.app.log(TAG, "New hero added Type: " + heroType);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void handlePlayerDisconnected(Object... objects)
    {
        if(mainGame != null)
        {
            game.goToMainMenu();
            mainGame = null;
        }

        playerCount--;
    }

    private void handleStartGame(Object... objects)
    {
        game.startGame();
        gameHasStarted = true;
    }

    private void handleHeroDestinationChanged(Object... objects)
    {
        var data = (JSONObject) objects[0];
        try
        {
            String id = data.getString("id");
            float destinationX = (float) data.getDouble("destinationX");
            float destinationY = (float) data.getDouble("destinationY");

            for(Entity entity : map.entities)
            {
                if(entity instanceof Hero hero && hero.getId().equals(id))
                    hero.setDestination(destinationX, destinationY);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void handleHeroSpeedChanged(Object... objects)
    {
        // TODO
    }

    public void startGame()
    {
        socket.emit(SocketEvents.START_GAME);
        game.startGame();
        gameHasStarted = true;
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

    public void setDestination(Destination destination)
    {
        try
        {
            var data = new JSONObject();
            data.put("destinationX", destination.getX());
            data.put("destinationY", destination.getY());
            socket.emit(SocketEvents.HERO_DESTINATION_CHANGED, data);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public String getId()
    {
        return id;
    }

    @Override
    public void dispose()
    {

    }
}
