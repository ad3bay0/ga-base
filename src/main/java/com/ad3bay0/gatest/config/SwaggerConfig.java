package com.ad3bay0.gatest.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.ad3bay0.gatest.controllers"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo(){

        return new ApiInfo(
            "API ENDPOINTS", 
            "GAtest api endpoints",
             "v1", 
             "", 
             new Contact("ad3bay0", "https://github.com/ad3bay0", "adebeslick@gmail.com"), 
             "license", 
             "License url", 
             Collections.emptyList());
    }
    
}