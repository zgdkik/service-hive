package com.service.hive.http;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseBuilderTest {
    @Test
    public void badTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.bad().code("DEV.PM.01").messge("msg")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

    @Test
    public void badCustomTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.bad(HttpStatus.BAD_REQUEST).code("DEV.PM.01").messge("msg")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

    @Test
    public void okTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.ok().result("result data")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void okCustomTest() throws Exception {
        ResponseEntity<Object> entity = ResponseBuilder.ok(HttpStatus.CONTINUE).result("result data")
                .buildEntity();
        assertNotNull(entity);

        assertNotNull(entity.getBody());
        assertEquals(true, entity.hasBody());

        assertEquals(HttpStatus.CONTINUE, entity.getStatusCode());
    }

}