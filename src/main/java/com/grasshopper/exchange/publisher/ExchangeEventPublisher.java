package com.grasshopper.exchange.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

@Component
public class ExchangeEventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    //Publishing event as if coming as stream...
    public void publishEvent() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:l3_data_v3.csv");
        try (Stream<String> stream = Files.lines(file.toPath())) {
            stream.skip(1).forEach(publisher::publishEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
