package com.Romil.Tiwari.UserManagementApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
//http://localhost:8088/swagger-ui.html#/
public class SwaggerConfig {

    @Bean
    public Docket config(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.Romil.Tiwari.UserManagementApp.Controller"))
                .build()
                .apiInfo(getApiInfo());
    }

    // To create a manual detials in swagger page
    private ApiInfo getApiInfo() {
        return new ApiInfo("User Management API By Romil Tiwari",
                "Documentation for User Managment App",
                "1.0",
                "terms",
                new Contact("Romil" , "romiltiw", "romijis"),
                "license",
                "LicenseUrl",
                new ArrayList<>());

    }
}
