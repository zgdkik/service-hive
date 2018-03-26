package com.service.hive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author kenly
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main(String[] args) {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
