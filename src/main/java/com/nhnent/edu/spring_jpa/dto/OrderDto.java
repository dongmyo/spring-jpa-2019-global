package com.nhnent.edu.spring_jpa.dto;

import java.util.List;

public class OrderDto {
    private final Long id;

    private final List<OrderItemDto> items;


    public OrderDto(Long id, List<OrderItemDto> items) {
        this.id = id;
        this.items = items;
    }


    public Long getId() {
        return id;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

}
