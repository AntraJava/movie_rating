package com.antra.movie_rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class MovieRatingApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieRatingApplication.class, args);
	}

}
