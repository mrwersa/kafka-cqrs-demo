package com.example.command.util;

import com.example.command.mapper.CommandMapper;
import com.example.command.model.ReceivedOrder;
import com.example.common.model.ValidatedOrder;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

public class ProcessorUtil {
    private ProcessorUtil() {
    }

    public static ValidatedOrder validateOrder(ReceivedOrder orderReceivedMessage) {
        ValidatedOrder validatedOrderMessage = Mappers.getMapper(CommandMapper.class)
                .getValidatedOrderMessage(orderReceivedMessage);
        // do the required validations
        validatedOrderMessage.setTsValidated(Instant.now().toEpochMilli());
        return validatedOrderMessage;
    }
}
