package com.nhnent.edu.spring_jpa.service;

import com.nhnent.edu.spring_jpa.dto.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders(Pageable pageable);

}
