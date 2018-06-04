package com.service.hive;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.net.ssl.HttpsURLConnection;

/**
 * 使用Eureka做服务发现.
 *
 * @author kenly
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminServerApplication {

    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier(( hostname, sslSession ) -> true);

        SpringApplication.run(AdminServerApplication.class, args);
    }
}
