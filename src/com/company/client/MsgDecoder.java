package com.company.client;

import java.util.Base64;

public class MsgDecoder {

    public String decodeMsg (String encodedMsg){
        //decoding client entered msg
        byte[] decodedBytes = Base64.getDecoder().decode(encodedMsg);
        String decodedMsg = new String(decodedBytes);
        return  decodedMsg;
    }
}
