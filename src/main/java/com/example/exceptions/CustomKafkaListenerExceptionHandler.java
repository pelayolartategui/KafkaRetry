package com.example.exceptions;

import io.micronaut.configuration.kafka.exceptions.DefaultKafkaListenerExceptionHandler;
import io.micronaut.configuration.kafka.exceptions.KafkaListenerException;
import io.micronaut.configuration.kafka.exceptions.KafkaListenerExceptionHandler;
import io.micronaut.context.annotation.Replaces;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Singleton
@Replaces(DefaultKafkaListenerExceptionHandler.class)
public class CustomKafkaListenerExceptionHandler implements KafkaListenerExceptionHandler {

    @Override
    public void handle(KafkaListenerException exception) {

        log.error("Custom Exception handling for error on message: {} with value {}",
            exception.getConsumerRecord().get().key(),
        exception.getConsumerRecord().get().value());

    }

}
