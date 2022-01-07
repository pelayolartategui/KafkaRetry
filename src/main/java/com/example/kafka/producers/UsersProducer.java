package com.example.kafka.producers;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;


@KafkaClient
public interface UsersProducer {

    @Topic("users")
    void sendUser(@KafkaKey String uuid, String model);

}
