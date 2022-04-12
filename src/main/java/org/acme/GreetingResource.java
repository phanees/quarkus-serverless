package org.acme;

import io.quarkus.funqy.Funq;

public class GreetingResource {
    
    @Funq
    public String hello() {
        return "Hello RESTEasy";
    }
}