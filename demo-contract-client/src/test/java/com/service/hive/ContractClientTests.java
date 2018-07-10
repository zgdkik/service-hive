package com.service.hive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.service.hive:demo-contract-service:+:stubs:8080"}, workOffline = true)
public class ContractClientTests {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConsumer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/consumers/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Hello World\"}"))
                .andExpect(status().isOk());
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
