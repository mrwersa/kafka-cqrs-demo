package com.example.command.controller;

import com.example.command.mapper.OrderMapper;
import com.example.command.model.OrderReceived;
import com.example.command.model.OrderRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.function.Supplier;


@RestController
public class CommandController {
    private final EmitterProcessor<Message<OrderReceived>> messageEmitterProcessor = EmitterProcessor.create();

    @PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody OrderRequest orderRequest) {
        OrderReceived orderReceived = Mappers.getMapper(OrderMapper.class).requestToReceived(orderRequest);
        orderReceived.setTsReceived(Instant.now().toEpochMilli());

        messageEmitterProcessor.onNext(MessageBuilder.withPayload(orderReceived)
                .setHeader(KafkaHeaders.MESSAGE_KEY, orderReceived.getCustomerId()).build());

        return ResponseEntity.ok().build();
    }

    @Bean
    public Supplier<Flux<Message<OrderReceived>>> orderSupplier() {
        return () -> messageEmitterProcessor;
    }
}
