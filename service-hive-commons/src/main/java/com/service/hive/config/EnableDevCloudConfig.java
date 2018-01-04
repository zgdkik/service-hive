package com.service.hive.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DevCloudConfiguration.class, DevCloudWebMvcConfigurer.class})
@Documented
public @interface EnableDevCloudConfig {

}
