package com.service.hive.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * servicehive.interceptor.path-patterns
 *
 * @author kenly
 */
@ConfigurationProperties(prefix = "servicehive.interceptor")
public class DevCloudInterceptorSetting {

    private String pathPatterns;

    public String getPathPatterns() {
        return pathPatterns;
    }

    public void setPathPatterns(String pathPatterns) {
        this.pathPatterns = pathPatterns;
    }
}
