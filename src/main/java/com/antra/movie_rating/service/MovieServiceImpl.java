package com.antra.movie_rating.service;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.dao.MovieAverageScoreRepository;
import com.antra.movie_rating.dao.MovieDAO;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieAverageScore;
import com.antra.movie_rating.service.feign.OmdbClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	MovieDAO movieDAO;

	@Autowired
	MovieAverageScoreRepository avgScoreDAO;

	@Autowired
	OmdbClient omdbClient;

	@Override
	@Cacheable(key="#criteria.title", value="movieCache", sync = true)
	@Transactional
	public Movie searchMovie(MovieCriteria criteria) {
		List<Movie> res = movieDAO.findByTitleIgnoreCase(criteria.getTitle());
		if (res.size() > 0) {
			return res.get(0);
		}

		String url = "http://www.omdbapi.com";
		RestTemplate rt = new RestTemplate();

//		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
//				.queryParam("apikey", "27c4caaf")
//				.queryParam("t", criteria.getTitle())
//				.queryParam("plot", "full");
//
//		RequestEntity<Void> request = RequestEntity
//					.get(uriBuilder.build().toUri()).accept(MediaType.APPLICATION_JSON).build();
//		ResponseEntity<Movie> movie = rt.exchange(request, Movie.class);
//		Movie movie = rt.exchange(request, Movie.class);

		Map<String, String> params = new HashMap<>();
		params.put("apikey", "27c4caaf");
		params.put("t", criteria.getTitle());
		params.put("plot", "full");
		Movie movie = omdbClient.getMovieByTitle(params);


		LOGGER.info(movie.toString());
		if (movieDAO.findByImdbIdIgnoreCase(movie.getImdbId()) == null) {
			movieDAO.save(movie);
		}

		return movie;
	}

	@Override
	@Cacheable(value="popularMovieCache", sync = true)
	public List<Movie> searchMovie(String type) {
		List<Movie> result = new ArrayList<>();
		switch (type) {
			case "popular":
				result.add(this.searchMovie(new MovieCriteria("flight")));
				result.add(this.searchMovie(new MovieCriteria("titanic")));
				result.add(this.searchMovie(new MovieCriteria("Hannibal")));
				result.add(this.searchMovie(new MovieCriteria("The Fast and the Furious")));
				result.add(this.searchMovie(new MovieCriteria("Pokemon: Pikachu's Rescue Adventure")));
				break;
			case "cartoon":
				result.add(this.searchMovie(new MovieCriteria("tangled")));
				result.add(this.searchMovie(new MovieCriteria("frozen")));
				result.add(this.searchMovie(new MovieCriteria("uglydolls")));
				result.add(this.searchMovie(new MovieCriteria("zootopia")));
				break;
			case "action":
				result.add(this.searchMovie(new MovieCriteria("rush hour")));
				result.add(this.searchMovie(new MovieCriteria("Avengers: endgame")));
				result.add(this.searchMovie(new MovieCriteria("black panther")));
				result.add(this.searchMovie(new MovieCriteria("Captain Marvel")));
				result.add(this.searchMovie(new MovieCriteria("black panther")));
				break;
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public MovieAverageScore getMovieAverageScoreById(Integer id) {
		return avgScoreDAO.findByMovieId(id);
	}

	@Override
	public List<Movie> searchAllMovies() {
		return movieDAO.findAll();
	}

}
