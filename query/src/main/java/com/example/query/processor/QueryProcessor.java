package com.example.query.processor;

import com.example.command.model.ValidatedOrder;
import com.example.common.model.Price;
import com.example.query.model.OrderedItem;
import com.example.query.util.ProcessorUtil;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QueryProcessor {
    public static final String ITEM_STORE_SUFFIX = "-items-store";

    Predicate<String, OrderedItem> isItemCheap = (k, v) -> v.getPrice() < 5;
    Predicate<String, OrderedItem> isItemAffordable = (k, v) -> v.getPrice() >= 5 && v.getPrice() < 50;
    Predicate<String, OrderedItem> isItemExpensive = (k, v) -> v.getPrice() > 5;

    @Bean
    public Function<KStream<String, ValidatedOrder>, KStream<String, OrderedItem>[]> itemProcessor() {
        return validatedOrdersStream -> {
            // group the ordered items by price
            KStream<String, OrderedItem>[] orderedItemsByPriceStream = validatedOrdersStream
                    .map(ProcessorUtil::getItem)
                    .branch(isItemCheap, isItemAffordable, isItemExpensive);

            // materialize the groups items into separate state stores.
            // Cheap items:
            orderedItemsByPriceStream[0].groupByKey().aggregate(
                    ProcessorUtil::initializeItems,
                    ProcessorUtil::aggregateItems,
                    Materialized.as(Price.CHEAP.label + ITEM_STORE_SUFFIX));
            // Affordable items:
            orderedItemsByPriceStream[1].groupByKey().aggregate(
                    ProcessorUtil::initializeItems,
                    ProcessorUtil::aggregateItems,
                    Materialized.as(Price.AFFORDABLE.label + ITEM_STORE_SUFFIX));
            // Expensive items:
            orderedItemsByPriceStream[2].groupByKey().aggregate(
                    ProcessorUtil::initializeItems,
                    ProcessorUtil::aggregateItems,
                    Materialized.as(Price.EXPENSIVE.label + ITEM_STORE_SUFFIX));

            return orderedItemsByPriceStream;
        };
    }


}
