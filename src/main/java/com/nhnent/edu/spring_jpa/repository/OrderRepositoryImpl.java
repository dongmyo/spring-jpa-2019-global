package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Item;
import com.nhnent.edu.spring_jpa.entity.Order;
import com.nhnent.edu.spring_jpa.entity.QItem;
import com.nhnent.edu.spring_jpa.entity.QOrder;
import com.nhnent.edu.spring_jpa.entity.QOrderItem;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

/*
 * custom repository를 구현하세요.
 */
public class OrderRepositoryImpl extends QuerydslRepositorySupport
        implements OrderRepositoryCustom {
    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity) {
        QOrder order = QOrder.order;
        QOrderItem orderItem = QOrderItem.orderItem;
        QItem item = QItem.item;

        return from(order)
                .innerJoin(order.orderItems, orderItem)
                .innerJoin(orderItem.item, item)
                .where(orderItem.quantity.gt(quantity))
                .select(item)
                .distinct()
                .fetch();
    }

}
