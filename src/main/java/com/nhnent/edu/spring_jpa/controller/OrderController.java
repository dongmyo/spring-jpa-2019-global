package com.nhnent.edu.spring_jpa.controller;

import com.nhnent.edu.spring_jpa.dto.OrderDto;
import com.nhnent.edu.spring_jpa.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    // TODO : #1 orderService를 의존성 주입하세요.
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    // TODO : #2 아래 handler method의 parameter type을 선언하세요.
    public List<OrderDto> getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }

}
