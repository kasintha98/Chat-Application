package com.company.server;

import com.company.client.MsgDecoder;

import java.io.*;
import java.net.Socket;
import java.util.Base64;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000); //wait for 3 seconds before executing rest of the code

            //receive data from com.company.client
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outputStream = new DataOutputStream( client.getOutputStream());

            //MsgDecoder class new object
            MsgDecoder msgDecoder = new MsgDecoder();


            //continuous reading data from com.company.client
            String inputdata;

            while((inputdata = msgDecoder.decodeMsg(bufferedReader.readLine())) != null){
                System.out.println("Client says :" +  inputdata);
                /*outputStream.writeBytes("Hello from com.company.server!\n");*/

                //also can use scanner class
                switch ( inputdata){
                    case "Hello from client!":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("Fine...How are you?\n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Good...\n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("Welcome\n");
                        break;
                    default:
                        outputStream.writeBytes("Cant understand\n");
                }

                if(inputdata.equals("exit")){
                    break;
                }
            }

            //send some data to com.company.client

        /*DataOutputStream outputStream = new DataOutputStream( com.company.client.getOutputStream());
        outputStream.writeBytes("Hello from com.company.server!\n");*/

            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
    //two ways to create a thread in java
    //1. Extend the class using Thread Super class.
    //2. Implement the class using runnable interface
}
