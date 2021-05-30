package com.company.client;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        //client entering custom messages
        String userMsg ="";

        while(!userMsg.equals("exit")){
            Scanner msg = new Scanner(System.in);
            System.out.println("Enter message (type 'exit' to exit): ");

            userMsg = msg.nextLine();

            //encoding user message
            String encodedMsg = Base64.getEncoder().encodeToString(userMsg.getBytes());

            client.sendMessage(encodedMsg);
        }


        System.out.println("Client finished execution");

        //solid principles


    }
}
