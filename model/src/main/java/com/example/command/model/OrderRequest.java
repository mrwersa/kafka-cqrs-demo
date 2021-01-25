package com.example.command.model;

import com.example.common.model.Colour;
import lombok.Data;

@Data
public class OrderRequest {
    private String customerId;
    private String item;
    private Colour colour;
    private double price;
}
