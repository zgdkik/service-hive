package com.service.hive.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.feign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class FeignClientSSLConfig {

    @Bean
    @ConditionalOnMissingBean
    public feign.Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
                                    SpringClientFactory clientFactory) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("SSL");
        X509TrustManager tm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        ctx.init(null, new TrustManager[]{tm}, null);
        return new LoadBalancerFeignClient(new feign.Client.Default(ctx.getSocketFactory(),
                new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession sslSession) {
                        return true;
                    }
                }),
                cachingFactory, clientFactory);
    }

}
