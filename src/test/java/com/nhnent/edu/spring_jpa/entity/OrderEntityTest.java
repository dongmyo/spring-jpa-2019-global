package com.nhnent.edu.spring_jpa.entity;

import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class OrderEntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    // TODO : #2 `Order` Entity 클래스를 작성해서 아래 테스트를 통과하세요.
    @Test
    public void test() throws Exception {
        Order order1 = entityManager.find(Order.class, 1001L);
        Assert.assertNotNull(order1);

        Assert.assertEquals(1001L, ReflectionTestUtils.invokeGetterMethod(order1, "orderId"));
        Assert.assertNotNull(ReflectionTestUtils.invokeGetterMethod(order1, "orderDate"));
    }

}
