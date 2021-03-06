package com.service.hive.hr.controller;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.feign.EmployeeFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class FeignHystrixController {

    @Autowired
    private EmployeeFeignHystrixClient feignHystrixClient;

    @GetMapping("/{id}")
    public Employee findByIdFeign(@PathVariable Long id) {
        Employee emp = this.feignHystrixClient.findByIdFeign(id);
        return emp;
    }
}
