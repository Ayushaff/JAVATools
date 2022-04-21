package com.oyos.Keyboard.util;
import java.io.*;

public class Keyboard {
    private BufferedReader bufferReader;

    public Keyboard() {
        bufferReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getString() {
        String str;
        try {
            str = bufferReader.readLine();
        } catch (IOException ioException) {
            str = "";
        }
        return str;
    }

    public String getString(String message) {
        System.out.println(message);
        return getString();
    }
    public char getChar(){
        return getString().charAt(0);
    }
    public char getChar(String message){
        System.out.println(message);
        return getChar();
    }
}