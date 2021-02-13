package com.example.query.controller;

import com.example.common.model.Colour;
import com.example.query.mapper.ItemMapper;
import com.example.query.model.ItemList;
import com.example.query.model.ItemResponse;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryController {
    @Autowired
    private InteractiveQueryService queryService;

    @GetMapping(value = "/order/{customerId}/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemResponse>> getAddress(@PathVariable(value = "customerId") String customerId,
                                     @RequestParam(value = "colour") Colour colour) {
        // get the item store for the given colour
        String storeName = colour.label + "-item-store";
        ReadOnlyKeyValueStore<String, ItemList> itemStore = queryService.getQueryableStore(storeName,
                QueryableStoreTypes.keyValueStore());

        // get the items for the given customer
        ItemList itemList = itemStore.get(customerId);
        if (itemList != null) {
            List<ItemResponse> response = Mappers.getMapper(ItemMapper.class)
                    .StoreToResponse(itemList.getItems());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
