package com.example.command.mapper;

import com.example.command.model.Order;
import com.example.command.model.ReceivedOrder;
import com.example.command.model.ValidatedOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandMapper {
    ReceivedOrder getReceivedOrderMessage(Order source);

    ValidatedOrder getValidatedOrderMessage(ReceivedOrder source);
}
