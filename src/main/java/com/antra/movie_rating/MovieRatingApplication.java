package com.antra.movie_rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableSwagger2
@EnableFeignClients
public class MovieRatingApplication {
//	http://localhost:8080/swagger-ui.html#/
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.antra.movie_rating"))
//				.paths(regex("/api.*"))
//				.paths(regex("/movie.*"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaInfo());

	}
	private ApiInfo metaInfo() {

		ApiInfo apiInfo=new ApiInfo("Movie Rating Api",
				"User Api methods", "0.1",
				"Terms of Service",
				new Contact("Antra Inc","http://www.antra.com","dawei.zhuang@antra.com"),
				"License for User Details ", "Url of user", Collections.EMPTY_LIST);

		return apiInfo;
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieRatingApplication.class, args);
	}

}
