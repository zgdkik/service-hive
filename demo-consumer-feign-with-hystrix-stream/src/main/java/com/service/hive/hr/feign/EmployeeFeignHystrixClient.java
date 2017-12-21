package com.service.hive.hr.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.feign.EmployeeFeignHystrixClient.HystrixClientFallback;

/**
 *
 * @author kenly
 */
@FeignClient(name = "demo-service-provider", fallback = HystrixClientFallback.class)
public interface EmployeeFeignHystrixClient {

    @RequestMapping("/emp/id}")
    public Employee findByIdFeign(@RequestParam("id") Long id);

    /**
     *
     */
    @Component
    static class HystrixClientFallback implements EmployeeFeignHystrixClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         *
         */
        @Override
        public Employee findByIdFeign(Long id) {
            HystrixClientFallback.LOGGER.info("findByIdFeign fallback, id = {}", id);
            Employee emp = new Employee();
            emp.setId(-1L);
            emp.setName("default name");
            emp.setAge(0);
            return emp;
        }
    }
}
