package com.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleStudy2ApplicationTests {

    @Test
    public void contextLoads() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                log.error("i={}", i);
            }
        }
    }

}
