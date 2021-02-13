package com.example.command.controller;

import com.example.command.mapper.CommandMapper;
import com.example.command.model.Order;
import com.example.command.model.ReceivedOrder;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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
import java.util.UUID;
import java.util.function.Supplier;

@RestController
public class CommandController {
    private final EmitterProcessor<Message<ReceivedOrder>> messageEmitterProcessor = EmitterProcessor.create();

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createUser(@RequestBody Order order) {
        String orderId = order.getOrderId() == null ? UUID.randomUUID().toString() : order.getOrderId();
        order.setOrderId(orderId);

        // initiate asynchronous processing of the order
        ReceivedOrder receivedOrderMessage = Mappers.getMapper(CommandMapper.class).getReceivedOrderMessage(order);
        receivedOrderMessage.setOrderId(orderId);
        receivedOrderMessage.setTsReceived(Instant.now().toEpochMilli());
        messageEmitterProcessor.onNext(MessageBuilder.withPayload(receivedOrderMessage)
                .setHeader(KafkaHeaders.MESSAGE_KEY, receivedOrderMessage.getCustomerId()).build());

        // send back a response confirming the recipient of the order
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
    }

    @Bean
    public Supplier<Flux<Message<ReceivedOrder>>> orderSupplier() {
        return () -> messageEmitterProcessor;
    }
}
