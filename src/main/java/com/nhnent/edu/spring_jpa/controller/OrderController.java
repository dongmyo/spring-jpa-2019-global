package com.nhnent.edu.spring_jpa.controller;

import com.nhnent.edu.spring_jpa.dto.OrderDto;
import com.nhnent.edu.spring_jpa.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    // TODO : #1 실습 - orderService를 의존성 주입하세요.
	// TODO : #1 practice - inject orderService.
    private final OrderService orderService;


    @GetMapping
    // TODO : #2 실습 - 아래 handler method의 parameter type을 선언하세요.
    // TODO : #2 practice - modify the parameter type of the handler method below.
    public List<OrderDto> getOrders(Object pageable) {
        return orderService.getOrders(pageable);
    }

}
