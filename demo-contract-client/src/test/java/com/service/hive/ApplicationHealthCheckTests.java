package com.service.hive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ContractClientApplication.class)
@WebAppConfiguration
public class ApplicationHealthCheckTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void checkApplicationInfoTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/info").contentType(MediaType.ALL)
                .accept(MediaType.ALL);

        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void checkMetricsTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/metrics").contentType(MediaType.ALL)
                .accept(MediaType.ALL);

        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFraudcheckAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/emp/1234567890")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Hello World\"}"))
                .andExpect(status().isOk());
    }

}
