package com.service.hive.hr.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.hive.hr.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Employee findById(Long id) {
        return this.restTemplate.getForObject("https://demo-hr-service/emp/" + id, Employee.class);
    }

    public Employee fallback(Long id,Throwable e) {
        LOGGER.warn("Call findById(Long id) raised fallback.");
        e.printStackTrace();

        Employee emp = new Employee();
        emp.setId(-1L);
        emp.setName("default name");
        emp.setAge(0);
        return emp;
    }
}
