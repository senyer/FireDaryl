package com.firemorey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Component
public class SwaggerConfig {
  public static final String VERSION = "1.0.0";
  public static final String SWAGGER_SCAN_WEB_PACKAGE = "com.firemorey.controller";

  @Bean
  public Docket webRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiWebInfo())
            .useDefaultResponseMessages(false)
            .enableUrlTemplating(false)
            .forCodeGeneration(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_WEB_PACKAGE))//多个controller就用通配符
            .paths(PathSelectors.any())
            .build();
  }

  private ApiInfo apiWebInfo() {
    return new ApiInfoBuilder()
            .title("China No.1")
            .description("后端接口文档")
            .version(VERSION)
            .build();
  }
}
