package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import com.nhnent.edu.spring_jpa.entity.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    // TODO : #3 OrderRepository 인터페이스를 작성해서 아래 테스트를 통과하세요.
    @Test
    public void test() throws Exception {
        Optional<Order> order = ReflectionTestUtils.invokeMethod(orderRepository, "findById", 1001L);
        Assert.assertNotNull(order);
        Assert.assertTrue(order.isPresent());
        Assert.assertEquals(1001L, order.get().getOrderId().longValue());
    }
}
