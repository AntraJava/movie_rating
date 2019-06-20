package com.antra.movie_rating.service;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieAverageScore;

import java.util.List;

public interface MovieService {

	Movie searchMovie(MovieCriteria criteria);

	List<Movie> searchMovie(String type);

	MovieAverageScore getMovieAverageScoreById(Integer id);

	List<Movie> searchAllMovies();
}
