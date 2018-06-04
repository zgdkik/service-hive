package com.service.hive.http;

import com.service.hive.http.OkResponse.OkResponseBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OkResponseTests {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void okResponseBuilderTest() throws Exception {
        OkResponseBuilder builder = ResponseBuilder.ok(HttpStatus.OK);
        assertNotNull(builder);
        assertNull(builder.getResult());

        assertEquals(HttpStatus.OK, builder.getStatus());
    }

    @Test
    public void buildEntityTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.ok(HttpStatus.OK).result("result data")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
