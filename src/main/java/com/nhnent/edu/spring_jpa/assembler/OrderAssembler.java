package com.nhnent.edu.spring_jpa.assembler;

import com.nhnent.edu.spring_jpa.dto.OrderDto;
import com.nhnent.edu.spring_jpa.dto.OrderItemDto;
import com.nhnent.edu.spring_jpa.entity.Order;
import com.nhnent.edu.spring_jpa.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderAssembler {
    public OrderDto toDto(Order order) {
        List<OrderItemDto> orderItemDtos = order.getOrderItems()
                                                .stream()
                                                .map(OrderAssembler::toOrderItemDto)
                                                .collect(Collectors.toList());

        return new OrderDto(order.getOrderId(), orderItemDtos);
    }

    private static OrderItemDto toOrderItemDto(OrderItem orderItem) {
        return new OrderItemDto(
                new ItemAssembler().toDto(orderItem.getItem()),
                orderItem.getQuantity()
        );
    }

}
