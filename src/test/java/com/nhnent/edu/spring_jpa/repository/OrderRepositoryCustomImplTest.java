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
        // TODO : #7 실습 - 6번 항목까지 모두 완료하였으면 아래 주석을 해제해서 본 테스트를 통과시키세요.
    	// TODO : #7 practice - if you've finished the previous todos, uncomment the following lines
    	//        and pass this test case. 
        /*
        List<Item> items1 = orderRepository.getItemsHavingOrderItemQuantityGreaterThan(4);
        Assert.assertEquals(1, items1.size());

        List<Item> items2 = orderRepository.getItemsHavingOrderItemQuantityGreaterThan(1);
        Assert.assertEquals(4, items2.size());
        */
    }
}
