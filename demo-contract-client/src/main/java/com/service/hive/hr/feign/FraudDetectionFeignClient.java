package com.service.hive.hr.feign;

import com.service.hive.hr.entity.CheckResult;
import com.service.hive.hr.entity.ClientInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kenly
 */
@FeignClient(name = "demo-contract-service")
public interface FraudDetectionFeignClient {

    @RequestMapping("/check/fraudcheck")
    public CheckResult fraudcheck(@RequestBody ClientInfo client);
}
