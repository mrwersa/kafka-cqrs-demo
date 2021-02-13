package com.example.query.controller;

import com.example.common.model.Price;
import com.example.query.mapper.QueryMapper;
import com.example.query.model.Item;
import com.example.query.model.OrderedItemsList;
import com.example.query.processor.QueryProcessor;

import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryController {
    @Autowired
    private InteractiveQueryService queryService;

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getItemsByCustomerIdAndPrice(
            @RequestParam(value = "customerId") String customerId, @RequestParam(value = "price") Price price) {
        // get the item store for the given colour
        String storeName = price.label + QueryProcessor.ITEM_STORE_SUFFIX;
        ReadOnlyKeyValueStore<String, OrderedItemsList> orderedItemsStore = queryService.getQueryableStore(storeName,
                QueryableStoreTypes.keyValueStore());

        // get the items for the given customer
        OrderedItemsList orderedItems = orderedItemsStore.get(customerId);
        if (orderedItems != null) {
            List<Item> response = Mappers.getMapper(QueryMapper.class).getItems(orderedItems.getItems());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
