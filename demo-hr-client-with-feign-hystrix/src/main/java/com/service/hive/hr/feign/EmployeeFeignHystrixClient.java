package com.service.hive.hr.feign;

import com.service.hive.hr.entity.Employee;
import com.service.hive.hr.feign.EmployeeFeignHystrixClient.HystrixClientFallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kenly
 */
@FeignClient(name = "demo-hr-service", fallback = HystrixClientFallback.class)
public interface EmployeeFeignHystrixClient {

    @RequestMapping("/emp/{id}")
    public Employee findByIdFeign(@PathVariable("id") Long id);

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
