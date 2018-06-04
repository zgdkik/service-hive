package com.service.hive.http;

import com.service.hive.http.BadResponse.BadResponseBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class BadResponseTests {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void badResponseBuilderTest() throws Exception {
        BadResponseBuilder builder = ResponseBuilder.bad(HttpStatus.BAD_REQUEST);
        assertNotNull(builder);
        assertNull(builder.getCode());
        assertNull(builder.getMessge());

        assertEquals(HttpStatus.BAD_REQUEST, builder.getStatus());
    }

    @Test
    public void buildEntityTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.bad(HttpStatus.BAD_REQUEST).code("DEV.PM.01").messge("msg")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

}
