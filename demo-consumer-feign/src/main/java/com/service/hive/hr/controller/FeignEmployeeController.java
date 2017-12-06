package com.service.hive.hr.controller;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.feign.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignEmployeeController {

    @Autowired
    private EmployeeFeignClient feignClient;

    @GetMapping("feign/{id}")
    public Employee findByIdFeign(@PathVariable Long id) {
        Employee user = this.feignClient.findByIdFeign(id);
        return user;
    }
}
