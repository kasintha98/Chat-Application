package com.company.client;

import java.io.*;

public class ChatClient2 {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        client.sendMessage("Hello from com.company.client!");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank you");
        client.sendMessage("Ohh");
        client.sendMessage("exit");

        System.out.println("Client finished execution");

        //solid priciples


    }
}
