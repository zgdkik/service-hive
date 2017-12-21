package com.service.hive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.service.hive")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RESTful APIs")
                .description("com.service.hive RESTful APIs")
                .version("1.0").build();
    }


    /*
    @Bean
    public Docket swaggerApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(serviceHiveApiInfo())
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(PathSelectors.any())//过滤的接口
                .build();
    }

    private ApiInfo serviceHiveApiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Platform API")
                .description("Service Hive's REST API.")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
    */
}
