package com.service.hive.hr.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.hive.hr.entity.Employee;

/**
 *
 * @author kenly
 */
@FeignClient(name = "demo-service-provider")
public interface EmployeeFeignClient {

    @RequestMapping("/{id}")
    public Employee findByIdFeign(@RequestParam("id") Long id);
}
