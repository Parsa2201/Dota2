package com.ap.dota2.MainGame.server;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server implements Runnable
{
    private final int port = 5432;

    public Server()
    {
    }

    public String getServerIP() throws UnknownHostException
    {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getHostAddress();
    }

    @Override
    public void run()
    {
        ServerSocketHints hints = new ServerSocketHints();
        ServerSocket server = Gdx.net.newServerSocket(Net.Protocol.TCP, port, hints);
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        while(true)
        {
            Net.HttpRequest request = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://localhost" + 5432).build();
            Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener()
            {
                @Override
                public void handleHttpResponse(Net.HttpResponse httpResponse)
                {
                    System.out.println(httpResponse.getResultAsString());

                }

                @Override
                public void failed(Throwable t)
                {
                    System.err.println("Failed");
                }

                @Override
                public void cancelled()
                {
                    System.err.println("Cancelled");
                }
            });
        }
    }

}