package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OrderRepository extends OrderRepositoryCustom, Repository<Order, Long> {
    Optional<Order> findById(Long orderId);

    Page<Order> findAll(Pageable pageable);

}
