package com.nhnent.edu.spring_jpa.service;

import com.nhnent.edu.spring_jpa.assembler.OrderAssembler;
import com.nhnent.edu.spring_jpa.dto.OrderDto;
import com.nhnent.edu.spring_jpa.entity.Order;
import com.nhnent.edu.spring_jpa.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderDto> getOrders(Pageable pageable) {
        // TODO : #3 orderRepository를 이용해서 pagination 기능을 구현하세요.
        Page<Order> orderPage = orderRepository.findAll(pageable);

        return orderPage.getContent()
                        .stream()
                        .map(order -> new OrderAssembler().toDto(order))
                        .collect(Collectors.toList());
    }

}
