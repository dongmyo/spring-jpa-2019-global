package com.nhnent.edu.spring_jpa.entity;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// TODO : #4 integation test는 IntegrationTest marker를 @Category에 적용.
// TODO : #4 apply @Category with IntegrationTest marker interface for integration test usage.
@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class ItemEntityTest {
    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void test() throws Exception {
        Item item1 = entityManager.find(Item.class, 1L);
        Assert.assertNotNull(item1);
        Assert.assertEquals(1L, item1.getItemId().longValue());
    }
}
