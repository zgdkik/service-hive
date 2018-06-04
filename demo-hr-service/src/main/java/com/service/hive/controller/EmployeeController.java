package com.service.hive.controller;

import com.service.hive.domain.Employee;
import com.service.hive.repository.EmployeeRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenly
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EmployeeRepository repository;

    @ApiOperation(value = "获取员工信息", notes = "根据员工ID获取员工信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "员工ID", required = true, dataType = "Long", paramType = "path")})
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        Employee findOne = this.repository.findOne(id);
        return findOne;
    }

    @ApiOperation(value = "回显所输入的信息")
    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }

    /**
     * 服务实例的信息
     *
     * @return
     */
    @ApiOperation(value = "获取当前微服务实例的信息")
    @GetMapping("/info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
