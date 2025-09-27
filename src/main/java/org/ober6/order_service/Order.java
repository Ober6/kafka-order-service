package org.ober6.order_service;

public record Order (
    String orderId,
    String product,
    Integer quantity
)
{}
