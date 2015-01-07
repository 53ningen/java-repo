package com.ningen.gomi.powermock;

public class Static {
    public String sayHello() {
        return "hello, world!";
    } 
    
    public static Static getInstance() {
        return new Static();
    }
}
