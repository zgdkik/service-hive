package com.service.hive.hr.controller;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return this.ribbonHystrixService.findById(id);
    }
}
