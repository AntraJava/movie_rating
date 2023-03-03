package com.antra.movie_rating;

import com.antra.movie_rating.dao.MovieCharctDAO;
import com.antra.movie_rating.domain.MovieCharact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class MovieRatingApplication implements CommandLineRunner {

	@Autowired
	private MovieCharctDAO movieCharctDAO;
	public static void main(String[] args) {
		SpringApplication.run(MovieRatingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Initialize Rating characteristics
		//INSERT INTO movie_characteristics VALUES (2,'Cast'),(1,'Graphics'),(5,'Music'),(3,'Role'),(4,'Story');
		movieCharctDAO.save(new MovieCharact(1,"Graphics"));
		movieCharctDAO.save(new MovieCharact(2,"Cast"));
		movieCharctDAO.save(new MovieCharact(3,"Role"));
		movieCharctDAO.save(new MovieCharact(4,"Story"));
		movieCharctDAO.save(new MovieCharact(5,"Music"));
	}
}
