package io.monster.ocs.cm.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("io.monster.ocs.cm.customer")).build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("AWS Spring Elastic Search Data Sample",
                "Customer Search Application for Seeker Matching",
                "V1", "https://github.com/Monster-OCS/ocs-customer-search",
                new Contact("WIOINS Team Github", "https://github.com/Monster-OCS/ocs-customer-search", ""),
                "", "",
                Collections.emptyList());
    }
}
