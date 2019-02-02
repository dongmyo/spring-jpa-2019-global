package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import com.nhnent.edu.spring_jpa.entity.Item;
import com.nhnent.edu.spring_jpa.entity.QItem;
import com.querydsl.core.types.Predicate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// TODO : #2 QuerydslPredicateExecutor 사용 예제.
@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class QuerydslPredicateExecutorTest {
    @Autowired
    private ItemRepository itemRepository;


    @Test
    public void test() throws Exception {
        QItem item = QItem.item;

        Predicate itemQuery = item.itemName.contains("l")
                                           .and(item.price.gt(200L))
                                           .and(item.itemId.lt(5L));

        Optional<Item> result = itemRepository.findOne(itemQuery);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isPresent());
        Assert.assertEquals("apple", result.get().getItemName());
    }
}
