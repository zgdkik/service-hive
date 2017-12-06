package com.service.hive.hr.controller;

import com.service.hive.hr.feign.EmployeeFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.hive.hr.entity.Employee;

@RestController
public class FeignHystrixController {
    @Autowired
    private EmployeeFeignHystrixClient feignHystrixClient;

    @GetMapping("feign/{id}")
    public Employee findByIdFeign(@PathVariable Long id) {
        Employee emp = this.feignHystrixClient.findByIdFeign(id);
        return emp;
    }
}
