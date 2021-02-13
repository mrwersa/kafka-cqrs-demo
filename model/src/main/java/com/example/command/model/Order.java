package com.example.command.model;

import lombok.Data;

@Data
public class Order {
    private String orderId;
    private String customerId;
    private String itemLabel;
    private double itemPrice;
}