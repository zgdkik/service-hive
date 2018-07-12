package com.service.hive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.service.hive:demo-contract-service:+:stubs:8080"}, workOffline=true)
public class ContractClientTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void testFraudcheck() throws Exception {

        String url = "http://localhost:8080/check/fraudcheck";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");

        HttpEntity<String> entity = new HttpEntity<>("{\"clientId\":\"1234567890\",\"loanAmount\":99999}", httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        String body = response.getBody().toString();

        assertTrue(body.equals("{\"fraudCheckStatus\":\"FRAUD\",\"rejectionReason\":\"Amount too high\"}"));
    }
}
