package com.antra.movie_rating;

import com.antra.movie_rating.dao.MovieAverageScoreRepository;
import com.antra.movie_rating.dao.UserRepository;
import com.antra.movie_rating.dao.UserRoleRepository;
import com.antra.movie_rating.domain.MovieAverageScore;
import com.antra.movie_rating.service.MovieService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MovieRatingApplicationTests {

	@Autowired
	UserRoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	MovieService movieService;

	@Autowired
	MovieAverageScoreRepository avgScoreDAO;

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("1234"));
	}

	@Disabled("Needs seeded data (database/MovieRating.sql)")
	@Test
	@Transactional
	public void testRoleDAO() {
		System.out.println(roleRepository.findAll().size());
	}

	@Disabled("Needs seeded data (database/MovieRating.sql)")
	@Test
	@Transactional
	public void testUserDAO() {
		System.out.println(userRepository.findByUsernameOrEmail("","123@gmail.com").get());
	}

	@Disabled("Needs seeded data (database/MovieRating.sql)")
	@Test
	public void testGetMovieAverageScore() {
		MovieAverageScore score = movieService.getMovieAverageScoreById(1);
		System.out.println(score);
	}

	@Disabled("Needs seeded data (database/MovieRating.sql)")
	@Test
	public void testSaveMovieAverageScore() {
		MovieAverageScore score = avgScoreDAO.updateAverage(1);
		System.out.println(score);
	}
}
