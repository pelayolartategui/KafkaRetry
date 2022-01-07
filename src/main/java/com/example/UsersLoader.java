package com.example;

import com.example.kafka.producers.UsersProducer;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Singleton
public class UsersLoader implements ApplicationEventListener<ServerStartupEvent> {

    private final UsersProducer usersProducer;

    public UsersLoader(UsersProducer usersProducer) {

        this.usersProducer = usersProducer;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {

        int i = 0;
        while (true) {
            usersProducer.sendUser(String.valueOf(i), "user-"+i);
            i++;
        }

    }

}
