package com.service.hive.controller;

import com.service.hive.domain.Employee;
import com.service.hive.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kenly
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EmployeeRepository repository;

    /**
     *
     */
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        Employee findOne = this.repository.findOne(id);
        return findOne;
    }

    /**
     * 服务实例的信息
     *
     * @return
     */
    @GetMapping("/info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
