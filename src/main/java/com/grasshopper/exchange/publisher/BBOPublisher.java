package com.grasshopper.exchange.publisher;

import org.springframework.stereotype.Component;

@Component
public class BBOPublisher {

    public void publish(String event){
        System.out.println(event);
    }
}
