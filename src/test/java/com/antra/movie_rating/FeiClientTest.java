package com.antra.movie_rating;

import com.antra.movie_rating.api.response.MovieSearchResponseVO;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.service.feign.OmdbClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FeiClientTest {
	@Autowired
	OmdbClient omdbClient;

	@Test
	public void testFeiOmdb() {
		Map<String, String> params = new HashMap<>();
		params.put("apikey", "27c4caaf");
		params.put("t", "flight");
		params.put("plot", "full");
		Movie result = omdbClient.getMovieByTitle(params);
		System.out.println(result);
	}


	@Test
	public void testFeiOmdbSearch() {
		Map<String, String> params = new HashMap<>();
		params.put("apikey", "27c4caaf");
		params.put("s", "Avenger");
		params.put("plot", "full");
		MovieSearchResponseVO result = omdbClient.getMovieBySearch(params);
		System.out.println(result.getMovies().size());
		System.out.println(result.getTotalResults());
	}
}
