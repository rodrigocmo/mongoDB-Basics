package com.example.mongoandkafkabasics.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecoderService {

    public static String decoder(String text){
        try {
            return URLDecoder.decode(text,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
