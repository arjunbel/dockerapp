package spboot.web.jpa.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.DocumentType;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootWebDataJpAdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDataJpAdemoApplication.class, args);
	}
@Bean
public Docket generateApi()
{
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("spboot.web.jpa.demo")).build();
}
}
