package com.mrxu.personalzone.util;

import com.mrxu.personalzone.entity.User;

import java.io.UnsupportedEncodingException;

public class Character {
    public static String $(String oldStr){
        try {
            return new String(oldStr.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return oldStr;
    }
}
