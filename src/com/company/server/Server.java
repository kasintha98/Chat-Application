package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException,InterruptedException {
        System.out.println("Server running");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created..");

        while(true){

            Socket client = serverSocket.accept();  //wait until com.company.client connects
            System.out.println("Server accepted a com.company.client.");

            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();


        }

        //accept user inputs using command line
        //use a gui for client and server
        //encrypt messages between client and the server
        //limit number of clients

        //commit code to git repo
        //loom screen record



    }
}
