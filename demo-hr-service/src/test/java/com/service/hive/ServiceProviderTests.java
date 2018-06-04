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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiceProviderApplication.class)
@WebAppConfiguration
public class ServiceProviderTests {

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
                .param("p1", "1").param("p2", "2")
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
    public void findByIdTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emp/1").contentType(MediaType.ALL)
                .accept(MediaType.ALL);

        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
