package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Item;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/*
 * custom repository interface
 */
@NoRepositoryBean
public interface OrderRepositoryCustom {
    List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity);

}
