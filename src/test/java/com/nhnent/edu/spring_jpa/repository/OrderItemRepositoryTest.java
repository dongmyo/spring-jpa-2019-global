package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class OrderItemRepositoryTest {
    @Autowired
    private OrderItemRepository orderItemRepository;


    // TODO : #6 run this test case.
    @Test
    public void testWithoutEntityGraph() throws Exception {
        orderItemRepository.findByPk_OrderId(1001L);
    }

    // TODO : #7 run this test case.
    @Test
    public void testWithEntityGraphNamedOrderItemWithItem() throws Exception {
        orderItemRepository.getByPk_OrderId(1001L);
    }

    // TODO : #8 run this test case.
    @Test
    public void testWithEntityGraphNamedOrderItemWithItemAndOrder() throws Exception {
        orderItemRepository.readByPk_OrderId(1001L);
    }

}
