package com.company;

import com.sun.security.ntlm.Server;

import  java.net.*;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServer implements Runnable{

    private ArrayList<ConnectionHandler> connections;
    private ArrayList<HashMap<String,String>> posts;
    private ArrayList<HashMap<String,String>> postsSearched;
    private ArrayList<String> postsFound;
    private ServerSocket serverSocket;
    private Socket client;
    private boolean active;
    private ExecutorService pool;
    private final HashMap<String,String> postFile;

    public NetworkServer(){
        connections = new ArrayList<>();
        posts = new ArrayList<>();
        postsSearched = new ArrayList<>();
        postsFound = new ArrayList<>();
        active = true;
        postFile = loadPOSTS();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(20111);
            pool = Executors.newCachedThreadPool();
            // While the server is active then listen for when a
            // Client connects to the server on the server socket
            while (active){
                client = serverSocket.accept();
                // Create a new connection with the client
                ConnectionHandler handler = new ConnectionHandler(client);
                // Add the new client to the connections list
                connections.add(handler);
                pool.execute(handler);
            }


        }catch (IOException e){
            shutdown();
        }


    }

    // Send a message to all clients connected to the server
    public void broadcast(String message){
        for (ConnectionHandler ch: connections){
            if (ch != null){
                ch.sendMessage(message);
            }
        }
    }

    // Stop the connection between the server and all
    // Clients and deactivate the server
    public void shutdown(){
        try {
            active = false;
            pool.shutdown();
            if (!serverSocket.isClosed()){
                serverSocket.close();
            }
            for (ConnectionHandler ch: connections){
                ch.shutdown();
            }
        }catch(IOException e){

        }

    }

    // Handles the servers connection to all the clients using it
    class ConnectionHandler implements Runnable{

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;
        private String serverName;

        public  ConnectionHandler(Socket client){
            this.client = client;
            this.serverName = "NetworkServer";
        }
        @Override
        public void run() {

            try {
                out = new PrintWriter(client.getOutputStream(),true);
                // Get the data from the clients input stream
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                // Ask the client to identify themselves, read their input and broadcast
                // That they have connected to the server
                broadcast("HELLO? DISTTER/1.0 Server");
                String message;
                String lastMessage = "";
                String since = "";
                String header = "";
                while ((message = in.readLine()) != null){

                    if (message.equals("WHEN?")){
                        long time = java.time.Instant.now().getEpochSecond();

                        broadcast("NOW "+ time);
                    }else if (message.startsWith("POST? ")){
                        String[] splitMessage = message.split(" ");
                        since = splitMessage[1];
                        header = splitMessage[2];
                        out.println("SEARCH BY TOPIC: ");
                    }
                    else if (message.startsWith("FETCH? ")){
                        String[] splitMessage = message.split(" ");
                        String hash = splitMessage[1]+" "+splitMessage[2];
                        fetchPOST(hash);
                    }else if (message.startsWith("GOODBYE? ")){
                        broadcast(message);
                        shutdown();

                    }
                    else {
                        if (!lastMessage.startsWith("POST? ")){
                            broadcast("GOODBYE? INVALID REQUEST");
                            shutdown();
                        }else {
                            searchByCreated(since,message);
                        }

                    }
                    lastMessage = message;
                }
            }catch (IOException e){
                shutdown();
            }
        }
        public void searchByCreated(String since,String topic){
            for (HashMap<String,String> hm :posts){
                if (hm != null){
                    if (Integer.parseInt(hm.get("Created")) >= Integer.parseInt(since)){
                        postsSearched.add(hm);
                    }
                }
            }
            int postNum =0;
            int found = 0;

            for (HashMap<String,String> ps: postsSearched){
                if (ps != null){
                    String[] topics = topic.split(" ");
                    broadcast("length = "+topics.length);
                    for (int i=0; i<topics.length; i++){
                        if (ps.containsKey(topics[i])){
                            found ++;
                        }
                        if (found == topics.length){
                            postsFound.add(ps.get("Post-id"));
                            postNum++;
                        }
                    }


                }
                found = 0;
            }
            broadcast("OPTIONS "+postNum);
            for (String fp: postsFound){
                broadcast(fp);
            }
            postNum = 0;
            postsFound.clear();
            postsSearched.clear();
        }

        public void sendMessage(String message){
            out.println(message);
        }

        public void shutdown(){
            try {

                in.close();
                out.close();
                if (!client.isClosed()){
                    client.close();
                }
            } catch (IOException e){

            }
        }
    }

    private HashMap<String, String> loadPOSTS() {

        File dir = new File("res");
        File[] files = dir.listFiles();

        for (File file : files){
            HashMap<String, String> postMap = new HashMap<>();
            try {
                final File postFile = new File(file.toString());

                Scanner reader = new Scanner(postFile);

                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    if (data.contains(":")){
                        String[] split = data.split(": ");
                        postMap.put(split[0], split[1]);
                    }
                    if (data.contains("#")){
                        postMap.put(data, data);
                    }
                }

                // make sure all the POSTs headers are given in the .txt file
                if(!(postMap.containsKey("Post-id")) || !(postMap.containsKey("Created") || !postMap.containsKey("Author") || !postMap.containsKey("Contents"))){
                    System.err.println("File error - Make sure POST-ID, CREATED, AUTHOR AND CONTENTS values are provided. See README for details.");
                    System.exit(1);
                }

                posts.add(postMap);

            } catch (FileNotFoundException e){
                System.err.println(".env file needs to be provided");
                System.exit(1);
            }
        }


        return null;
    }

    private void fetchPOST(String hash) {
        File dir = new File("res");
        File[] files = dir.listFiles();
        boolean found = false;
        boolean searchComplete = false;

        for (File file : files){
            HashMap<String, String> postMap = new HashMap<>();
            try {
                final File postFile = new File(file.toString());

                Scanner reader = new Scanner(postFile);

                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    if (data.contains(":")){
                        String[] split = data.split(": ");
                        postMap.put(split[0], split[1]);
                    }
                    if (postMap.get("Post-id").equals(hash) && found==false){
                        broadcast("FOUND");
                        found = true;
                    }
                    if (found){
                        broadcast(data);
                        searchComplete = true;
                    }

                }
                found = false;

            } catch (FileNotFoundException e){
                broadcast("SORRY");
            }
        }
        if (searchComplete == false){
            broadcast("SORRY");
        }
    }

    // Create and run a new network server
    public static void main(String[] args) {
        NetworkServer networkServer = new NetworkServer();
        networkServer.run();
    }


}
