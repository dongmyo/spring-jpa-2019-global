package com.nhnent.edu.spring_jpa.dto;

public class OrderItemDto {
    private final ItemDto item;
    private final Integer quantity;


    public OrderItemDto(ItemDto item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }


    public ItemDto getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
