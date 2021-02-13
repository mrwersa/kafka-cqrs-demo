package com.example.command.processor;

import com.example.command.mapper.CommandMapper;
import com.example.command.model.ReceivedOrder;
import com.example.command.model.ValidatedOrder;
import org.apache.kafka.streams.kstream.KStream;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Function;

@Component
public class CommandProcessor {
    @Bean
    public Function<KStream<String, ReceivedOrder>, KStream<String, ValidatedOrder>> orderProcessor() {
        return receivedOrdersStream -> receivedOrdersStream
                .mapValues(orderReceivedMessage -> {
                    ValidatedOrder validatedOrderMessage = Mappers.getMapper(CommandMapper.class)
                            .getValidatedOrderMessage(orderReceivedMessage);
                    // do the required validations
                    validatedOrderMessage.setTsValidated(Instant.now().toEpochMilli());
                    return validatedOrderMessage;
                });
    }
}
