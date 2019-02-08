package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import com.nhnent.edu.spring_jpa.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class OrderRepositoryCustomImplTest {
    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void test() throws Exception {
        List<Item> items1 = orderRepository.getItemsHavingOrderItemQuantityGreaterThan(4);
        Assert.assertEquals(1, items1.size());

        List<Item> items2 = orderRepository.getItemsHavingOrderItemQuantityGreaterThan(1);
        Assert.assertEquals(4, items2.size());
    }
}