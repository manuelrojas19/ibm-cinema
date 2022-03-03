package com.ibm.academy.cinema.apirest.filmservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SpringFoxSwagger {

    private static final String CONTROLLER_PACKAGE = "com.ibm.academy.cinema.apirest.filmservice.controller";

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Film-Service",
                "Api para recuperar films",
                "v1",
                "Términos del servicio",
                new Contact("Manuel Rojas", "www.ibm.com", "Manuel.Antonio.Ramos@ibm.com"),
                "Licencia de API", "API licencia URL", Collections.emptyList()
        );
    }
}