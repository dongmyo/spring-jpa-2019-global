package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO : #2 OrderItemRepository.
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItem.Pk> {
    // TODO : #3 query without entity graph.
    List<OrderItem> findByPk_OrderId(Long orderId);

    // TODO : #4 query with entity graph.
    @EntityGraph("orderItemWithItem")
    List<OrderItem> getByPk_OrderId(Long orderId);

    // TODO : #5 query with entity graph #2.
    @EntityGraph("orderItemWithItemAndOrder")
    List<OrderItem> readByPk_OrderId(Long orderId);

}
