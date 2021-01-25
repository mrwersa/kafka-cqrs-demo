package com.example.command.mapper;

import com.example.command.model.OrderReceived;
import com.example.command.model.OrderRequest;
import com.example.command.model.OrderValidated;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderReceived requestToReceived(OrderRequest source);

    OrderValidated receivedToValidated(OrderReceived source);
}
