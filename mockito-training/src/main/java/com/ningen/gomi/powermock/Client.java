package com.ningen.gomi.powermock;

public class Client {
    
    static final Static STATIC = Static.getInstance();
    
    String getMessage() {
        return STATIC.sayHello();
    }
    
}
