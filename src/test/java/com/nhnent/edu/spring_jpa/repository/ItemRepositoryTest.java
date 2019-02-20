package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.IntegrationTest;
import com.nhnent.edu.spring_jpa.annotation.Question;
import com.nhnent.edu.spring_jpa.config.DatabaseConfig;
import com.nhnent.edu.spring_jpa.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class })
@Transactional
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;


    @Test
    public void test() throws Exception {
        Class<?> clazz = Arrays.stream(itemRepository.getClass().getInterfaces())
                               .filter(iface -> iface.isAssignableFrom(ItemRepository.class))
                               .findFirst()
                               .orElse(null);

        Assert.assertNotNull(clazz);

        Method questionedMethod = Arrays.stream(clazz.getDeclaredMethods())
                                        .filter(method -> method.isAnnotationPresent(Question.class))
                                        .findFirst()
                                        .orElse(null);

        Assert.assertNotNull(questionedMethod);

        List<Item> items = ReflectionTestUtils.invokeMethod(itemRepository, questionedMethod.getName(),
                                                             Arrays.asList(100L, 200L));
        Assert.assertNotNull(items);
        Assert.assertEquals(3, items.size());
    }

}
