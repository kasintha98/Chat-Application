package com.company.client;

import java.io.*;
import java.net.Socket;

public class Client {

    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    public void  start() throws IOException {
        System.out.println("Client running");
        Socket socket = new Socket("localhost", 6000);

        this.outputStream = new DataOutputStream((socket.getOutputStream()));

        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    //MsgDecoder class new object
    MsgDecoder msgDecoder = new MsgDecoder();

    public void sendMessage(String message) throws  IOException{
        System.out.println("Client says: "+  msgDecoder.decodeMsg(message));
        this.outputStream.writeBytes(message+ "\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("Server says: "+dataFromServer);
    }
}
