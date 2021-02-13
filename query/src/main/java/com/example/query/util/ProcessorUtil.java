package com.example.query.util;

import com.example.command.model.ValidatedOrder;
import com.example.query.mapper.QueryMapper;
import com.example.query.model.OrderedItem;
import com.example.query.model.OrderedItemsList;
import org.apache.kafka.streams.KeyValue;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

public class ProcessorUtil {
    private ProcessorUtil() {
    }

    public static KeyValue<String, OrderedItem> getItem(String customerId, ValidatedOrder validatedOrder) {
        return new KeyValue<>(customerId,
                Mappers.getMapper(QueryMapper.class).getOrderedItemMessage(validatedOrder));
    }

    public static OrderedItemsList initializeItems() {
        return OrderedItemsList.newBuilder().setItems(new ArrayList<>()).build();
    }

    public static OrderedItemsList aggregateItems(String aggKey, OrderedItem newValue, OrderedItemsList aggValue) {
        int index = aggValue.getItems().indexOf(newValue);
        if (index >= 0) {
            int quantity = aggValue.getItems().get(index).getQuantity();
            aggValue.getItems().get(index).setQuantity(quantity + 1);
        } else {
            aggValue.getItems().add(newValue);
        }
        return aggValue;
    }
}
