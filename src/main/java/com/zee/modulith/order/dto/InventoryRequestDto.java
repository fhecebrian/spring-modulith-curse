package com.zee.modulith.order.dto;

public record InventoryRequestDto(
        String inventoryName,
        int qty
) { }