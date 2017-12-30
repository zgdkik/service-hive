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

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @HystrixCommand(fallbackMethod = "fallback")
    public Employee findById(Long id) {
        return this.restTemplate.getForObject("http://demo-hr-service/emp/" + id, Employee.class);
    }

    public Employee fallback(Long id) {
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        Employee emp = new Employee();
        emp.setId(-1L);
        emp.setName("default name");
        emp.setAge(0);
        return emp;
    }
}
