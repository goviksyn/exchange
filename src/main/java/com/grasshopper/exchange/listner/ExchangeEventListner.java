package com.grasshopper.exchange.listner;


import com.grasshopper.exchange.event.Event;
import com.grasshopper.exchange.event.EventParser;
import com.grasshopper.exchange.processor.EventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ExchangeEventListner {

    @Autowired
    EventParser eventParser;

    @Autowired
    EventProcessor  eventProcessor;

    @EventListener
    void eventHandler(String event) {
       eventProcessor.processEvent(eventParser.parse(event));
    }
}
