package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();


        String userMsg ="";

        while(!userMsg.equals("exit")){
            Scanner msg = new Scanner(System.in);
            System.out.println("Enter message (type 'exitx): ");

            userMsg = msg.nextLine();

            client.sendMessage(userMsg);
            /*client.sendMessage("How are you?");
            client.sendMessage("I'm fine");
            client.sendMessage("Thank you");
            client.sendMessage("Ohh");
            client.sendMessage("exit");*/
        }


        System.out.println("Client finished execution");

        //solid principles


    }
}
