package com.example.kafka.consumers;

import com.example.exceptions.MyCustomException;
import io.micronaut.configuration.kafka.annotation.ErrorStrategy;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import static io.micronaut.configuration.kafka.annotation.ErrorStrategyValue.RETRY_ON_ERROR;
import static io.micronaut.configuration.kafka.annotation.OffsetReset.EARLIEST;
import static io.micronaut.configuration.kafka.annotation.OffsetStrategy.SYNC_PER_RECORD;


@Slf4j
@KafkaListener(offsetReset = EARLIEST, offsetStrategy = SYNC_PER_RECORD,
    errorStrategy = @ErrorStrategy(value = RETRY_ON_ERROR, retryCount = 3))
public class UsersListener {

    @Topic("users")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {

        log.info("Consumed record with key: {} and value {}", consumerRecord.key(), consumerRecord.value());

        throw new MyCustomException("Something bad occurs");

    }

}
