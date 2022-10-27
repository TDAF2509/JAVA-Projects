package com.company;

import java.math.BigInteger;
import  java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NetworkClient implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean active = true;
    private String host;
    private int port;

    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // Connect to the  server
            client = new Socket(host,port);
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();

            String inMessage;
            while ((inMessage = in.readLine()) != null){
                System.out.println(inMessage);
            }
        }catch (Exception e){
            shutdown();
        }
    }

    // Close the connection between the client and the server
    public void shutdown(){
        active = false;
        try {
            in.close();
            out.close();
            if (!client.isClosed()){
                client.close();
            }
        }catch (Exception e){
            System.out.println("The server is not running, please run the server first");
        }
    }

    // Handles the clients inputs while connected to the server
    class InputHandler implements Runnable{
        @Override
        public void run() {
            try {
                // Reads the clients inputs and makes decisions based on them
                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
                while (active){
                   // out.println("HELLO? DISTTER/1.0 CLIENT");
                    String message = inReader.readLine();
                    if (message.startsWith("GOODBYE? ")){
                        out.println(message);
                        inReader.close();
                        shutdown();
                    }else {
                        out.println(message);
                    }
                }
            }catch (IOException e){

            }
        }
    }

    // Create a new client to connect to the server
    public static void main(String[] args) {
        NetworkClient client = new NetworkClient("127.0.0.1",20111);
        client.run();
    }
}
