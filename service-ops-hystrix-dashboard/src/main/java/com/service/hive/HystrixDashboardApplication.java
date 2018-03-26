package com.service.hive;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author kenly
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}
