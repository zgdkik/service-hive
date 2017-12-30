package com.service.hive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 *
 * @author kenly
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class HRClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HRClientApplication.class).web(true).run(args);
    }
}
