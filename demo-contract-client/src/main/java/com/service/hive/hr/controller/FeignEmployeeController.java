package com.service.hive.hr.controller;

import com.service.hive.hr.entity.CheckResult;
import com.service.hive.hr.entity.ClientInfo;
import com.service.hive.hr.feign.FraudDetectionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class FeignEmployeeController {

    @Autowired
    private FraudDetectionFeignClient feignClient;

    @GetMapping("/{id}")
    public CheckResult fraudcheck(@PathVariable String id) {
        ClientInfo client=new ClientInfo();
        client.clientId(id).loanAmount(99999);

        CheckResult result = this.feignClient.fraudcheck(client);
        return result;
    }

    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }
}
