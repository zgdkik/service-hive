package com.service.hive;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
public class ContractServiceApplication {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(ContractServiceApplication.class).web(true).run(args);
    }
}
