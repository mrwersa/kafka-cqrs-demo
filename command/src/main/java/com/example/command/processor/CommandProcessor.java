package com.example.command.processor;

import com.example.command.model.ReceivedOrder;
import com.example.command.model.ValidatedOrder;
import com.example.command.util.ProcessorUtil;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CommandProcessor {
    @Bean
    public Function<KStream<String, ReceivedOrder>, KStream<String, ValidatedOrder>> orderProcessor() {
        return receivedOrdersStream -> receivedOrdersStream
                .mapValues(ProcessorUtil::validateOrder);
    }
}
