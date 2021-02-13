package com.example.command.processor;

import com.example.command.mapper.OrderMapper;
import com.example.command.model.OrderReceived;
import com.example.command.model.OrderValidated;
import org.apache.kafka.streams.kstream.KStream;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Function;

@Component
public class CommandProcessor {

    @Bean
    public Function<KStream<String, OrderReceived>, KStream<String, OrderValidated>> orderProcessor() {
        return orderReceivedStream -> orderReceivedStream
                .mapValues(orderReceived -> {
                    OrderValidated orderValidated = Mappers.getMapper(OrderMapper.class)
                            .receivedToValidated(orderReceived);
                    orderValidated.setTsValidated(Instant.now().toEpochMilli());
                    return orderValidated;
                });
    }
}
