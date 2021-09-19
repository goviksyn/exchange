package com.grasshopper.exchange;

import com.grasshopper.exchange.publisher.ExchangeEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAutoConfiguration
@SpringBootApplication
@EnableAsync
public class ExchangeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

    @Autowired
    ExchangeEventPublisher publisher;

    @Override
    public void run(String... args) throws Exception {
        publisher.publishEvent();
    }
}
