package com.example.query.model;

import com.example.common.model.Colour;
import lombok.Data;

@Data
public class ItemResponse {
    private String item;
    private Colour colour;
    private double price;
}
