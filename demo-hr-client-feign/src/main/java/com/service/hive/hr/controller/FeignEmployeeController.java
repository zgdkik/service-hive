package com.service.hive.hr.controller;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.feign.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class FeignEmployeeController {

    @Autowired
    private EmployeeFeignClient feignClient;

    @GetMapping("/{id}")
    public Employee findByIdFeign(@PathVariable Long id) {
        Employee user = this.feignClient.findByIdFeign(id);
        return user;
    }

    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }
}
