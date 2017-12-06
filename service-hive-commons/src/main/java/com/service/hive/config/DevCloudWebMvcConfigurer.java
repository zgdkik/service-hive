package com.service.hive.config;

import com.service.hive.handler.TokenHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * DevCloud应用基类。自动拦截HTTP请求，日志记录请求URI信息，检查请求头是否带有效的令牌，往响应头添加事务流水号。
 *
 * @author kenly
 */
@Configuration
@EnableConfigurationProperties(DevCloudInterceptorSetting.class)
public class DevCloudWebMvcConfigurer extends WebMvcConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger(DevCloudWebMvcConfigurer.class);

    /**
     * 实例化令牌处理拦截器。
     *
     * @return
     */
    @Bean
    public TokenHandlerInterceptor tokenHandlerInterceptor() {
        return new TokenHandlerInterceptor();
    }

    @Autowired
    private TokenHandlerInterceptor tokenInterceptor;

    @Autowired
    DevCloudInterceptorSetting devcloudProperties;

    /**
     * 添加需要拦截的URI路径。例如：/PBI/**
     *
     * @param pathPatterns
     * @return
     */
    // public abstract void addInterceptorPathPatterns(final List<String>
    // pathPatterns);

    /**
     * 添加令牌处理拦截器，检查请求头是否带有效的令牌。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(tokenInterceptor);

        String pathPatterns = devcloudProperties.getPathPatterns();
        log.info("Interceptor path patterns: " + pathPatterns);

        if (pathPatterns == null || pathPatterns.isEmpty()) {
            return;
        }

        String[] paths = pathPatterns.split(",");
        if (paths == null || paths.length == 0) {
            return;
        }

        for (String path : paths) {
            interceptor.addPathPatterns(path);
        }
    }


}
