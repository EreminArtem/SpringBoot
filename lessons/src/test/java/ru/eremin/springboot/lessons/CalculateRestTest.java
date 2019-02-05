package ru.eremin.springboot.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @autor Eremin Artem on 04.02.2019.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculateRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
        final ResponseEntity<Double> responseEntity = restTemplate.getForEntity("/sum/a=5&b=6", Double.class);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
        final double sum = responseEntity.getBody();
        assertEquals(sum, 11.0);
    }
}
