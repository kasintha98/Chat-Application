package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient2 {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();
//client entering custom messages
        String userMsg ="";

        while(!userMsg.equals("exit")){
            Scanner msg = new Scanner(System.in);
            System.out.println("Enter message (type 'exit' to exit): ");

            userMsg = msg.nextLine();

            client.sendMessage(userMsg);

        }

        System.out.println("Client finished execution");

        //solid priciples


    }
}
