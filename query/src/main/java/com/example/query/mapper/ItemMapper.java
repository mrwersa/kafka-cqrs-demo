package com.example.query.mapper;

import com.example.command.model.OrderValidated;
import com.example.query.model.Item;
import com.example.query.model.ItemListRecord;
import com.example.query.model.ItemResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item orderToItem(OrderValidated source);

    List<ItemResponse> StoreToResponse(List<ItemListRecord> source);

    ItemListRecord topicToStore(Item source);
}
