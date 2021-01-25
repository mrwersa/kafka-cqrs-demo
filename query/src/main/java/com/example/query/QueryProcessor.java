package com.example.query;

import com.example.command.model.OrderValidated;
import com.example.common.model.Colour;
import com.example.query.mapper.ItemMapper;
import com.example.query.model.Item;
import com.example.query.model.ItemList;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Predicate;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component
public class QueryProcessor {
    Predicate<String, Item> isRed = (k, v) -> v.getColour().equalsIgnoreCase(Colour.RED.label);
    Predicate<String, Item> isBlue = (k, v) -> v.getColour().equalsIgnoreCase(Colour.BLUE.label);
    Predicate<String, Item> isGreen = (k, v) -> v.getColour().equalsIgnoreCase(Colour.GREEN.label);

    @Bean
    public Function<KStream<String, OrderValidated>, KStream<String, Item>[]> itemProcessor() {
        return orders -> {
            // group the items by colour
            KStream<String, Item>[] itemsByColour = orders
                    .map((customerId, order) -> new KeyValue<>(customerId,
                            Mappers.getMapper(ItemMapper.class).orderToItem(order)))
                    .branch(isRed, isBlue, isGreen);

            // materialize the groups items into separate state store
            itemsByColour[0]
                    .groupByKey()
                    .aggregate(() -> ItemList.newBuilder().setItems(new ArrayList<>()).build(),
                            (aggKey, newValue, aggValue) -> {
                                aggValue.getItems().add(Mappers.getMapper(ItemMapper.class)
                                        .topicToStore(newValue));
                                return aggValue;
                            },
                            Materialized.as("red-item-store"));
            itemsByColour[1]
                    .groupByKey()
                    .aggregate(() -> ItemList.newBuilder().setItems(new ArrayList<>()).build(),
                            (aggKey, newValue, aggValue) -> {
                                aggValue.getItems().add(Mappers.getMapper(ItemMapper.class)
                                        .topicToStore(newValue));
                                return aggValue;
                            },
                            Materialized.as("blue-item-store"));
            itemsByColour[2]
                    .groupByKey()
                    .aggregate(() -> ItemList.newBuilder().setItems(new ArrayList<>()).build(),
                            (aggKey, newValue, aggValue) -> {
                                aggValue.getItems().add(Mappers.getMapper(ItemMapper.class)
                                        .topicToStore(newValue));
                                return aggValue;
                            },
                            Materialized.as("green-item-store"));

            return itemsByColour;
        };
    }
}
