package globallogic.ejercicio.config;

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

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api()  {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("globallogic.ejercicio.controller")).build().apiInfo(apiInfo()).pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Ejercicio GlobalLogic",
                "",
                "0.0.1",
                "Terms of service",
                new Contact("Alejandro Yañez", "", "alejandro.yanezj@utem.cl"),
                "License of API",
                "licenseUrl",
                Collections.emptyList());
    }

}