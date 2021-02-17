package com.example.query.mapper;

import com.example.common.model.ValidatedOrder;
import com.example.query.model.Item;
import com.example.query.model.OrderedItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QueryMapper {
    @Mapping(source = "itemLabel", target = "label")
    @Mapping(source = "itemPrice", target = "price")
    OrderedItem getOrderedItemMessage(ValidatedOrder source);

    List<Item> getItems(List<OrderedItem> source);
}
