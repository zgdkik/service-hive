package com.service.hive.hr.feign;

import com.service.hive.hr.entity.CheckResult;
import com.service.hive.hr.entity.ClientInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kenly
 */
@FeignClient(name = "demo-contract-service")
public interface FraudDetectionFeignClient {

    @RequestMapping("/check/fraudcheck")
    public CheckResult fraudcheck(@RequestBody ClientInfo client);

    /**
     *
     */
    @Component
    static class HystrixClientFallback implements FraudDetectionFeignClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         *
         */
        @Override
        public CheckResult fraudcheck(@RequestBody ClientInfo client) {
            HystrixClientFallback.LOGGER.info("fraudcheck fallback, id = {}", client.getClientId());

            CheckResult result=new CheckResult();
            result.setFraudCheckStatus("NA");
            result.setRejectionReason("NA");
            return result;
        }
    }
}
