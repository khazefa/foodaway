package com.digifreneur.foodaway.config;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.NamingConvention;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class FoodawayConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
        //https://github.com/modelmapper/modelmapper/issues/212
    }

    /**
     * Group Foodaway contains operations related to reservations and agency mangement
     */
    @Bean
    public Docket swaggerFoodawayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Foodaway")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.digifreneur.foodaway.controller.v1.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    /**
     * Group User contains operations related to user mangement such as login/logout
     */
    @Bean
    public Docket swaggerUserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("User")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.digifreneur.foodaway.config"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Foodaway - REST APIs")
                .description("API Documentations for Foodaway.").termsOfServiceUrl("")
                .contact(new Contact("Sigit Prayitno", "https://github.com/khazefa", "cybergitt@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }
}