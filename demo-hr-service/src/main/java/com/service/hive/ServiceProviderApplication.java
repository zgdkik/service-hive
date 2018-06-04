package com.service.hive;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderApplication {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(ServiceProviderApplication.class).web(true).run(args);
    }
}
