package com.service.hive;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author kenly
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ContractClientApplication {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(ContractClientApplication.class).web(true).run(args);
    }
}
