package com.nhnent.edu.spring_jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

// TODO : #6 unit test는 `@Category(IntegrationTest.class)`가 없음.
// TODO : #6 unit tests don't have `@Category(IntegrationTest.class)`.
@RunWith(JUnit4.class)
public class UnitTest {
    @Test
    public void test() throws Exception {
        System.out.println("unit test");
    }

}
